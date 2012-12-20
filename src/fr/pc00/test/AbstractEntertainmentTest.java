package fr.pc00.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pc00.model.*;
import fr.pc00.model.state.EClientState;
import fr.pc00.model.utils.ProductQuantity;
import fr.pc00.implement.*;

public class AbstractEntertainmentTest {
	AbstractEntertainment attraction;
	AbstractEntertainment shop;
	
	@Before
	public void setUp() throws Exception {
		attraction = new Game("Grand Huit", 2, 12);
		shop = new FoodStall("Bananeraie");
		((FoodStall)shop).addProduct(new ProductQuantity(new Product("Bananes", 1, EProductType.FOOD), 30));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbstractEntertainment() {
		AbstractEntertainment attraction2 = new Game("Grand Splash", 2, 12);
		
		assertNotNull(attraction2);
	}

	@Test
	public void testGetType() {
		assertEquals(EEntertainmentType.ATTRACTION, attraction.getType());
		assertEquals(EEntertainmentType.SHOP, shop.getType());
	}

	@Test
	public void testGetState() {
		assertEquals(EClientState.VISIT_ATTRACTION, attraction.getState());
		assertEquals(EClientState.VISIT_SHOP, shop.getState());
	}

	@Test
	public void testToString() {
		String testAtt = "Attraction :\n\tName : Grand Huit\n\tPrix : 2\n\tNombre de places : 12\n\tAge Minimum : 0\n\tTaille Minimum : 0.0";
		String testShop = "Boutique :\n\tName : Bananeraie\n\tProduits :\n\t\t-Bananes (1)";
		
		assertEquals(testAtt, attraction.toString());
		assertEquals(testShop, shop.toString());
	}

}
