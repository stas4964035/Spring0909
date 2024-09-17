package k44.hw3_2.controllers;

import k44.hw3_2.model.Project;
import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getById(@PathVariable Long id){
        Optional<Project> project = projectService.getById(id);
        if(project.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(project.get());
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/timesheets")
    public ResponseEntity<List<TimeSheet>> getTimesheetsByProject(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.getTimesheetsByProjectId(id));
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project){
        Project pr = projectService.create(project);
        if(pr != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(pr);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project project){
        Optional<Project> pr = projectService.update(id,project);
        if(pr.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(pr.get());
        }else{
            return ResponseEntity.noContent().build();
        }
    }


}
