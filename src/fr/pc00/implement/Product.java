package fr.pc00.implement;

import fr.pc00.model.EProductType;

public class Product {

	private String 			_name;
	private int				_price;
	private EProductType	_type;
		
	public Product(String name, int price, EProductType type)
	{
		this._name = name;
		this._price = price;
		this._type = type;
	}
	
	public String toString()
	{
		return "Produit (" + this._type + "):\n\tName : " + this._name +
				"\n\tPrix : " + this._price;
	}
		
	public int getPrice() { return (this._price); }
	public String getName() { return (this._name); }
	public EProductType getType() { return (this._type); }
		
	public void setPrice(int prix) {	this._price = prix; }
	public void setName(String nom) { this._name = nom; }
	public void setType(EProductType type) { this._type = type; }
}
