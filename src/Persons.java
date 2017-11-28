import java.util.ArrayList;
public class Persons {
	private String name;
	private int age;
	
	ArrayList <Persons> population = new ArrayList<Persons>();
	
	public Persons()
	{
		
		
	}
	
	public void setName(String name)
	{
		this.name = name;
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
	{
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
	
	
	
	
		
}
