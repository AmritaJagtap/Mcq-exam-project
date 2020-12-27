package com.hefshine.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hefshine.Entities.Questions;
import com.hefshine.Entities.Tests;
import com.hefshine.Repo.QuestionRepo;
import com.hefshine.Repo.TestRepo;

@Controller
public class admincontro {
	
	@Autowired
	TestRepo trepo;
	@Autowired
	QuestionRepo qrepo;
	Tests t;
	
	@RequestMapping("adminhome")
	public String home(Model m)
	{
		List<Tests>tlist=trepo.findAll();
		m.addAttribute("tlist", tlist);
		return"adminhome.jsp";
	}
	
	@RequestMapping("questionmang{id}")
	public String questionmang(@PathVariable int id,Model m)
	{
		t=trepo.getOne(id);
		List<Questions>qlist=new ArrayList<Questions>(t.getQ());
		List<Questions>qlistdb=qrepo.findAll();
		m.addAttribute("testname", t.getTname());
		m.addAttribute("qlist", qlist);
		m.addAttribute("qlistdb", qlistdb);
		return "questionmang.jsp";
	}
	
	@RequestMapping("addquestion{id}")
	public String addquestion(@PathVariable int id)
	{
		System.out.println(t.getId()+","+id);
		trepo.abcd(t.getId(),id);
		return "forward:/questionmang"+t.getId();
	}
	
	@RequestMapping("removequestion{id}")
	public String removequestion(@PathVariable int id)
	{
		trepo.abcdremove(t.getId(),id);
		return "forward:/questionmang"+t.getId();
	}
	
	@RequestMapping("addtest")
	public String addtest(Model m)
	{
		Tests t2=new Tests();
		m.addAttribute("test",t2);
		return "addtest.jsp";
	}
	
	@RequestMapping("savetest")
	public String savetest(Tests tt)
	{
		trepo.save(tt);
		return "redirect:/adminhome";
		
	}
	

}
