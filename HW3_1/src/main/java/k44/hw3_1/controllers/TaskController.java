package k44.hw3_1.controllers;


import k44.hw3_1.domain.User;
import k44.hw3_1.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUsersByAge(){
        return dataProcessingService.sortUserByAge();
    }

    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable int age){
        return dataProcessingService.filterUsersByAge(age);
    }

    @GetMapping("/calc")
    public double calcAvgAge(){
        return dataProcessingService.calculateAverage();
    }

}
