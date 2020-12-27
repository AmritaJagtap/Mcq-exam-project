package com.hefshine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.Entities.Students;

public interface StudentRepo extends JpaRepository<Students, Integer>{

	public Students findByUserName(String userName);
}
