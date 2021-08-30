package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.*;

@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
	
	@Query("SELECT t FROM ACCOUNT t")
   List<Account> findbyid();
	
	@Query("SELECT t FROM ACCOUNT t WHERE t.id = ?1")
	   ArrayList<Account> findbyid(long id);
	
	
}
