package com.hefshine.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.Entities.Questions;

public interface QuestionRepo extends JpaRepository<Questions, Integer>{

}
