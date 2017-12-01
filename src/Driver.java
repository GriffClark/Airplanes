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
		 
		 //setting up a company for testing purposes
		 
		 Company company = new Company();
		 

		//first thing to do is to populate the planet... right?
				
		for (int i = 0; i < desiredPopulation; i++) 
		{//adds people to the population<>
			Persons person = new Persons();
			person.setName ("person number" + i);
			person.setAge();
			person.setMoney();
			
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
				
				//ideally instead of a while loop I could do this recusively so it would look nicer and be easier to understand but as it is I am not sure how to do that
				
			}
			}
			
			
			if(person.getIdNo() % 3 == 0|| person.getIdNo() % 5 ==0 )
			{
				person.setLocation(laInternational);
				laInternational.addPerson(person);
			}
			
			else if (person.getIdNo() % 7 == 0)
			{
				person.setLocation(privateAirport1);
				privateAirport1.addPerson(person);
			}
			
			else if (person.getIdNo() % 9 == 0)
			{
				person.setLocation(militaryAirport1);
				militaryAirport1.addPerson(person);
			}
			
			//this will be my catch cluase
			else
			{
				person.setLocation(oHare);
				oHare.addPerson(person);
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
		System.out.println("Debug Data");
		for(int i = 0; i < totalPopulation.size(); i++)
		{
			System.out.println(totalPopulation.get(i).toString());
		}
		
		
		
		 //THIS IS WHERE THINGS START TO HAPPEN:
		int wagePayoutTimer = 0;
		 while(true)
		{
			 //this should always be the first statement in the loop
			 c.add(Calendar.MINUTE, 1);  // number of minutes to add
			dt = sdf.format(c.getTime());  // dt is now the new date
			
			wagePayoutTimer++;
			
			if (wagePayoutTimer == 60)
			{
				for (int i = 0; i < totalPopulation.size(); i++)
				{
					totalPopulation.get(i).addMoney(10 + totalPopulation.get(i).getAge()); //right now each person makes 10 dollars an hour + their age
				}
				wagePayoutTimer = 0;
				//pays everyone then resets the timer
			}
		

			for (int i = 0; i < airplanes.size(); i++)
			{
				//this will add 1 fuel to every plane on the ground and subtract one fuel from every plane in the air
				
				if(airplanes.get(i).isGrounded() == true)
					//eventually I will turn this into a choice but for now it is a mandatory refuel
				{
				airplanes.get(i).addFuel(); // need to create unique addFuel methods for each plane because they won't fuel at the same rate
				//note that fuel is added at the same rate for every plane
				}
				else
				{
					airplanes.get(i).loseFuel(); // still need to finish working on this loseFuel method based on the rangeTable that I am creating
				}
			}
			
			//this is where people will purchase tickets
			/*
			 * pull a number of people from totalPopulation
			 * have each of those people buy a ticket for a certain date
			 */
			
			//this will give 1% of people an urge to fly to a random location
			
			for(int i = 0; i < (totalPopulation.size()/100)+1; i++)
			{
				ArrayList<Persons> peopleWhoFly = new ArrayList<Persons>(); //this is where I will put everyone that wants to fly
				int personPicker = (int)(Math.random() * totalPopulation.size());
				peopleWhoFly.add(totalPopulation.get(personPicker)); //1% of the population will randomly be added
				//I need to build a check here to make sure that the same peson doesn't get added more than once, but I don't know how to write that
				
				//for now each person will want to go to a random location
				Persons person = peopleWhoFly.get(i); //so I don't have to keep retyping it
				
				int randomChooser = (int)(Math.random() * airports.size());
				Airport desiredAirport = airports.get(randomChooser);
				person.setDesiredLocation(desiredAirport);
				
				//now to check if person is eligible to get a ticketCost
				int costChecker = Ticket.ticketCost(person.getLocation(), person.getDesiredDestination());
				
				if(person.getMoney() >= costChecker)
				{
					Ticket ticket = new Ticket (person.getLocation(), person.getDesiredDestination(), company);
					person.addTicket(ticket); //addTicket already subtracts the cost of ticket from money
				}
				
				//what should I do if the person cannot afford a ticket? I could either try again, set them aside and do nothing, or set them aside and pull a new person
				
				/**
				 * Eventually there will be a whole automatic process for deciding which company people want to buy their tickets through
				 */
			}
			
			/**
			 * So right now people are purchasing a ticket for a flight, and they don't care when the flight is. I am going to change it so that they give an ideal travel time
			 */
			
			//this is temporary. Eventually flights will be generated to match up with times too
			
			//also not quite sure how to go about doing this. Help wanted. 
			
			
			//this always needs to be the last piece of code in the while loop
			System.out.println(c.getTime());
			TimeUnit.SECONDS.sleep((long) 0.1);
			
			break;
			
			/**
			 * something to note: in this model people do not get older or reproduce. Wages are static
			 */
			
		}
		
		 //clause saying if user wants the values of a plane they can enter the name or tail number and have it print the toString
	}
	
}
