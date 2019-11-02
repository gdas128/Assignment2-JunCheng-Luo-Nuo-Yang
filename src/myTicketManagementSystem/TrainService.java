package myTicketManagementSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *	This class contain the stations' information and have method to count how many stations between the arrive station and departure station.
	Also can return the information of train service and the service price.
 */
public abstract class TrainService {

	// static attributes to share with all TrainServices
	// constants
	static final double MINTICKETPRICE = 25.00; 
	// list of stations stored in an array - should change to an ArrayList for more flexibility 
	// remove dummy Station data here and write a new method to setup all stations based on file input
	static Station[] allStationNames1 = {new Station(1, "Central",1), 
									new Station(2, "Paramatta",1),
									new Station(3, "Penrith", 2),
									new Station(4,"Lithgow",3),
									new Station(5, "Orange",4), 
									new Station(6, "Bathurst",4), 
									new Station(7, "Newcastle",3),
									new Station(8, "CoffsHarbour",4),
									new Station(9, "ByronBay", 4),
									new Station(10,"Hogwarts",1)};
	
	static ArrayList<Station> allStationNames=new ArrayList<Station>(Arrays.asList(allStationNames1));
	//I want to ask why here should be construct but the allStationNames1 don't need to?
	//I use Arrays.asList to change the array allStationNames1 to array list allStationNames
	
	// attributes for all Train Services
	int zonesTravelled = 1;  // default assumption one zone travelled, should calculate this
	int departureStationNumber; // index value for station in allStationNames list
	int arrivalStationNumber;
	String departureTime;
	static int cishu=1;
	String departStation; 
	String arriveStation;
	// constructor
	public TrainService(String departStation, String arriveStation, String departureTime) throws IOException {
		//this.setUpStationData("StationInputFile.txt"); // not yet implemented
		
		  if(cishu>=1) {
			  this.setUpStationData("StationInputFile.txt");	//Used to ensure only update the setUpStationData once not update every time when use this constructor
		  }
		  cishu-=1;
		this.setDepartStation(departStation);
		this.setArriveStation(arriveStation);
		this.setDepartureTime(departureTime);
		this.setZonesTravelled();
		this.departStation=departStation;
		this.arriveStation=arriveStation;
	}
	
	private void setZonesTravelled() {
		// update this to calculate how many zones are travelled from Depart Station to Arrive Station
		/*
		 * this.zonesTravelled =
		 * Math.abs(this.allStationNames[arrivalStationNumber].getZone() -
		 * this.allStationNames[departureStationNumber].getZone() +1);
		 */
		if(arrivalStationNumber - departureStationNumber==0)   //Check if the arrival Station is departure Station.
			this.zonesTravelled=0;
		else
			this.zonesTravelled = Math.abs(arrivalStationNumber - departureStationNumber)+1; 
		
	}

	private void setDepartureTime(String _departureTime) {
		this.departureTime = _departureTime;
		
	}

	private void setArriveStation(String arriveStation) {
		//todo: search in the train station list for this station arriveStation and find it's index value
		for(int i=0;i<allStationNames.size();i++) {    //To check all the station find the station's number
			int j=i;
			if(this.allStationNames.get(j).getName()==arriveStation)
				{this.arrivalStationNumber = j+1;  // change this to be the index value of the correct station				
					break;}
		}
		/*
		 * if(this.arrivalStationNumber==0) {
		 * System.out.println("This station has been closed");}
		 */
		// change this to be the index value of the correct station
	}

	private void setDepartStation(String departStation) {
		//todo: search in the train station list for this station arriveStation and find it's index value
		for(int i=0;i<allStationNames.size();i++) {
			//System.out.println(this.allStationNames.get(i).getName());
			int j=i;
			if(this.allStationNames.get(j).getName()==departStation)
				{this.departureStationNumber = j+1;  // change this to be the index value of the correct station				
				 break;}
		}
		/*
		 * if(this.departureStationNumber==0) {
		 * System.out.println("This station has been closed"); }
		 */
		
	}

	// methods for Train Services
	public double getTicketPrice() {
		return MINTICKETPRICE * (getZonesTravelled());  // default price is minimum price
		// the price is increased if more zones are travelled
	}

	public int getZonesTravelled() {
		// need to look at departure station and arrival station and see how many zones are travelled
		// then update zonesTravelled
		// need to have a mechanism for finding or storing number of zones travelled
		return zonesTravelled;
	}
	
	private void setUpStationData(String fname) throws FileNotFoundException{
		// TODO finish this method to load station details from file named fname
		// open scanner on file fname to read in Station details into an ArrayList allStations to replace the array allStationNames
		// loop to read in Station data - station name on one line, zone number on next line, until EOF
		//URL a=TrainService.class.getResource(fname);
		//URL a=TrainService.class.getResource("StationInputFile.txt");
		//File file=new File(a+"");
		//File file=new File("E:\\work\\яек╪\\itech 2306\\ITECH_2306\\Assessment\\Assessment task Lab Assignment 2\\2\\bin\\myTicketManagementSystem\\StationInputFile.txt");
		File file=new File("src/../bin/myTicketManagementSystem/"+fname);
		Scanner input=new Scanner(file);
		//File file=new File(fname);
		while(input.hasNext()) {
			String stationNum=input.nextLine();
			String stationName=input.nextLine();
			String stationZoneNum=input.nextLine();
			int num=Integer.parseInt(stationNum);  //Make the data from int to String 
			int zone=Integer.parseInt(stationZoneNum);
		    Station newStation=new Station(num,stationName,zone);
		    allStationNames.add(newStation);
		}
		
		
		
		
		
		
	}
	
	public String toString() {
		return " service " + this.getZonesTravelled() + " stations, between Station "
				+ this.departStation + " and Station " + this.arriveStation + " Service price $" + getTicketPrice()+"\n" ;
	}
	
	
	
/***	  public static void main(String[] args) throws FileNotFoundException {
	  System.out.println(TrainService.class.getResource("")); 
	  URL a=TrainService.class.getResource("StationInputFile.txt");
	  System.out.println(a);
	  String a1=(a+"");
	  System.out.println(a1);
		//URL a=TrainService.class.getResource("StationInputFile.txt");
		//File file=new File("E:\\work\\яек╪\\itech 2306\\ITECH_2306\\Assessment\\Assessment task Lab Assignment 2\\2\\bin\\myTicketManagementSystem\\StationInputFile.txt");
	  //File file=new File("E:\\work\\яек╪\\itech%202306\\ITECH_2306\\Assessment\\Assessment%20task%20Lab%20Assignment%202\\2\\bin\\myTicketManagementSystem\\StationInputFile.txt");
		File file=new File("src/../bin/myTicketManagementSystem/StationInputFile.txt");
	  Scanner input=new Scanner(file);
		//File file=new File(fname);
		while(input.hasNext()) {
			String stationNum=input.nextLine();
			String stationName=input.nextLine();
			String stationZoneNum=input.nextLine();
			int num=Integer.parseInt(stationNum);  //Make the data from int to String 
			int zone=Integer.parseInt(stationZoneNum);
			System.out.println("Num:"+num+"   Name:"+stationName+"    Zone:"+zone);
			System.out.println();
			// Station newStation=new Station(num,stationName,zone);
			   // allStationNames.add(newStation);
			   // System.out.println(allStationNames.get(10).getName());
		}
	  }
	***/  
}
