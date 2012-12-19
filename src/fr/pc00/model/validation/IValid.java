package fr.pc00.model.validation;

import fr.pc00.model.state.EClientState;

public interface IValid
{
	public void valid(EClientState state) throws InvalidException;
}
