
public class PublicAirport extends Airport{
	
	

	public PublicAirport(PlanesAccepted accepted, int currentPlanes, int maxPlanes, boolean full, int population, String name) {
		super(accepted, currentPlanes, maxPlanes, population, name);
		
		//how to add what it excepted based off what is defined in the enum
		planesAccepted = Airport.PlanesAccepted.Commercial;
		
	}
	
	public PublicAirport()
	{
		
	}


}
