import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

public class Airplane extends Position{

	public enum AirplaneType {
		Commercial, Private, Military, Cargo
	}

	protected int maxPassengers;
	protected int passengers;
	protected double cargo; //let's say in kg
	protected double maxCargo;
	protected boolean hasSecureCargo; //for simplicity sake secureCargo weight can go in with cargo weight
	protected AirplaneType type;
	protected int maxSpeed;
	protected int currentSpeed;
	protected int maxFuel;
	protected String name; //"Airbus A380"
	protected int tailNumber; //1770104
	protected int currentFuel;
	protected boolean isGrounded;
	protected int range;
	protected int distancePerFuel;
	protected int[][] rangeMap = new int[50][2];
	protected String location;

	public int getRange()
	{
		int range = distancePerFuel* currentFuel;
		//if you go a certian speed your distance goes down make this a calc problem
		return range;
		//this will be used when destinations are being chosen
	}
	
	public void setLocation (String location)
	{
		this.location = location;
	}
	
	public String getLocation()
	{
		return location;
	}


	public Airplane()
	{

	}
	

	public void touchDown()
	{
		isGrounded = true;
	}

	public void takeOff()
	{
		isGrounded = false;
	}

	public boolean isGrounded()
	{
		return isGrounded;
	}


	public int getTailNumber(){
		return tailNumber;
	}


	public boolean hasPassengers()
	{
		boolean hasPassengers;
		if (passengers > 0)
		{
			hasPassengers = true;
		}
		else
		{
			hasPassengers = false;
		}
		return hasPassengers;
	}

	public int getFuel()
	{
		return currentFuel;
	}

	public void addFuel(int modifier)
	{
		currentFuel += modifier;
	}

	public void loseFuel()
	//default method
	{
		currentFuel -= 1;
	}

	public void addFuel()
	{
		//to call every time I want to refuel
		currentFuel += 1;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public int getSpeed()
	{
		return maxSpeed;
	}

	public boolean hasCargo()
	{

		if (cargo > 0)
		{
		return true;
		}
		else
		{
			return false;
		}
	}

	public int getMaxPassengers()
	{
		return maxPassengers;
	}


	public String toString()
	{
		return name+ " \tPassengers: " + passengers + "\tCargo (in kg): " + cargo + "tail number: " + tailNumber;
	}
	
	public int generateTailNumber()
	{
		int tailNumber = (int)(Math.random() * 100000);
		return tailNumber;
	}

	public int[] getPossibleSpeeds()
	//this will return a list of all possible speeds the plane can go 
	//I think this will be faster then running the fuel efficiency equation every time
	{
		int[] values = new int[1];
		for (int i = 0; i < rangeMap[0].length; i++)
		{
			values[i] = rangeMap[0][i];
		}
		
		return values;
	}
	

}
