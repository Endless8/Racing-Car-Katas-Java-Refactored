package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements ITurnNumberSequence {
    private static int _turnNumber = 0;

    public int getNextTurnNumber() {
        return _turnNumber++;
    }
}
