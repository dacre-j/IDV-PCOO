package fr.pc00.test;

import java.util.ArrayList;
import java.util.List;

import fr.pc00.implement.*;
import fr.pc00.model.*;
import fr.pc00.model.state.ClientStateMachine;
import fr.pc00.model.utils.ProductQuantity;
import fr.pc00.model.validation.InvalidException;

public class Main 
{
	public static void main(String[] args)
	{
		buildEntities();
	}

	public static void buildEntities()
	{
		Product barbapapa = new Product("Barbapapa", 1, EProductType.FOOD);
		Product hotDogFrite = new Product("Hot-Dog & Frites", 2, EProductType.FOOD);
		Product water = new Product("Water", 0, EProductType.DRINK);
		Product coca = new Product("Coca-Cola", 1, EProductType.DRINK);

		System.out.println(coca.toString());
		
		AbstractEntertainment grandHuit = new Game("GrandHuit", 3, 16);
		AbstractEntertainment grandSplash = new Game("GrandSplash", 3, 8);
		AbstractEntertainment tirAuFusil = new Game("TirAuFusil", 1, 8);
		AbstractEntertainment grandeRoue = new Show("GrandeRoue", 24);
		AbstractShop fontaine = new FoodStall("Fontaine a eau");
		AbstractShop baraque = new FoodStall("La Baraque a Frite");
		AbstractShop friandises = new FoodStall("Les Friandises de Suzette");
		
		baraque.addProduct(new ProductQuantity(hotDogFrite, 30));
		baraque.addProduct(new ProductQuantity(coca, 40));
		fontaine.addProduct(new ProductQuantity(water, -1));
		friandises.addProduct(new ProductQuantity(barbapapa, 35));
		
		List<AbstractEntertainment> plan = new ArrayList<AbstractEntertainment>();
		plan.add(grandHuit);
		plan.add(baraque);
		plan.add(grandSplash);
		plan.add(tirAuFusil);
		plan.add(grandHuit);
		plan.add(fontaine);
		plan.add(friandises);
		plan.add(grandeRoue);
		
//		Visitor jacques = new Visitor(30);
//		
//		try {
//			ClientStateMachine.changeStep(jacques);
//		} catch (InvalidException e) {
//			System.out.println(e.getMessage());
//		}

		Visitor pierre = new Visitor(30);
		pierre.setPlan(plan);

		try {
			//System.out.println(pierre.getPlanString());
			ClientStateMachine.changeStep(pierre);
			//System.out.println(pierre.getPlanString());
			ClientStateMachine.changeStep(pierre);
			ClientStateMachine.changeStep(pierre);
			ClientStateMachine.changeStep(pierre);
			//System.out.println(pierre.getPlanString());
		} catch (InvalidException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\r\nMain: after re-setting the mandatory reference, order state is now: " + pierre.getState().toString());
	
		
	}
}
