package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.cg.entity.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

	@Modifying
	@Query(value = "DELETE FROM Category  Where CategoryId = :CategoryId")
	void removeCategory(@Param("CategoryId") int CategoryId);

	
}