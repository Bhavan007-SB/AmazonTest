package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonpages 
{
	 WebDriver Driver;
	 
	 @FindBy(id="twotabsearchtextbox")
	 public static WebElement SearchBox;
	
	 @FindBy(id="searchDropdownBox")
	 public static WebElement Categories;
	 
	 
	 public Amazonpages(WebDriver Driver)
	 {
		this.Driver=Driver;
		PageFactory.initElements(Driver,this); 
	 }
}
