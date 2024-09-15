package ru.k44.hw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Tableau t1 = new Tableau();
        Tableau t2 = new Tableau();
        System.out.println(t1.createTicket());
        System.out.println(t2.createTicket());
        System.out.println(t1.createTicket());
        System.out.println(t2.createTicket());

    }

}
