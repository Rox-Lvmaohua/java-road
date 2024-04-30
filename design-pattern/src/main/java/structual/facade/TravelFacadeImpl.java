package structual.facade;

/**
 * @Author : 吕茂华
 * @Date: 2024/4/30 11:07
 * @Description:
 */
public class TravelFacadeImpl implements TravelFacade{
    private HotelService hotelService;
    private TicketService ticketService;
    private FlightService flightService;

    public TravelFacadeImpl() {
        hotelService = new HotelService();
        ticketService = new TicketService();
        flightService = new FlightService();
    }

    @Override
    public void depart() {
        flightService.bookFlight();
        hotelService.bookHotel();
        ticketService.bookTicket();
    }
}
