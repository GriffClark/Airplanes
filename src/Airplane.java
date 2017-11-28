
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
	protected String name;
	protected int tailNumber;
	
	public Airplane()
	{
		
	}
	
	public Airplane(int maxPassengers, int passengers, double cargo, double maxCargo, boolean hasSecureCargo, AirplaneType parameters, int speed, String name, int tailNumber)
	{
		this.passengers = passengers;
		this.cargo = cargo;
		this.hasSecureCargo = hasSecureCargo;
		this.type = parameters;
		this.speed = speed;
		this.name = name;
		this.tailNumber = tailNumber;
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
