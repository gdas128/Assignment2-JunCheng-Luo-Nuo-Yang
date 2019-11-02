package myTicketManagementSystem;

import java.io.IOException;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class StandardService extends TrainService {

	static final double MINTICKETPRICE = 25.00; // set minimum ticket price for a standard service

	public StandardService(String departStation, String arriveStation, String departureTime) throws IOException {
		super(departStation, arriveStation, departureTime);
	}
	
	@Overload
	public StandardService(int departStationNo, int arriveStationNo, int departTime) throws IOException {
		super(TrainService.allStationNames.get(departStationNo-1).getName(), 
				TrainService.allStationNames.get(arriveStationNo-1).getName(), Integer.toString(departTime));
	}

	@Override
	public String toString() {
		return "Standard Service, no surcharge applied " + super.toString();
	}
}
