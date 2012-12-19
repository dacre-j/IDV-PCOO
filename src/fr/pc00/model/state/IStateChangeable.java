package fr.pc00.model.state;

import fr.pc00.model.validation.IValid;

public interface IStateChangeable extends IValid
{
	public EClientState getState();
	public void			setState(EClientState state);
}
