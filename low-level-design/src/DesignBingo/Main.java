package DesignBingo;

public class Main {
    public static void main(String[] args) {
        TicketService service = new TicketService(new TambolaGenerationStrategy(), new TicketValidator());
        Ticket ticket = service.createTicket(3, 9);
        System.out.println(ticket.toString());
    }
}
