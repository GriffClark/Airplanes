//import Airplane.AirplaneType;

public class Airbus_A380 extends PassengerPlane{

	
	public Airbus_A380(int maxPassengers, int passengers, double cargo, double maxCargo, boolean hasSecureCargo,
			AirplaneType type, int speed, String name, int tailNumber) {
		super(maxPassengers, passengers, cargo, maxCargo, hasSecureCargo, type, speed, name, tailNumber);
				
	}
	
	public Airbus_A380()
	{
		maxPassengers = 853;
		maxCargo = 0; //do I need to repeat this
		speed = 634 / 60; //because it moves this every minute
		name = "Airbus A380";
		tailNumber =(int) (Math.random() * 1000000); //at some point need to make sure that no two planes can have the same tail number
		
	}
	
}
