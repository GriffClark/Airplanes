
public class PrivateAirport extends Airport{

	public PrivateAirport(PlanesAccepted planesAccepted, int currentPlanes, int maxPlanes, boolean full, int population, String name) {
		super(planesAccepted, currentPlanes, maxPlanes, population, name);
		planesAccepted = Airport.PlanesAccepted.Private;
	}
	
	public PrivateAirport()
	{
		
	}


}
