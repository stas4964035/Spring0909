package k44.hw3_2.service;

import k44.hw3_2.model.Project;
import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.repository.ProjectsRepository;
import k44.hw3_2.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    ProjectsRepository projectsRepository;
    TimesheetRepository timesheetRepository;

    public ProjectService(ProjectsRepository projectsRepository, TimesheetRepository timesheetRepository) {
        this.projectsRepository = projectsRepository;
        this.timesheetRepository = timesheetRepository;
    }
    public List<TimeSheet> getTimesheetsByProjectId(long projectId) {
        return List.copyOf(timesheetRepository.getAll().stream().filter(ts -> ts.getProjectId().equals(projectId)).toList());
    }

    public List<Project> getAll() {
        return projectsRepository.getAll();
    }

    public Optional<Project> getById(Long id) {
        return projectsRepository.getById(id);
    }

    public Optional<Project> getByName(String name) {
        return projectsRepository.getByName(name);
    }

    public Project create(Project project) {
        if(projectsRepository.getByName(project.getName()).isEmpty()){
            return projectsRepository.create(project);
        }
        return null;
    }

    public void delete(Long id) {
        projectsRepository.delete(id);
    }

    public Optional<Project> update(Long id, Project project) {
        Optional<Project> pr = projectsRepository.getById(id);
        if(pr.isPresent() && getByName(project.getName()).isEmpty()){
            project.setId(id);
            return projectsRepository.update(pr.get(), project);
        }else{
            return Optional.empty();
        }
    }
}
