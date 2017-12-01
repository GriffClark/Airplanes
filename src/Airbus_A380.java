//import Airplane.AirplaneType;

public class Airbus_A380 extends PassengerPlane{

	
	public Airbus_A380()
	{
		super();
		maxPassengers = 853;
		maxCargo = 0; //do I need to repeat this
		maxSpeed = 634 / 60; //because it moves this every minute roughly 10 miles per minute
		name = "Airbus A380";
		maxFuel = 355;
		distancePerFuel = 4;
		tailNumber = generateTailNumber();
		
		//creating the fuel efficency map for this plane

		

		for (int i = 0; i < rangeMap.length; i++)
		{
			
			for (int j = 0; j < rangeMap[0].length; j++)
			{
				int desiredSpeed = i*15;
				int fuelCost = (((desiredSpeed^3) - (maxSpeed * (1/2 * desiredSpeed)+1 )/maxSpeed) + (1/2 * maxSpeed));
				//this is the equation for range
				rangeMap[i][0] = desiredSpeed; 
				rangeMap[0][j] = fuelCost;
				//also note that adding to the top half of this equation will make the plane more fuel efficient. Leave the back part alone
			}
		}
		 
	}
	
	public void printChart() {
		
		for (int i = 0; i < rangeMap.length; i++)
		{//this is doing weird things but I don't feel like fixing it now. Moved it out here to see if anything would change
			int desiredSpeed = i*15;
			rangeMap[i][0] = ((1/10) * desiredSpeed) + 1; //this is clearly not working please help
			for (int j = 0; j < rangeMap[0].length; j++)
			{
				if (i > 0) //cannot have desired speed be zero
				{
					
					int fuelCost = (((desiredSpeed^3) - (maxSpeed * (1/2 * desiredSpeed)+1 )/maxSpeed) + (1/2 * maxSpeed));
					//this is the equation for range
					
					rangeMap[i][j] = fuelCost;
					System.out.print(rangeMap[i][j] + "\t");
				}//also note that adding to the top half of this equation will make the plane more fuel efficient. Leave the back part alone
			}
			System.out.println();
		}
		
	}
		
		
	}
	
	
	
	

