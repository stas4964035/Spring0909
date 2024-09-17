package k44.hw3_1.services;

import k44.hw3_1.domain.User;
import k44.hw3_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository userRepository;

    public List<User> sortUserByAge() {
        return userRepository.getUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(int age) {
        return userRepository.getUsers().stream()
                .filter(user -> user.getAge() < age)
                .collect(Collectors.toList());
    }

    public double calculateAverage() {
        return userRepository.getUsers().stream()
                .mapToInt(User::getAge)
                .average().orElse(0);
    }

    public List<User> getAllUsers(){
        return userRepository.getUsers();
    }
}
