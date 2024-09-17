package k44.hw3_1.services;

import k44.hw3_1.domain.User;
import k44.hw3_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    UserRepository userRepository;

    public boolean registerUser(User user) {
        if(!userRepository.findUser(user)){
            userRepository.addUser(user);
            return true;
        }
        return false;
    }
}
