package fr.pc00.implement;

import java.util.ArrayList;
import java.util.List;

import fr.pc00.model.AbstractAttraction;
import fr.pc00.model.AbstractEntertainment;
import fr.pc00.model.AbstractShop;
import fr.pc00.model.EEntertainmentType;
import fr.pc00.model.state.EClientState;
import fr.pc00.model.state.IStateChangeable;
import fr.pc00.model.utils.ProductQuantity;
import fr.pc00.model.validation.InvalidException;

public class Visitor implements IStateChangeable
{
	private List<AbstractEntertainment>	_plan;
	private EClientState				_state;
	private String						_name;
	private int							_number;
	private int							_tickets;

	public Visitor(String name, int money)
	{
		this._plan = new ArrayList<AbstractEntertainment>();
		this._state = EClientState.VISIT_STARTED;
		this._name = name;
		this._number = 0;
		this._tickets = money;
	}
	
	public void valid(EClientState state) throws InvalidException
	{
		if (state == null)
			throw new InvalidException("Can't execute next state.");
	}

	public EClientState nextEntertainment() throws InvalidException
	{
		AbstractEntertainment current;
		
		if (this._plan.size() < this._number + 1)
			return (EClientState.VISIT_ENDED);
		
		this._state = EClientState.VISIT_STARTED;
		
		current = this._plan.get(this._number);
		if (current.getType() == EEntertainmentType.ATTRACTION)
		{
			AbstractAttraction attraction = (AbstractAttraction)current;
			
			if (this._tickets - (attraction.getPrice() * this._number) < 0)
				throw new InvalidException("No more tickets ! Too bad...");
			else
				this._tickets -= (attraction.getPrice() * this._number);
		}
		else if (current.getType() == EEntertainmentType.SHOP)
		{
			AbstractShop shop = (AbstractShop)current;
			ArrayList<ProductQuantity> products = shop.getProducts();
			int totalPrice = 0;
			
			for (int i = 0; i < products.size(); i++)
			{
				totalPrice += products.get(i).getProduct().getPrice() * this._number;
			}
			if (this._tickets - totalPrice < 0)
				throw new InvalidException("No more tickets ! Too bad...");
			else
				this._tickets -= totalPrice;
		}
		++this._number;

		return (current.getState());
	}
	
	public void addEntertainmentToPlan(AbstractEntertainment entertainment)
	{
		if (_plan == null)
			_plan = new ArrayList<AbstractEntertainment>();
		_plan.add(entertainment);
	}
	
	public String getPlanString()
	{
		String str = "Todo List :";
		
		for (int i = this._number; i < this._plan.size(); i++)
		{
			str += "\n\t" + i + "-" + this._plan.get(i).getName();
		}
		return (str);
	}
	
	public String toString()
	{
		return "Hi ! I'm " + this._name +
				".\n\tThere is " + this._number +
				" other people with me.\n\tI have " + this._tickets + " tickets in my wallet.";
	}
	
	public List<AbstractEntertainment> getPlan() { return this._plan; }
	public EClientState getState() { return this._state; }
	public String getName() { return _name; }
	public int getNumber() { return _number; }
	public int getTickets() { return _tickets; }

	public void setTickets(int _tickets) { this._tickets = _tickets; }
	public void setPlan(List<AbstractEntertainment> plan) { this._plan = plan; }
 	public void setState(EClientState state) { this._state = state; }
}
