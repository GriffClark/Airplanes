
public class Airplane {
	
	public enum AirplaneType {
		Commercial, Private, Military, Cargo
	}
	
	protected int maxPassengers;
	protected int passengers;
	protected double cargo; //let's say in kg
	protected double maxCargo;
	protected boolean hasSecureCargo; //for simplicity sake secureCargo weight can go in with cargo weight
	protected AirplaneType type;
	protected int speed;
	protected int maxFuel;
	protected String name;
	protected int tailNumber;
	protected int currentFuel;
	protected boolean isGrounded;
	protected int range;
	protected int distancePerFuel;
	
	public int getRange() 
	{
		//distancePerFuel is how quickly fuel is used
		//speed is how quickly the plane moves
		//current fuel is how much gas is left in the tank
		
		
		int range = distancePerFuel * speed * currentFuel;
		return range;
		//this will be used when destinations are being chosen
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
		return speed;
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
	
	//need syntax help --> this check is supposed to determine whether or not the plane is a cargo plane 
//	public boolean isCargoPlane()
//	{
//		if (Airplane.AirplaneType.Cargo)
//		{
//			return true;
//		}
//		
//		else
//		{
//			return false;
//		}
//	}
//	
	

	
	public String toString()
	{
		return name+ " \tPassengers: " + passengers + "\tCargo (in kg): " + cargo + "tail number: " + tailNumber;
	}
	
	

}
