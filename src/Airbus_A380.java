//import Airplane.AirplaneType;

public class Airbus_A380 extends PassengerPlane{

	
	public Airbus_A380()
	{
		super();
		maxPassengers = 853;
		maxCargo = 0; //do I need to repeat this
		speed = 634 / 60; //because it moves this every minute
		name = "Airbus A380";
		maxFuel = 355;
		distancePerFuel = 4;
		tailNumber =(int) (Math.random() * 1000000); //at some point need to make sure that no two planes can have the same tail number
		
		
	}
	

}
