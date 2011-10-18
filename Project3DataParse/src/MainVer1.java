import processing.core.*;
import java.util.HashMap;
import java.util.ArrayList;
import codeanticode.glgraphics.*;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.*;
import de.fhpotsdam.unfolding.utils.*;



public class MainVer1 extends PApplet 
{
	//Stuff from Simple Map example...
	de.fhpotsdam.unfolding.Map map;
	Location locationBerlin = new Location(52.5f, 13.4f);
	Location locationLondon = new Location(51.5f, 0f);

	
	//<Shadow> stuff
	String[] currentDataFile;
	ArrayList<sightData> sightList = new ArrayList<sightData>();
	ArrayList<Object> buttonList = new ArrayList<Object>(); //Change object to the button object that is created.
	
	public void setup() 
	{
		//size(800, 600, GLConstants.GLGRAPHICS);
		size(1280,700,GLConstants.GLGRAPHICS);
		noStroke();

		map = new de.fhpotsdam.unfolding.Map(this);
		map.setTweening(true);
		map.zoomToLevel(3);
		map.panTo(new Location(40f, 8f));
		MapUtils.createDefaultEventDispatcher(this, map);
		
		//Let all of the map stuff setup before configuring data.
		setupData();
		for(int index=0; index < sightList.size();index++)
		{
			println("Index " + index + ": " + sightList.get(index));
		}
		
		//Based on the slightly odd behavior of the map setup, it may
		//be best to make sure to configure all of my data structures 
		//to create file representations of themselves to be read in
		//at the beginning of the program.

	}

	public void draw() 
	{
		background(0);
		map.draw();

		fill(128);
		rect(0,0,200,768);
		// Draws locations on screen positions according to their geo-locations.

		// Fixed-size marker
		float xyBerlin[] = map.getScreenPositionFromLocation(locationBerlin);
		fill(0, 200, 0, 100);
		ellipse(xyBerlin[0], xyBerlin[1], 20, 20);

		// Zoom dependent marker size
		float xyLondon[] = map.getScreenPositionFromLocation(locationLondon);
		fill(200, 0, 0, 100);
		float s = map.getZoom();
		ellipse(xyLondon[0], xyLondon[1], s, s);
	  
	  
		fill(0);
		rect(0,600,50,50);
	}
	
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
	public void setupData()
	{
		String dateTime = "";
		String city = "";
		String state = "";
		String shape = "";
		String duration = "";
		String summary = "";
		String posted = "";
		currentDataFile = loadStrings("sampleSight1.txt");
		println("Size: " + currentDataFile.length);
		for(int index=0;index < currentDataFile.length;index++)
		{
			//println("Line " + index + ": " + currentDataFile[index]);
			//println("Mod: " + (index%7));
			if((index%7) == 0)
			{
				//Line 1
				dateTime = currentDataFile[index];
			}
			else if((index%7) == 1)
			{
				//Line 2
				city = currentDataFile[index];
			}
			else if((index%7) == 2)
			{
				//Line 3
				state = currentDataFile[index];
			}
			else if((index%7) == 3)
			{
				//Line 4
				shape = currentDataFile[index];
			}
			else if((index%7) == 4)
			{
				//Line 5
				duration = currentDataFile[index];
			}
			else if((index%7) == 5)
			{
				//Line 6
				summary = currentDataFile[index];
			}
			else if((index%7) == 6)
			{
				//Line 7
				posted = currentDataFile[index];
				sightData newSight = new sightData(dateTime,city,state,shape,duration,summary,posted);
				sightList.add(newSight);	
			}
		}

	}

}
