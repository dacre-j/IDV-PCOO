package fr.pc00.model;

import fr.pc00.model.state.EClientState;

public abstract class AbstractAttraction extends AbstractEntertainment
{
	private int	_price;
	private int	_place;
		
	public AbstractAttraction(String name, int price, int place)
	{
		super(name, EClientState.VISIT_ATTRACTION, EEntertainmentType.ATTRACTION);
		this._price = price;
		this._place = place;
	}
	
	public String toString()
	{
		return "Attraction :\n\tName : " + this._name +
				"\n\tPrix : " + this._price +
				"\n\tNombre de places : " + this._place;
	}
		
	public int getPrice() { return this._price; }
	public int getPlace() {	return this._place; }
	public String getName() { return this._name; }
		
	public void setPrice(int price) { this._price = price; }
	public void setPlace(int place) { this._place = place; }
	public void setName(String name) { this._name = name; }
}
