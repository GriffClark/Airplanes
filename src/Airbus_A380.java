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
				int fuelCost =(int) (Math.pow(desiredSpeed, 1.3));
				//this is the equation for range
				rangeMap[i][0] = desiredSpeed; 
				rangeMap[0][j] = fuelCost;
				//also note that adding to the top half of this equation will make the plane more fuel efficient. Leave the back part alone
			}
		}
		 
	}
	
	public void printChartDebug()
	{
		
		for (int i = 1; i < rangeMap.length; i++)
		{
			
			for (int j = 0; j < rangeMap[0].length; j++)
			{
				int desiredSpeed = i*15;
				int fuelCost = (int)(Math.pow(desiredSpeed, 1.04)) ; //need to balance this with fuel capacity
				//this is the equation for range
				rangeMap[i][0] = desiredSpeed; 
				rangeMap[0][j] = fuelCost;
				System.out.print(desiredSpeed + " ");
				System.out.println(fuelCost); //it's printing these out twice but that's fine for now
				//also note that adding to the top half of this equation will make the plane more fuel efficient. Leave the back part alone
			}
			
		
		}
		
	}

	}
		
	
	
	
	

