package com.hefshine.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.Entities.Result;

public interface resultrepo extends JpaRepository<Result, Integer>{
	
	public List<Result>findByStudentId(int id);
	
}
