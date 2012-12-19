package fr.pc00.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pc00.implement.Product;
import fr.pc00.model.EProductType;
import fr.pc00.model.utils.ProductQuantity;

public class ProductQuantityTest {
	ProductQuantity quantity;
	
	@Before
	public void setUp() throws Exception {
		quantity = new ProductQuantity(new Product("Bananes", 1, EProductType.FOOD), 5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProductQuantity()
	{
		quantity = new ProductQuantity(new Product("Kiwi", 2, EProductType.FOOD), 10);
	}

	@Test
	public void testGetProduct()
	{
		assertEquals(new Product("Bananes", 1, EProductType.FOOD), quantity.getProduct());
	}

	@Test
	public void testGetQuantity()
	{
		assertEquals(5, quantity.getQuantity());
	}

}
