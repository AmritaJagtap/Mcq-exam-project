package com.hefshine.Repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hefshine.Entities.Tests;

public interface TestRepo extends JpaRepository<Tests, Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO tests_q (`t_id`, `q_id`) VALUES (?1, ?2)",nativeQuery=true)
	void abcd(int testid,int qid);
		
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM tests_q WHERE (`t_id` = ?1) and (`q_id` = ?2)",nativeQuery=true)
	void abcdremove(int testid,int qid);
			
}
