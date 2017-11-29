
public class PassengerPlane extends Airplane{
		
	
	
	public PassengerPlane()
	{
		maxCargo = 0; //passenger planes are not cargo planes
		hasSecureCargo = false;
		type = Airplane.AirplaneType.Commercial;
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
