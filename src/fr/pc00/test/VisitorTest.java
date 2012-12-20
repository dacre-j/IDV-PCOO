package fr.pc00.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pc00.implement.FoodStall;
import fr.pc00.implement.Game;
import fr.pc00.implement.Product;
import fr.pc00.implement.Visitor;
import fr.pc00.model.AbstractEntertainment;
import fr.pc00.model.AbstractShop;
import fr.pc00.model.EProductType;
import fr.pc00.model.state.EClientState;
import fr.pc00.model.utils.ProductQuantity;

public class VisitorTest
{
	Visitor jacques;
	AbstractShop friandises;
	List<AbstractEntertainment> plan;
	
	@Before
	public void setUp() throws Exception
	{
		Product barbapapa = new Product("Barbapapa", 1, EProductType.FOOD);
		Product hotDogFrite = new Product("Hot-Dog & Frites", 2, EProductType.FOOD);
		Product coca = new Product("Coca-Cola", 1, EProductType.DRINK);
		
		AbstractEntertainment grandHuit = new Game("GrandHuit", 3, 16);
		AbstractShop baraque = new FoodStall("La Baraque a Frites");
		friandises = new FoodStall("Les Friandises de Suzette");
		
		baraque.addProduct(new ProductQuantity(hotDogFrite, 30));
		baraque.addProduct(new ProductQuantity(coca, 40));
		friandises.addProduct(new ProductQuantity(barbapapa, 35));
		
		plan = new ArrayList<AbstractEntertainment>();
		plan.add(grandHuit);
		plan.add(baraque);
		
		jacques = new Visitor("Jacques", 30);
		
		jacques.setPlan(plan);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVisitor() {
		Visitor paul = new Visitor("Paul", 10);
		
		assertNotNull(paul);
	}
	
	@Test
	public void testAddEntertainmentToPlan() {
		jacques.addEntertainmentToPlan(friandises);
		
		assertEquals(true, jacques.getPlan().contains(friandises));
	}

	@Test
	public void testGetPlanString() {
		jacques.addEntertainmentToPlan(friandises);
		String toFind = "Attraction :\n\tName : GrandHuit\n\tPrix : 3\n\tNombre de places : 16\n\tAge Minimum : 0\n\tTaille Minimum : 0.0\n" +
				"Boutique :\n\tName : La Baraque a Frites\n\tProduits :\n\t\t-Hot-Dog & Frites (2)\n\t\t-Coca-Cola (1)\n" +
				"Boutique :\n\tName : Les Friandises de Suzette\n\tProduits :\n\t\t-Barbapapa (1)\n";
		
		assertEquals(toFind, jacques.getPlanString());
	}

	@Test
	public void testGetState() {
		assertEquals(EClientState.VISIT_STARTED, jacques.getState());
	}

	@Test
	public void testSetState() {
		jacques.setState(EClientState.VISIT_ENDED);
		assertEquals(EClientState.VISIT_ENDED, jacques.getState());
	}
	
	@Test
	public void testGetPlan() {
		assertEquals(plan, jacques.getPlan());
	}

	@Test
	public void testSetPlan() {
		List<AbstractEntertainment> plan2 = new ArrayList<AbstractEntertainment>();
		
		jacques.setPlan(plan2);
		assertEquals(plan2, jacques.getPlan());
	}

	@Test
	public void testGetTickets() {
		assertEquals(30, jacques.getTickets());
	}

	@Test
	public void testSetTickets() {
		jacques.setTickets(10);
		assertEquals(10, jacques.getTickets());
	}
	
	@Test
	public void testGetNumber() {
		assertEquals(0, jacques.getNumber());
	}

	@Test
	public void testGetName() {
		assertEquals("Jacques", jacques.getName());
	}
	
	@Test
	public void testToString() {
		String answer = "Hi ! I'm Jacques.\n" +
				"\tThere is 0 other people with me.\n" +
				"\tI have 30 tickets in my wallet.";
		assertEquals(answer, jacques.toString());
	}

}
