/**
 * 
 */
package myTicketManagementSystem;

/**
 * @author Kkeogh£¬JunCheng Luo,Nuo Yang
 * This class use to return the information about economy ticket
 *
 */
public class EconomyClassTicket extends Ticket {
	private TicketType t;
	/**
	 * 
	 */
	public EconomyClassTicket(TrainService _service, TicketType _ticketType) {
		super(_service, _ticketType);
		t=_ticketType;
		}

		@Override
		public double getTicketPrice() {
			//  set standard ticket price for economy based on fare for this service
			double ticketPrice = this.getService().getTicketPrice();
			
			if(t.getFareType()==0) {
				
				ticketPrice=ticketPrice*0.9;
			}
			return ticketPrice;
		}

		@Override
		public String toString() {
			return "Travel through " + this.getService() + 
					"Economy class ticket $" + this.getTicketPrice() ;
		}
	

}
