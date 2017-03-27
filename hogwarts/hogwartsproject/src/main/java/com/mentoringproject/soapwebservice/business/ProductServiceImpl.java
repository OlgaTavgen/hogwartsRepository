package com.mentoringproject.soapwebservice.business;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl
{
	List<String> booksList = new ArrayList<>();
	List<String> musicList = new ArrayList<>();
	List<String> moviesList = new ArrayList<>();
	
	public ProductServiceImpl()
	{
		booksList.add("Inferno");
		booksList.add("JoyLand");
		booksList.add("The Game of Thrones");
		
		musicList.add("Inferno");
		musicList.add("JoyLand");
		musicList.add("The Game of Thrones");
		
		moviesList.add("Inferno");
		moviesList.add("JoyLand");
		moviesList.add("The Game of Thrones");
	}
	
	public List<String> getProductCategories()
	{
		List<String> categories = new ArrayList<>();
		categories.add("Books");
		categories.add("Music");
		categories.add("Movies");
		
		return categories;
	}
	
	public List<String> getProducts(String category)
	{
		switch (category.toLowerCase())
		{
		case "books":
			return booksList;
		case "music":
			return musicList;
		case "movies":
			return moviesList;
		}
		return null;
	}
	
	public boolean addProduct(String category, String product)
	{
		switch (category.toLowerCase())
		{
		case "books":
			booksList.add(product);
		case "music":
			musicList.add(product);
		case "movies":
			moviesList.add(product);
		default:
			return false;
		}
	}
}
