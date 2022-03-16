package com.task.v1.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.task.v1.bean.ProductBean;

public interface ProductsDao extends JpaRepository<ProductBean, String>{

	List<ProductBean> findAll(Specification<ProductBean> products, Pageable paging);

}
