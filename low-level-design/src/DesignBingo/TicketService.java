package DesignBingo;

public class TicketService {
    private final GenerationStrategy strategy;
    private final TicketValidator validator;

    public TicketService(GenerationStrategy strategy, TicketValidator validator) {
        this.strategy = strategy;
        this.validator = validator;
    }
    public Ticket createTicket(int r, int c) {
        Ticket ticket = new Ticket(r, c);
        strategy.populate(ticket);
        validator.validate(ticket);
        return ticket;
    }
}
