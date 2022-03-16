package com.task.v1.service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.task.v1.bean.ProductBean;
import com.task.v1.dao.ProductsDao;

@Service
@Transactional
public class ProductsService extends ProductFilter{

	
	@Autowired
	private ProductsDao productDao;

	public ProductBean saveProductBean(ProductBean product) throws Exception{
		
		ProductBean bean = null;
		try {
			
			if(null != product) {
				if(null != product.getId()) {
					bean = productDao.save(product);
				}else {
					product.setId(UUID.randomUUID().toString());
					bean = productDao.save(product);
				}
			}
			
		} finally {
		}
		return bean;
	}

	public List<ProductBean> getProducts(String category) throws Exception{
		try {
			Pageable paging = PageRequest.of(0, 5, Sort.by("createdAt").descending());
			List<ProductBean> beans = productDao.findAll(getProductsByCat(category), paging);
			return beans;
		} finally {
			// TODO: handle finally clause
		}
	}
	
	
}
