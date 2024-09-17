package k44.hw3_1.repository;

import k44.hw3_1.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private List<User> users = new ArrayList<User>();

    public UserRepository() {
        users.add(new User("Ivan", 22,"Ivan@mail.ru"));
        users.add(new User("Petr", 32,"Petr@mail.ru"));
        users.add(new User("Anna", 50,"Anna@mail.ru"));
        users.add(new User("Olga", 20,"Olga@mail.ru"));
        users.add(new User("Olga", 54,"Olga@mail.ru"));
        users.add(new User("Andrey", 32,"Andrey@mail.ru"));
        users.add(new User("Sergey", 22,"Sergey@mail.ru"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean removeUserByID(int id) {
        if(users.get(id) != null){
            users.remove(id);
            return true;
        }
        return false;
    }

    public User getUserByID(int id) {
        return users.get(id);
    }

    public boolean findUser(User user) {
        return users.stream().anyMatch(u -> u.getEmail().equals(user.getEmail()));
    }
}
