package myTicketManagementSystem;

import java.io.IOException;

/**
 * @author Kkeogh,JunCheng Luo,Nuo Yang
 *
 */
public class MainDriver {

	public static void main(String[] args) throws IOException {
		RailManager m = new RailManager();
		m.setUpData(); // load in data of all services available
		m.sellTickets(); // text based testing method

	}

}
