package myTicketManagementSystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTypeTest {

	@Test
	public final void testIssueConcessionTicket() {
		//"Checking if the faretype is correct"
		assertEquals(new TicketType(TicketType.CONCESSION).getFareType(),0);
		 // TODO
	}

	@Test
	public final void testIssueFullPriceTicket() {
		assertEquals(new TicketType(TicketType.FULLFARE).getFareType(),1);
		 // TODO
	}

}
