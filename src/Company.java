import java.util.ArrayList;
public class Company {
	
	protected int money;
	protected String name;
	protected double rating;
	protected ArrayList<Integer> ratingDataSet = new ArrayList<Integer>();
	protected ArrayList<Airplane> airplanes = new ArrayList<Airplane>();
	
	public void setMoney(int money)
	{
		this.money = money;
	}
	
	public int getMoney()
	{
		return money;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getRating()
	{
		return rating;
	}
	
	public void addRating(int addRating)
	{
		if (ratingDataSet.size() < 100)
		{
			//I feel like I should do something to make sure that the first few ratings don't have an outragous impact
		}
		
		else
		{
			if (addRating > 5 || addRating < 0 ) {
				System.out.println("error invalid rating");
			}
			
			else
			{
				ratingDataSet.add(addRating);
				//now it will automatically update rating
				int averagee = 0;
				for (int i = 0; i < ratingDataSet.size(); i++)
				{
					averagee += ratingDataSet.get(i);
				}
				
				this.rating = averagee / ratingDataSet.size();
			}
		}
	
	}
	
	
	
	public Company()
	{
		
	}

}
