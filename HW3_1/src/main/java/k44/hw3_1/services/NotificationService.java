package k44.hw3_1.services;

import k44.hw3_1.domain.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void userCreation(User user) {
        System.out.println("User " + user.getName() +" created");
    }
    public void userCreationFail(User user) {
        System.out.println("User " + user.getName() +" NOT created");
    }
}
