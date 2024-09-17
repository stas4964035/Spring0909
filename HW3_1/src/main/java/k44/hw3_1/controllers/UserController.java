package k44.hw3_1.controllers;

import k44.hw3_1.domain.User;
import k44.hw3_1.services.DataProcessingService;
import k44.hw3_1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    DataProcessingService dataProcessingService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return dataProcessingService.getAllUsers();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        if(userService.createUser(user)){
            return "User added successfully";
        }else{
            return "User creation failed";
        }
    }
}
