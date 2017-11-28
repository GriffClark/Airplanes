
public class PassengerPlane extends Airplane{

	
	public PassengerPlane(int maxPassengers, int passengers, double cargo, double maxCargo, boolean hasSecureCargo,
			AirplaneType type, int speed, String name, int tailNumber) {
		super(maxPassengers, passengers, cargo, maxCargo, hasSecureCargo, type, speed, name, tailNumber);
		
		maxCargo = 0; //passenger planes are not cargo planes
		hasSecureCargo = false;
		type = Airplane.AirplaneType.Commercial;
		
	}
	
	public PassengerPlane()
	{
		
	}

	public boolean isBigPlane()
	{
		boolean isBigPlane;
		if (maxPassengers >= 100)
		{
			isBigPlane = true;
		}
		else {
			isBigPlane = false;
		}
		
		return isBigPlane;
	}
	
	public boolean hasSecureCargo()
	{
		return false;
	}
	
	
	
	
}
