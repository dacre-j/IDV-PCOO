package fr.shortcircuit.model;

public abstract class AbstractAttraction {

	private String nom;
	private int	prix, place;
		
	public AbstractAttraction(String nom, int prix, int place)
	{
		this.nom = nom;
		this.prix = prix;
		this.place = place;
	}
	
	public String toString()
	{
		return "Attraction :\n\tName : " + nom +
				"\n\tPrix : " + prix +
				"\n\tNombre de places : " + place;
	}
		
	public int getPrix() { return prix;	}
	public int getPlace() {	return place; }
	public String getNom() { return nom; }
		
	public void setPrix(int prix) {	this.prix = prix; }
	public void setPlace(int place) { this.place = place; }
	public void setNom(String nom) { this.nom = nom; }
}
