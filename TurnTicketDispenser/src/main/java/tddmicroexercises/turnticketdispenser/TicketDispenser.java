package tddmicroexercises.turnticketdispenser;

public class TicketDispenser {
    private final ITurnNumberSequence turnNumberSequence;
    private final ITurnTicketFactory turnTicketFactory;

    public TicketDispenser(ITurnNumberSequence turnNumberSequence, ITurnTicketFactory turnTicketFactory) {
        this.turnNumberSequence = turnNumberSequence;
        this.turnTicketFactory = turnTicketFactory;
    }

    public ITurnTicket getTurnTicket() {
        int newTurnNumber = turnNumberSequence.getNextTurnNumber();
        return turnTicketFactory.getTurnTicket(newTurnNumber);
    }
}
