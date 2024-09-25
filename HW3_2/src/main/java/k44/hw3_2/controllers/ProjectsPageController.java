package k44.hw3_2.controllers;

import k44.hw3_2.model.Project;
import k44.hw3_2.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home/projects")
@RequiredArgsConstructor
public class ProjectsPageController {
    private final ProjectService projectService;

    @RequestMapping
    public String getAllProjects(Model model) {
        List<Project> projects = projectService.getAll();
        model.addAttribute("projects", projects);
        return "projects-page.html";
    }

    @RequestMapping("/{id}")
    public String getProjectById(@PathVariable Long id, Model model) {
        Optional<Project> project = projectService.getById(id);
        if(project.isEmpty()){
            return "not-found.html";
        }
        model.addAttribute("project", project.get());
        return "project-page.html";
    }

}
