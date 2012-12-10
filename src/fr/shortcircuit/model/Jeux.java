package fr.shortcircuit.model;

public class Jeux extends AbstractAttraction{

	private int				ageMin;
	private float			tailleMin;
		
	public Jeux(String nom, int prix, int place)
	{
		super(nom, prix, place);
		this.ageMin = 0;
		this.tailleMin = 0f;
	}
	
	public Jeux(String nom, int prix, int place, int ageMin, float tailleMin)
	{
		super(nom, prix, place);
		this.ageMin = ageMin;
		this.tailleMin = tailleMin;
	}
	
	public String toString()
	{
		return super.toString() + "\n\tAge Minimum : " + this.ageMin +
				":\n\tTaille Minimum : " + this.tailleMin;
	}

	public int getAgeMin() { return ageMin; }
	public float getTailleMin() { return tailleMin; }

	public void setAgeMin(int ageMin) { this.ageMin = ageMin; }
	public void setTailleMin(float tailleMin) { this.tailleMin = tailleMin; }		
}
