/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *This class use to return the information about economy ticket.The first class ticket's price is 1.25 times of the econmy ticket's price.
 */
public class FirstClassTicket extends Ticket {

	double SURCHARGE = 0.25;
	private TicketType t;
	/**
	 * 
	 */
	public FirstClassTicket(TrainService _service, TicketType _ticketType) {
		super(_service, _ticketType);
		t=_ticketType;
	}

	// first class ticket has 25% surcharge added
	@Override
	public double getTicketPrice() {
		double ticketPrice = this.getService().getTicketPrice() * (1+ SURCHARGE);
		
		// to make ticketprice more expensive for first class ticket - add surcharge 25%
		// if concession fare, give 10% discount when issue the ticket
		if(t.getFareType()==0) {
			
			ticketPrice=ticketPrice*0.9;
		}
		return ticketPrice;
	}

	@Override
	public String toString() {
		
		return "Travel through " + this.getService() + 
				"First Class Ticket $" + this.getTicketPrice() ;
	}

}
