package tddmicroexercises.turnticketdispenser;

public class TurnTicketFactory implements ITurnTicketFactory {

    @Override
    public ITurnTicket getTurnTicket(int newTurnNumber) {
        return new TurnTicket(newTurnNumber);
    }

}
