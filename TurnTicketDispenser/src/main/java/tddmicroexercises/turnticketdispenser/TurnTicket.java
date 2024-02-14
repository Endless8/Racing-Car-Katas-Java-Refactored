package tddmicroexercises.turnticketdispenser;

public class TurnTicket implements ITurnTicket {
    private final int turnNumber;

    public TurnTicket(int turnNumber) {
        this.turnNumber = turnNumber;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

}
