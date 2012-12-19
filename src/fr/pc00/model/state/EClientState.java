package fr.pc00.model.state;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public enum EClientState
{
	VISIT_ENDED("VISIT_ENDED"),
	VISIT_SHOP("VISIT_SHOP", new ArrayList<String>() {{
		add("VISIT_ENDED");
		add("VISIT_SHOP");
		add("VISIT_ATTRACTION");
	}}),
	VISIT_ATTRACTION("VISIT_ATTRACTION", new ArrayList<String>() {{
		add("VISIT_ENDED");
		add("VISIT_SHOP");
		add("VISIT_ATTRACTION");
	}}),
	VISIT_STARTED("VISIT_STARTED", new ArrayList<String>() {{
		add("VISIT_ENDED");
		add("VISIT_SHOP");
		add("VISIT_ATTRACTION");
	}}),
	VISIT_NULL("Visite null");
	
	private List<String>	_nextStepStates;
	private String 				_state;
	
	private EClientState(String state)
	{
		this._state = state;
		this._nextStepStates = new ArrayList<String>();
	}
	
	private EClientState(String state, List<String> nextStepStates)
	{
		this._state = state;
		this._nextStepStates = nextStepStates;
	}

	public String getState() { return _state; }

	public String getNextStepState(EClientState state)
	{
		System.out.println(this._nextStepStates.toString());
		if (state.equals(VISIT_ENDED) || state.equals(VISIT_NULL))
			return (null);
		if (this._nextStepStates.size() == 1)
			return (this._nextStepStates.get(0));
		if (this._nextStepStates.contains(state._state))
		{
			return (this._nextStepStates.get(this._nextStepStates.lastIndexOf(state._state)));
		}
		return (null);
	}	
}
