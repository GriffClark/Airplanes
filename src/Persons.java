import java.util.ArrayList;
public class Persons {
	protected String name;
	protected int age;
	protected int timesFlown;
	protected int money;
	protected int happiness;
	protected int idNo;
	protected String location;
	protected Airport desiredDestination; // this is gonna be tough because this is where I have to start managing layovers
	
	ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	
	public String getLocation()
	{
		return location;
	}
	
	public void purchaseTicket(String startLocation, String endLocation, int cost, String fromCompany)
	{
		
		Ticket ticket = new Ticket(cost, startLocation, endLocation, fromCompany);
		
		if( cost > money)
		{
			System.out.println("Error illigal purchase by " + name);
			System.out.println("Cost of ticket: " + cost + " > "+ name+ "'s $" + money);
		}
		
		else
		{
			
			this.money -= cost;
			tickets.add(ticket);
			
		}

	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public Persons()
	{
		happiness = 100; //everyone starts 100% happy
	}
	
	public void setIdNo()
	{
		this.idNo =(int) (Math.random() * 1500000);
		
	}
	
	public int getIdNo()
	{
		return idNo;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void changeHappiness(int h)
	{
		this.happiness += h;
	}
	
	public void setMoney()
	{
		this.money =  ((int) ( (Math.random() * 100 * age) ))  ^ 2;
		//the amount of money you have increases as you get exponentially
	}
	
	public void addMoney(int money)
	{
		this.money += money;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setAge ()
	{
		this.age = (int)((Math.random()) * 80) + 5; // no person younger than 5 years old I think
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean isTraveling()
	
	//not sure if I need this
	
	{//isTraveling is to determine if they want to schedule a flight
		boolean isTraveling;
		int random = (int)((Math.random())*200);
		if (random == 69)
		{
			isTraveling = true;
		}
		else
		{
			isTraveling = false;
		}
		return isTraveling;
	}
	
	public String toString()
	{
		return name + " who is " + age + " years old @ location " + location + " with $" + money + " and ID number: " + idNo;
	}
	
	public int timesFlown()
	{
		return timesFlown;
	}
	
	public void flying()
	{
		timesFlown++;
	}
	
	//if a person goes somewhere there is a high chance of them wanting to return soon... equasion for this?
	
	
	
	
		
}
