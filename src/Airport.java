import java.util.ArrayList;
public class Airport extends Position{
	 
	protected enum PlanesAccepted
	{
		Commercial, Private, Military, Cargo //are these capitalized by convention?
	}
	
	protected ArrayList<Airplane> planesAtAirport = new ArrayList<Airplane>();
	protected ArrayList<Persons> people = new ArrayList<Persons>();
	
	
	protected int maxPlanes;
	protected String name;
	protected PlanesAccepted planesAccepted;

	public Airport()
	{
		
	}

	
	public char getAirportType()
	//how do I properly use the enum here?
	{
		char type = '!'; //need to set it as set this to something
		
		//this is for my display in driver class
		switch (planesAccepted) 
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
	
	
	public void addPerson(Persons person)
	{
		people.add(person);
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
		if (planesAtAirport.size() == maxPlanes)
		{
			return true;
		}
		return false;
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
		return name + " population of " + people.size() + " which currently has:\n" + planesAtAirport.toString();
		
	}



	
	
	

}
