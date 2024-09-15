package ru.k44.hw2;

import org.springframework.stereotype.Component;


@Component
public class TicketNumberGenerator {
    private static int number;
    public String createNewNumber(){
        return "Ticket #" + ++number;
    }

    public String getNumber() {
        return String.valueOf(number);
    }
}
