import java.util.ArrayList;
public class Airport {
	 
	protected enum PlanesAccepted
	{//how do I access this enum to set what airports can accept?
		Commercial, Private, Military, Cargo //are these capitalized by convention?

	}
	
	private ArrayList<Airplane> planesAtAirport = new ArrayList<Airplane>();
	
	
	protected int maxPlanes;
	protected int currentPlanes;
	protected int population;
	protected String name;
	protected PlanesAccepted planesAccepted;
	
	public Airport (PlanesAccepted planesAccepted, int currentPlanes, int maxAirplanes, int population, String name)
	{
		this.maxPlanes = maxAirplanes;
		this.currentPlanes = currentPlanes;
		this.planesAccepted = planesAccepted;
		this.population = population;
		this.name = name;
	}
	
	public Airport()
	{
		
	}
	
	public char getAirportType()
	//how do I properly use the enum here?
	{
		char type = '!'; //need to set it as set this to something
		
		//this is for my display in driver class
		switch (planesAccepted) //getter a Null Pointer Exception error here and not sure why. Also additionally after it is saying there is an error @ Driver.java:194
		{
		case Commercial:
			type = 'C';
			break;
			
		case Military:
			type = 'M';
			break;
		
		
		case Private:
			type = 'P';
			break;
		default:
			type = '.'; 
			break;
		}
		return type;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
	
	public int getMaxPlanes()
	{
		return maxPlanes;
	}
	
	public void setMaxPlanes(int maxAirplanes)
	{
		this.maxPlanes = maxAirplanes;
	}
	
	public boolean isFull()
	{
		if (currentPlanes == maxPlanes)
		{
			return true;
		}
		return false;
	}
	
	public void departure()
	{
		this.currentPlanes --;
	}
	
	public void arival()
	{
		this.currentPlanes ++;
	}
	
	public void addAttribute(PlanesAccepted accepted)
	{
		this.planesAccepted = accepted;
	}
	
	public void addPlane(Airplane planeToBeAdded)
	{
		planesAtAirport.add(planeToBeAdded);
	}
	
	public int planesAtAirport()
	{
		return planesAtAirport.size();
	}
	
	
	public String toString()
	{
		String printed = "";
//		for (int i= 0; i < planesAtAirport.size(); i++)
//		{
//			printed += planesAtAirport.toString() + "\t";
//			if ( i % 3 == 0) {
//				printed += "\n";
//				//just some formatting
//			}
//		}
		return name + " population of " + population + " which currently has:\n" + planesAtAirport.toString();
		
	}
	
	
	
//	public PlanesAccepted planesAccepted()
//	{
//		
//		return ;
//		
//	}
	

}
