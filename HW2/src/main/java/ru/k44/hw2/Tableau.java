package ru.k44.hw2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Tableau {
    private TicketNumberGenerator ticketNumberGenerator;

    public Tableau() {
        this.ticketNumberGenerator = new TicketNumberGenerator();
    }

    public Ticket createTicket(){
        return new Ticket(ticketNumberGenerator.createNewNumber(), LocalDateTime.now());
    }
}
