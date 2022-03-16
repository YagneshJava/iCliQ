package com.task.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.v1.bean.ProductBean;
import com.task.v1.service.ProductsService;

@RestController
public class ProductsController {

	
	@Autowired
	private ProductsService productService;
	
	@RequestMapping(value = "/saveProducts", consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<?> saveProduct(@RequestBody ProductBean product) {
		try {
			return new ResponseEntity<>(productService.saveProductBean(product),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getProducts/{category}")
	@ResponseBody
	public ResponseEntity<?> getProducts(@PathVariable String category) {
		try {
			return new ResponseEntity<>(productService.getProducts(category),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
