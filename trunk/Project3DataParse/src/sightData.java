import processing.core.*;



/*
 * 
Date / Time
City
State
Shape
Duration
Summary
Posted
 */
public class sightData extends PApplet
{
	//Instance variables
	public String dateHappened;
	public String city;
	public String state;
	public String shape;
	public String duration;
	public String summary;
	public String datePosted;
	public int hourHappened;
	public int minHappened;
	
	public sightData()
	{
		
	}
	
	
	public sightData(String happened,String theCity,String theState,String theShape, String theDuration, String theSummary,String posted)
	{
		dateHappened = happened;
		city = theCity;
		state = theState;
		shape = theShape;
		duration = theDuration;
		summary = theSummary;
		datePosted = posted;
	}
	
	public String toString()
	{
		String sp = " ";
		return dateHappened + sp + city + sp + state + sp + shape + duration + summary + datePosted;
	}
	
}
