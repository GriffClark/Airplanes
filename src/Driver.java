import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

/** Questions
 * How am I going to determine which flights will go to where?
 * Do I want to use interface/impliment with my airplane --> passengerPlane classes? Think I want to leave it as is but still should ask\
 * Fixing the population problem
 */

import java.util.ArrayList;
import java.util.Calendar;
public class Driver {
	
	/**
	 * Eventually I want to set each thing (initializing airports, building population, adding airplanes...) into it's own method in a seprate class, then call that in the driver class
	 * The driver class will only contain the actual simulation
	 * This is just formatting; doing this should not change how the code runs but just cleans it up
	 * @throws ParseException 
	 * @throws InterruptedException 
	 */
	

	public static void main (String[] args) throws ParseException, InterruptedException
	{
		//starting to initialize things 
		
		Scanner s = new Scanner (System.in);
		

		
		ArrayList<Persons> totalPopulation = new ArrayList<Persons>(); // This is adjustable when using for size
		ArrayList<Airport> airports = new ArrayList<Airport>();
		ArrayList<Integer> tailNumbers = new ArrayList<>(); //to store the tail numbers of every plane to make sure that no two planes have the same tail number
		ArrayList<Airplane> airplanes = new ArrayList<Airplane>();
		
		//Roughly the population of the usa is 323100000
		System.out.println("enter max population > 0");
		
		int intInput = s.nextInt();
		
		int desiredPopulation = intInput; //this is the number to use for adding a percentage of the population
		
		if (desiredPopulation <=0 )
		{
			System.out.println("error. please enter a positive number");
			
		}

				 
		 //declaring airports
		 
		 PublicAirport laInternational = new PublicAirport();
		 laInternational.setName("Los Angeles International");
		 laInternational.setMaxPlanes(100);
		 airports.add(laInternational); //adds this airport to my list of airports
		 
		 PublicAirport oHare = new PublicAirport();
		 oHare.setName("O'Hare International");
		 oHare.setMaxPlanes(50);
		 airports.add(oHare);
		 
		 PrivateAirport privateAirport1 = new PrivateAirport();
		 privateAirport1.setName("Private Airport 1");
		 privateAirport1.setMaxPlanes(7);
		 ArrayList<Persons> privateAirport1Pop = new ArrayList<Persons>();
		 airports.add(privateAirport1);
		 
		 MilitaryAirport militaryAirport1 = new MilitaryAirport();
		 militaryAirport1.setName("Military Airport");
		 militaryAirport1.setMaxPlanes(14);
		 ArrayList<Persons> militaryAirport1Pop = new ArrayList<Persons>();
		 airports.add(militaryAirport1);
		 

		//first thing to do is to populate the planet... right?
				
		for (int i = 0; i < desiredPopulation; i++) 
		{//adds people to the population<>
			Persons person = new Persons();
			person.setName ("boring human no. " + i);
			person.setAge((int)((Math.random()) * 80));
			person.setMoney( (int) (person.getAge() * (Math.random() * 100) ));
			
			//this part is going to be very slow but necessary
			
			person.setIdNo();
			int n = -1;
			while (n == -1) {
			n =0;
			for (int b = 0; b < totalPopulation.size(); b++)
			{
				if (person.getIdNo() == totalPopulation.get(b).getIdNo() && totalPopulation.size() >= 1) //only generating 1 person
				{
					person.setIdNo();
					n = -1;
					break;
					
				}
				
				
			}
			}
			
			
			
			totalPopulation.add(person);
			System.out.println(person.toString());
			if (i == desiredPopulation)
			{
				break;
			}
		} 
		

		 while(totalPopulation.size() > 1) 
		 {//ensures that everyone gets put into an airport
			 
			 /*
			  * So the reason I am doing it like this instead of just hardcoding a value is because I want to make sure that this will work no matter how many people I decide to put into my simulation
			  */
			//adding people to airports
			 
			 
			
			 for (int i = (totalPopulation.size() -1); i > desiredPopulation / 2; i--) //use desiredPopulation because it won't change
			 { 
			/**
			 * have to go through it backwards to prevent against overflow errors because the arrayList is constantly adjusting size
			 */
//			
				 laInternational.addPerson(totalPopulation.get(i));
				 totalPopulation.remove(i); 
			 }
			 
			 
			 
			 //and to make sure that the entire population got added to the airport
			 for (int i = (totalPopulation.size() -1 ); i > 0; i--)
			 {
				 oHare.addPerson(totalPopulation.get(i));
				 totalPopulation.remove(i);

			 }			 
			 if (totalPopulation.size() > 1)
			 {
				 System.out.println("something broke");
				 for (int i = 0; i < totalPopulation.size(); i++)
				 {
					 System.out.println(totalPopulation.get(i));
				 }
			 }
			 
			 
			
		 }


		int la_A380 = 17;
		 for (int i = 0; i < la_A380; i++)
		 {
			 if (laInternational.isFull() == false) { //if the airport is not full do a thing
				 Airbus_A380 abus = new Airbus_A380();
				 tailNumbers.add(abus.getTailNumber()); //still need to make it so that each plane can only have 1 tail number. Do the same thing I did for persons ID
				 laInternational.addPlane(abus);
				 airplanes.add(abus);

			 }
		 }
		 
		 
		 int oHare_A380 = 4;
		 
		 for (int i = 0; i < oHare_A380; i++)
		 {
			 if (oHare.isFull() == false)
			 {
				 Airbus_A380 abus = new Airbus_A380();
				 oHare.addPlane(abus);
				 tailNumbers.add(abus.getTailNumber());
				 airplanes.add(abus);
			 }
		 }
		
		
		//debug
		 for (int i = 0; i < airports.size(); i++)
		 {
			 System.out.println(airports.get(i).toString());
			 System.out.println ("----------------------------------------------------------------------");

		 }
		 
		 //initializing the map
		 /**
		  * for starters this is just going to be a basic grid and things will move at a fixed rate. However, eventually I would like to make this grid actually look like the USA and have it be massive
		  */
		 
		 Airport[][] airportMap = new Airport [10][10];
		 
		 for (int i = 0; i < airportMap.length; i++)
		 {
			 for(int j = 0; j < airportMap[0].length; j++)
			 {
				 airportMap[i][j] = null;
				 //fills the airportMap with null values
			 }
		 }
		 
		 airportMap[3][4] = oHare;
		 airportMap[6][9] = laInternational;
		 airportMap[4][1] = militaryAirport1;
		 airportMap[9][0] = privateAirport1;
		 
		 //now I am going to try and build a representation of this 
		 
		 char[][]airportMapDisplay = new char[10][10];
		 
		 for (int i = 0; i < airportMapDisplay.length; i++)
		 {
			 for (int j = 0; j < airportMapDisplay[0].length; j++)
			 {
				 if(airportMap[i][j] != null)
				 {
					 airportMapDisplay[i][j] = airportMap[i][j].getAirportType(); //this returns a char which can then be put onto the map
					
					
				 }
				 System.out.print(airportMapDisplay[i][j] + " ");
				
			 }
			 System.out.println();
		 }

		 
		 
		 //done initializing things
	
		
		//setting the initial time. This is basically a black box to me right now
		
		String dt = "2008-01-01 12:00";  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		
		//debug
		System.out.println("ABUS data");
		Airbus_A380 abusdata = new Airbus_A380();
		abusdata.printChart();
		
		 //THIS IS WHERE THINGS START TO HAPPEN:
		 while(true)
		{
			 c.add(Calendar.MINUTE, 1);  // number of minutes to add
			dt = sdf.format(c.getTime());  // dt is now the new date
			
			
			
			for (int i = 0; i < airplanes.size(); i++)
			{
				//this will add 1 fuel to every plane on the ground and subtract one fuel from every plane in the air
				
				if(airplanes.get(i).isGrounded() == true)
				{
				airplanes.get(i).addFuel();
				//note that fuel is added at the same rate for every plane
				}
				else
				{
					airplanes.get(i).loseFuel();
				}
			}
			
		  //DateTime
			//threading import threading package and at end of loop thread.sleep for some amount of time
				
	
			
			//debug
			System.out.println(c.getTime());
			TimeUnit.SECONDS.sleep(1);
			
		}
		
		 //clause saying if user wants the values of a plane they can enter the name or tail number and have it print the toString
	}
	
}
