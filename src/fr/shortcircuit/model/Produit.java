package fr.shortcircuit.model;

public class Produit {

	private String 			nom;
	private int				prix;
	private ETypeProduit	type;
		
	public Produit(String nom, int prix, ETypeProduit type)
	{
		this.nom = nom;
		this.prix = prix;
		this.type = type;
	}
	
	public String toString()
	{
		return "Produit (" + this.type + "):\n\tName : " + this.nom +
				"\n\tPrix : " + this.prix;
	}
		
	public int getPrix() { return prix;	}
	public String getNom() { return nom; }
	public ETypeProduit getType() { return type; }
		
	public void setPrix(int prix) {	this.prix = prix; }
	public void setNom(String nom) { this.nom = nom; }
	public void setType(ETypeProduit type) { this.type = type; }
}
