package myTicketManagementSystem;
/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *	This class help to set the object's TicketType and return.
 */
public class TicketType {
	static final int CONCESSION = 0, FULLFARE = 1, SENIORS = 2;
	
	private int fareType = FULLFARE; // default fareType is FULLFARE
	
	public TicketType (int type) {
		setFareType(type);
	}

	private void setFareType(int type) {
		// toDO validate that the type is a valid tickettype
		switch (type) {
		case TicketType.CONCESSION :
			this.fareType=0;
			break;
		case TicketType.FULLFARE   :
			this.fareType=1;
			break;
		case TicketType.SENIORS	   :	
			this.fareType = type;
		}

		// if not a valid faretype, do nothing with set
		
	}
	
	public int getFareType( ) {
		return this.fareType;
	}
}
