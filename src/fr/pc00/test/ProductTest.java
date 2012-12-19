package fr.pc00.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pc00.implement.*;
import fr.pc00.model.EProductType;

public class ProductTest {
	Product product;
	
	@Before
	public void setUp() throws Exception
	{
		product = new Product("Bananes", 1, EProductType.FOOD);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testProduct()
	{
		product = new Product("Bananes", 42, EProductType.FOOD);
	}

	@Test
	public void testToString()
	{
		assertEquals("Produit (FOOD):\n\tName : Bananes\n\tPrix : 1", product.toString());
	}

	@Test
	public void testGetPrice()
	{		
		assertEquals(1, product.getPrice());
	}

	@Test
	public void testGetName() 
	{		
		assertEquals("Bananes", product.getName());
	}

	@Test
	public void testGetType() 
	{	
		assertEquals(EProductType.FOOD, product.getType());
	}

	@Test
	public void testSetPrice() 
	{
		product.setPrice(2);
		assertEquals(2, product.getPrice());
	}

	@Test
	public void testSetName() 
	{		
		product.setName("Kiwi");
		assertEquals("Kiwi", product.getName());
	}

	@Test
	public void testSetType()  
	{	
		product.setType(EProductType.DRINK);
		assertEquals(EProductType.DRINK, product.getType());
	}

}
