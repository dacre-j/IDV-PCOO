package fr.pc00.model;

import fr.pc00.model.state.EClientState;

public abstract class AbstractEntertainment
{
	String 				_name;
	EClientState 		_state;
	EEntertainmentType 	_type;
	
	public AbstractEntertainment(String name, EClientState state, EEntertainmentType type)
	{
		this._name = name;
		this._state = state;
		this._type = type;
	}
		
	public EEntertainmentType getType() { return (this._type); }
	public EClientState getState() { return (this._state); }
	
	public abstract String getName();
	public abstract String toString();
}
