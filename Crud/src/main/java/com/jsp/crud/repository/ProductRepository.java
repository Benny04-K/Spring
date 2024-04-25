package com.jsp.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.crud.dao.Product;

public interface ProductRepository extends JpaRepository<Product,Long>
{
	
	
	
}
