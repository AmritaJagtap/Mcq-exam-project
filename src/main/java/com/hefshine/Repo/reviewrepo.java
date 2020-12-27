package com.hefshine.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.Entities.Review;

public interface reviewrepo extends JpaRepository<Review, Integer>{
	
	public List<Review> findByStudentsIdAndTestsId(int sid,int tid);

}
