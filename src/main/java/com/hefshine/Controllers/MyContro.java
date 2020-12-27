package com.hefshine.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefshine.Entities.Questions;
import com.hefshine.Entities.Result;
import com.hefshine.Entities.Review;
import com.hefshine.Entities.Students;
import com.hefshine.Entities.Tests;
import com.hefshine.Entities.trcombo;
import com.hefshine.Repo.StudentRepo;
import com.hefshine.Repo.TestRepo;
import com.hefshine.Repo.resultrepo;
import com.hefshine.Repo.reviewrepo;

@Controller
public class MyContro {

	@Autowired
	StudentRepo srepo;
	
	@Autowired
	HttpSession hs;
	
	@Autowired
	TestRepo trepo;
	
	@Autowired
	resultrepo rrepo;
	
	@Autowired
	reviewrepo rerepo;
	
	Tests t;
	Set<Questions> qset;
	List<Questions> qlist;
	List<Questions> qlistdb;
	
	@RequestMapping("/")
	public String login(Model m)
	{
		Students s = new Students();
		m.addAttribute("student", s);
		return "login.jsp";
	}
	
	@RequestMapping("loginVerify")
	public String loginVerify(Students s)
	{
		try
		{
			Students sd = srepo.findByUserName(s.getUserName());
			
			if(sd.getPassword().compareTo(s.getPassword())==0)
			{
				hs.setAttribute("id", sd.getId());
				hs.setAttribute("role", sd.getRole());
				if(sd.getRole()==2)
				{
					return "redirect:/adminhome";
				}
				else
				{
					return "redirect:/home";
				}
			}
			else
			{
				return "redirect:/";
			}
		}
		catch(Exception e)
		{
			return "redirect:/";
		}
	}
	
	@RequestMapping("home")
	public String home(Model m)
	{
		List<trcombo> trlist=new ArrayList<trcombo>();
		List<Tests> tlist = trepo.findAll();
		List<Result> rlist=rrepo.findByStudentId((int)hs.getAttribute("id"));
		for(int i=0;i<tlist.size();i++)
		{
			
			trcombo tr=new trcombo();
			tr.testid=tlist.get(i).getId();
			tr.name=tlist.get(i).getTname();
			tr.attemped=false;
			for(int j=0;j<rlist.size();j++)
			{
				if(rlist.get(j).getTest().getId()==tr.testid)
				{
					tr.attemped=true;
					tr.marks=rlist.get(i).getMarks();
					break;
				}
			}
			trlist.add(tr);
		}
		m.addAttribute("trlist", trlist);
		m.addAttribute("tlist", tlist);
		m.addAttribute("rlist", rlist);
		
		return "home.jsp";
	}
	
	@RequestMapping("logout")
	public String logout()
	{
		hs.removeAttribute("id");
		return "redirect:/";
	}
	
	
	
	@RequestMapping("attempt{id}")
	public String attempt(@PathVariable int id ,Model m)
	{
		t = trepo.getOne(id);
		qset = t.getQ();
		qlist = new ArrayList<Questions>(qset);
		for(Questions p:qlist)
		{
			p.setAns(0);
		}
		oldqnum=1;
		return "forward:/0testLoop1";
	}
	
	
	int oldqnum=1;
	
	@RequestMapping("{ans}testLoop{newqnum}")
	public String testloop(@PathVariable int ans,@PathVariable int newqnum,Model m)
	{
		System.out.println("I am in testLoop");
		qlist.get(oldqnum-1).setAns(ans);
		
		if(newqnum==1000)
		{
			return "redirect:/submit";
		}
		Questions q=qlist.get(newqnum-1);
		m.addAttribute("question", q);
		m.addAttribute("size", qlist.size());
		oldqnum=newqnum;
		return"testPage.jsp";
		
	}
	
	
	@RequestMapping("submit")
	public String submit(Model m)
	{
		Tests td = trepo.getOne(t.getId());
		qlistdb = new ArrayList<Questions>(td.getQ());
		
		int marks=0;
		for(int ui=0;ui<qlist.size();ui++)
		{
			for(int di=0;di<qlistdb.size();di++)
			{
				System.out.println(qlist.get(ui).getId()+" "+ qlistdb.get(di).getId() +" "+ qlist.get(ui).getAns()+" "+ qlistdb.get(di).getAns());
				if(qlist.get(ui).getId() == qlistdb.get(di).getId() && qlist.get(ui).getAns() == qlistdb.get(di).getAns())
					marks++;
				
			}
		}
		m.addAttribute("marks", marks);
		Result r=new Result();
		r.setMarks(marks);
		r.setTest(t);
		int a=(int)hs.getAttribute("id");
		//r.setStudent(srepo.getOne(a));
		Students s=srepo.getOne(a);
		r.setStudent(s);
		rrepo.save(r);
		for (int i = 0; i <qlistdb.size(); i++) 
		{
			Review re=new Review();
			re.tests=t;
			re.students=s;
			re.question=qlistdb.get(i);
			
			for (int j = 0; j < qlist.size(); j++) 
			{
				if(qlistdb.get(i).getId()==qlist.get(j).getId())
				{
					re.userchoice=qlist.get(j).getAns();
				}
			}
			rerepo.save(re);
		}
		
		return "forward:/home";
	}
	
	
	@RequestMapping("review{testid}")
	public String review(@PathVariable int testid,Model m)
	{
		int sid=(int)hs.getAttribute("id");
		List<Review> rlist=rerepo.findByStudentsIdAndTestsId(sid, testid);
		m.addAttribute("rlist", rlist);
		return "review.jsp";
	}
		
		
}
