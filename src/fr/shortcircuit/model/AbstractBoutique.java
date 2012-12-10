package fr.shortcircuit.model;

import java.util.ArrayList;

public abstract class AbstractBoutique {

	private String 					nom;
	private ArrayList<Produit>	produits;
		
	public AbstractBoutique(String nom)
	{
		this.nom = nom;
		this.produits = new ArrayList<Produit>();
	}
	
	public String toString()
	{
		String str = new String();
		StringBuffer sb = new StringBuffer();
		
		str = "Boutique :\n\tName : " + this.nom +
				"Produits :";
		
		for (int i = 0; i < this.produits.size(); ++i)
		{
			sb.append("\n\t\t-" + this.produits.get(i).getNom());
		}
		str += sb.toString();

		return str;
	}
		
	public String getNom() { return nom; }
	public ArrayList<Produit> getProduits() { return produits; }
	
	public void setNom(String nom) { this.nom = nom; }
	public void setProduits(ArrayList<Produit> produits) { this.produits = produits; }
}
