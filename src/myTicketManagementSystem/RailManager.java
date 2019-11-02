/**
 * 
 */
package myTicketManagementSystem;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 * This class is used to get all return and the whole process of buying ticket can be found in this class.
 */
public class RailManager {
	TrainService allServices[] = new TrainService[100]; // up to 100 services, change to ArrayList
	ArrayList<TrainService> servicesAll=new ArrayList<TrainService>(Arrays.asList(allServices));
	static Scanner input = new Scanner(System.in);
	static int i=1;
	
	public void setUpData() throws IOException {
		// set up some dummy data - need to change or overload to read from a file
		/***allServices[0] = new StandardService("Central", "Lithgow", "10:00");
		allServices[1] = new StandardService("Central", "Bathurst", "10:00");
		allServices[2] = new StandardService("Bathurst", "Lithgow", "12:00");
		allServices[3] = new SleeperService("Central", "CoffsHarbour", "22:00");
		allServices[4] = new SleeperService("Central", "Byron Bay", "22:00");***/
		StandardService test=new StandardService("Central", "Bathurst", "11:00");
		File file=new File("src/../bin/myTicketManagementSystem/ServicesAll.txt");
		Scanner input=new Scanner(file);
		while(input.hasNext()) {
			String serType=input.nextLine();    //Service Type
			String depSta=input.nextLine();		//Departure Station
			String arrSta=input.nextLine();		//Arrival Station
			/*
			 * int i=0; boolean a = false,b = false; for(Station t: test.allStationNames) {
			 * i++; if(depSta==t.getName()) { a=true; } if(depSta==t.getName()) { b=true; }
			 * if(a==true&&b==true&&i==test.allStationNames.size()&&i>=1) { break; } else {
			 * System.out.println("There isn't have this station."); i--; } }
			 */
			String depTime=input.nextLine();	//Departure Time
			if(serType=="SleeperService") {
				SleeperService a1=new SleeperService(depSta,arrSta,depTime);
				servicesAll.add(a1);
			}
			else
			{	StandardService a1=new StandardService(depSta,arrSta,depTime);
				servicesAll.add(a1);
			}
		}
	}
	
	public String getAllStationNames() {
		String result = "";
		// print a list of all stations for information
		for (Station s : TrainService.allStationNames) {
					
			result = result + s.getName() + " ";
		}
		return result;
	}
	
	public String getAllStationDetails() {
		String result = "";
		// print a list of all stations for information
		/*
		 * for(int i=0;i<=TrainService.allStationNames.size();i++) {
		 * 
		 * result = result + TrainService.allStationNames.get(i).toString() + "\n"; }
		 */
		 for (Station s : TrainService.allStationNames) 
	{ 
			 result = result + s.toString() + "\n"; }
		 
		 	 return result;
	}
	
	public void sellTickets() throws IOException {
		int departSt, arriveSt, hourDepart;
		String reply;
		TicketType fareType;
		Ticket newTicket;
		
		System.out.println(getAllStationDetails());
		
		System.out.println("Please Enter Departure Station number : ");
		departSt = input.nextInt();
		System.out.println("Please Enter Destination Station number : ");
		arriveSt = input.nextInt();
		System.out.println("Please Enter Departure Hour (00-24): ");
		hourDepart = input.nextInt();
		System.out.println("Is this a concession Ticket? (Y/N)");
		reply = input.next();
		reply = reply.toUpperCase();
		if (reply.startsWith("Y")) 
			fareType = new TicketType(TicketType.CONCESSION);
		else
			fareType = new TicketType(TicketType.FULLFARE);
		
		// update this next line so that it displays name of stations, not station numbers
		System.out.println("Ticket requested from " + TrainService.allStationNames.get(departSt-1).getName() + " to " + TrainService.allStationNames.get(arriveSt-1).getName() + " at " + hourDepart);
	
		newTicket = createTicket(departSt,arriveSt,fareType, hourDepart);
		newTicket.print();
	}

	private Ticket createTicket(int departSt, int arriveSt, TicketType fareType, int departureTime) throws IOException {
		// first work out service details for this trip
		TrainService aService;
		Ticket t;
		System.out.println("Enter 1 for standard service, 2 for sleeper service : ");
		int ans = input.nextInt();
		if (ans==1) {
			aService = new StandardService(departSt, arriveSt, departureTime);
		}
		else {
			aService = new SleeperService(departSt, arriveSt, departureTime);
		}
		 
		// work out fare for this service
		System.out.println("Enter 1 for Economy seat, 2 for First Class seat : ");
		ans = input.nextInt();
		if (ans==1) {
			t = new EconomyClassTicket(aService, fareType);
		}
		else {
			t = new FirstClassTicket(aService, fareType);
		}
		
		
		return t;
	}
	
	@Overload
	public Ticket createTicket(int departSt, int arriveSt, TicketType fareType, int departureTime, boolean sleeper, boolean firstClass) throws IOException {
		TrainService aService;
		Ticket t;
		
		if (sleeper)
			aService = new SleeperService(departSt, arriveSt, departureTime);
		else
			aService = new StandardService(departSt, arriveSt, departureTime);
		
		if (firstClass)
			t = new FirstClassTicket(aService, fareType);
		else
			t = new EconomyClassTicket(aService, fareType);
		
		return t;
	}


}
