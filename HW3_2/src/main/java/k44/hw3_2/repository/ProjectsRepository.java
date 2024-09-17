package k44.hw3_2.repository;

import k44.hw3_2.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectsRepository {

    private final List<Project> projects = new ArrayList<Project>();
    private Long sequence = 1L;

    public List<Project> getAll() {
        return List.copyOf(projects);
    }

    public Optional<Project> getById(Long id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst();
    }
    public Optional<Project> getByName(String name) {
        return projects.stream().filter(project -> project.getName().equals(name)).findFirst();
    }
    public Project create(Project project) {
        project.setId(sequence++);
        projects.add(project);
        return project;
    }

    public void delete(Long id) {
        projects.stream().filter(p -> p.getId().equals(id))
                .findFirst().ifPresent(projects::remove);
    }

    public Optional<Project> update(Project project, Project updatedProject) {
        projects.set(projects.indexOf(project), updatedProject);
        return getById(project.getId());
    }

}
