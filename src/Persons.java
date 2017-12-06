import java.util.ArrayList;

/**
 * Eventually I want to make there be a few types of crew members that planes need to launch: FLight attendents and pilots
 * Also, I am going to make a random number of air marshalls that will take flights
 * @author Griffin 
 *
 */

/*
 * going to take ages to initalize so need to find a faster way to generate tons of people quickly... what about doing it part at a time and only generating certian parts when they are needed
 */
public class Persons {
	protected String name;
	protected int age;
	protected int timesFlown;
	protected int money;
	protected int happiness;
	protected int idNo;
	protected Airport location;
	protected Airport desiredDestination; // this is gonna be tough because this is where I have to start managing layovers
	protected ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	
	
	public Airport getLocation()
	{
		return location;
	}
	
	public Airport getDesiredDestination()
	{
		return desiredDestination;
	}
	
	public void setDesiredLocation(Airport desiredDestination)
	{
		this.desiredDestination = desiredDestination;
	}
	
	public void setLocation(Airport location)
	{
		this.location = location;
	}
	
	public Persons()
	{
		happiness = 100; //everyone starts 100% happy
	}
	
	public void addTicket(Ticket ticket)
	{
		money -= ticket.getCost(); //automatically subtracts the cost of the ticket from your money
		tickets.add(ticket);
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
