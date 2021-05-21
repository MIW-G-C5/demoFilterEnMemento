package designpatternvoorbeelden.command;


import java.util.ArrayList;
import java.util.List;

public class CommandPattern{
    public static void main(String[] args) {
        TicketVerwerker tv = new TicketVerwerker();
        Ticket tc = new Ticket("Pietersen");

        tv.voegOpdrachtToe(    new TicketWeggooien( new Ticket("Janssen") )    );
        tv.voegOpdrachtToe(    new TicketBeantwoorden(tc)    );
        tv.voegOpdrachtToe(    new TicketOpvolgen(tc)    );
        tv.voegOpdrachtToe(    new TicketWeggooien(tc)    );

        tv.voerVerwerkingUit();
    }
}

interface TicketVerwerking{
    void verwerken();
}

class Ticket{
    String klantnaam;

    Ticket(String klantnaam){  // shadowing
        this.klantnaam = klantnaam;
    }

    void weggooien() {
        System.out.println("ticket weggooien"+klantnaam);
    }
    void beantwoorden() {
        System.out.println("ticket beantwoorden"+klantnaam);
    }
    void opvolgen() {
        System.out.println("ticket opvolgen"+klantnaam);
    }
}

class TicketWeggooien implements TicketVerwerking{
    private Ticket ticket;
    public TicketWeggooien(Ticket ticket) {
        this.ticket = ticket;
    }
    @Override
    public void verwerken() {
        ticket.weggooien();
    }
}
class TicketBeantwoorden implements TicketVerwerking{
    private Ticket ticket;
    public TicketBeantwoorden(Ticket ticket) {
        this.ticket = ticket;
    }
    @Override
    public void verwerken() {
        ticket.beantwoorden();
    }
}
class TicketOpvolgen implements TicketVerwerking{
    private Ticket ticket;
    public TicketOpvolgen(Ticket ticket) {
        this.ticket = ticket;
    }
    @Override
    public void verwerken() {
        ticket.opvolgen();
    }
}
class TicketVerwerker{
    private List<TicketVerwerking> verwerkingslijst = new ArrayList();

    public void voegOpdrachtToe(TicketVerwerking tv) {
        verwerkingslijst.add(tv);
    }
    public void voerVerwerkingUit() {
        for(TicketVerwerking tv : verwerkingslijst) {
            tv.verwerken();
        }
        verwerkingslijst.clear();
    }
}





