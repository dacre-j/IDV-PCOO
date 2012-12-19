package fr.pc00.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pc00.model.*;
import fr.pc00.implement.*;

public class AbstractEntertainmentTest {
	AbstractEntertainment attraction;
	AbstractEntertainment shop;
	
	@Before
	public void setUp() throws Exception {
		attraction = new Game("Grand Huit", 2, 12);
		shop = new FoodStall("Bananeraie");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAbstractEntertainment() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
