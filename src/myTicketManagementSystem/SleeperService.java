package myTicketManagementSystem;

import java.io.IOException;

/**
 * Sleeper services are priced differently to the standard Train Service. 
 * The price is increased by a factor of 0.9 on the saved price
 * Also, the minimum price set for a Sleeper is higher than for standard train service
 */
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class SleeperService extends TrainService {

	static final double MINTICKETPRICE = 50.00; // set minimum ticket price for a sleeper
	static final double SURCHARGE = 50.00; // set surcharge value for sleeper service
	
	public SleeperService(String departStation, String arriveStation, String departureTime) throws IOException {
		super(departStation, arriveStation, departureTime);
	}
	
	@Overload
	public SleeperService(int departStationNo, int arriveStationNo, int departTime) throws IOException {
		super(TrainService.allStationNames.get(departStationNo-1).getName(), 
				TrainService.allStationNames.get(arriveStationNo-1).getName(), Integer.toString(departTime));
	}


	
	//override the getTicketPrice in the TrainService Class. 
	//In this method, call the getTicketPrice from the superclass to find out the 
	// ticket price for this service and then add a surcharge of $50 for the sleeper service.
	
	
	@Override
	public 	double getTicketPrice() {
		double ticketPriceCalculated=0.0;
		ticketPriceCalculated = super.getTicketPrice() + SURCHARGE;
		return ticketPriceCalculated;
	}
	
	@Override
	public String toString() {
		return "Sleeper with surcharge $"+ SURCHARGE + " applied " + super.toString();
	}
	
	
}
