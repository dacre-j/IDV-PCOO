package fr.pc00.model.state;

import fr.pc00.implement.Visitor;
import fr.pc00.model.validation.InvalidException;


public class ClientStateMachine {
	
	public static void changeStep(IStateChangeable statedReference)
			throws InvalidException
	{	
		EClientState 	nextState = null;
		String			temp;
		
		temp = statedReference.getState().getNextStepState(
				((Visitor)statedReference).nextEntertainment());
		if (temp == null)
			throw new InvalidException("There is no more states.");
		switch (temp)
		{
		case "VISIT_STARTED" :
			nextState = EClientState.VISIT_STARTED;
			break;
		case "VISIT_ATTRACTION" :
			nextState = EClientState.VISIT_ATTRACTION;
			break;
		case "VISIT_SHOP" :
			nextState = EClientState.VISIT_SHOP;
			break;
		default :
			nextState = EClientState.VISIT_ENDED;
			break;
		}
		statedReference.valid(nextState);
		statedReference.setState(nextState);
	}
}
