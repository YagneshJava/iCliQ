package com.task.v1.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.task.v1.bean.ProductBean;

public class ProductFilter {

	
	public static Specification<ProductBean> getProductsByCat(String category) {
		return new Specification<ProductBean>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<ProductBean> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				if (category != null && !("").equals(category.trim())) {
					predicateList.add(cb.equal(root.get("category"), category.trim()));
				}
				
//				query.orderBy(cb.desc(root.get("createdAt")));
				return cb.and(predicateList.toArray(new Predicate[0]));
			}
		};
	}
}
