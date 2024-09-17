package k44.hw3_1.services;

import k44.hw3_1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    NotificationService notificationService;
    @Autowired
    RegistrationService registrationService;

    public boolean createUser(User user) {

        if(registrationService.registerUser(user)) {
            notificationService.userCreation(user);
            return true;
        }
        notificationService.userCreationFail(user);
        return false;
    }
}
