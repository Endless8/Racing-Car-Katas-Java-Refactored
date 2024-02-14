package tddmicroexercises.turnticketdispenser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketDispenserTest {

    private ITurnNumberSequence turnNumberSequence;
    private ITurnTicketFactory turnTicketFactory;

    @BeforeEach
    public void init() {
        turnNumberSequence = mock(ITurnNumberSequence.class);
        turnTicketFactory = mock(ITurnTicketFactory.class);
    }

    @Test
    void ticketDispensingTest() {
        ITurnTicket mockTicket = mock(ITurnTicket.class);
        ITurnTicket mockTicket2 = mock(ITurnTicket.class);

        when(mockTicket.getTurnNumber()).thenReturn(0);
        when(mockTicket2.getTurnNumber()).thenReturn(1);

        when(turnNumberSequence.getNextTurnNumber()).thenReturn(0, 1);
        when(turnTicketFactory.getTurnTicket(0)).thenReturn(mockTicket);
        when(turnTicketFactory.getTurnTicket(1)).thenReturn(mockTicket2);

        TicketDispenser dispenser = new TicketDispenser(turnNumberSequence, turnTicketFactory);
        ITurnTicket ticket = dispenser.getTurnTicket();
        TicketDispenser dispenser2 = new TicketDispenser(turnNumberSequence, turnTicketFactory);
        ITurnTicket ticket2 = dispenser2.getTurnTicket();

        assertEquals(0, ticket.getTurnNumber());
        assertEquals(1, ticket2.getTurnNumber());
    }

}
