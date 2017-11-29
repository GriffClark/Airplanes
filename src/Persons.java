import java.util.ArrayList;
public class Persons {
	private String name;
	private int age;
	private int timesFlown;
	private int money;
	private int happiness;
	private int idNo;
	
	ArrayList <Persons> population = new ArrayList<Persons>();
	
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
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setAge (int age)
	{
		this.age = age;
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
		return name;
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
