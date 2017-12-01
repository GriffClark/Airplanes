
public class Ticket {
	
	protected int cost;
	protected String fromCompany; //which company issued the ticket
	protected Airport startLocation;
	protected Airport endLocation;
	//should I have a total location?
	protected String dateTimePuchased; //for this I need to pull from the DateTime in my driver class. Not sure how to do that
	protected boolean hasBeenUsed;
	
	public boolean getHasBeenUsed()
	{
		return hasBeenUsed;
	}
	
	public void setHasBeenUsed(boolean hasBeenUsed)
	{
		this.hasBeenUsed = hasBeenUsed;
	}
	
	public int getCost()
	{
		return cost;
	}
	
	public void setCost(int cost)
	{
		this.cost = cost;
	}
	
	public String getFromCompany()
	{
		return fromCompany;
	}
	
	public void setFromCompany(String fromCompany)
	{
		this.fromCompany = fromCompany;
	}
	
	public void setStartLocation(Airport startLocation)
	{
		this.startLocation = startLocation;
	}
	
	public Airport getStartLocation()
	{
		return startLocation;
	}
	
	public void setEndLocation(Airport endLocation)
	{
		this.endLocation = endLocation;
	}
	
	public Airport getEndLocation()
	{
		return endLocation;
	}
	
	public int getTotalDistance()
	{
		//not sure how to even start to write this
		int distance = 0;
		return distance;
	}
	
	public Ticket(int cost, String startLocation, String endLocation, String fromCompany) //and I don't know how to add dateTimePurchased
	{
		hasBeenUsed = false; //when you generate a ticket it has not been used yet
	}

}
