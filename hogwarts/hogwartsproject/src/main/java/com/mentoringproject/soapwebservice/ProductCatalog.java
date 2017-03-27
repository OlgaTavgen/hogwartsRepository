package com.mentoringproject.soapwebservice;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mentoringproject.soapwebservice.business.ProductServiceImpl;

@WebService
public class ProductCatalog
{
	ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	@WebMethod
	public List<String> getProductCategories()
	{
		return productServiceImpl.getProductCategories();
	}
	
	@WebMethod(exclude=true)
	public List<String> getProducts(String category)
	{
		return productServiceImpl.getProducts(category);
	}
	
	@WebMethod(exclude=true)
	public boolean addProducts(String category, String product)
	{
		return productServiceImpl.addProduct(category, product);
	}
}
