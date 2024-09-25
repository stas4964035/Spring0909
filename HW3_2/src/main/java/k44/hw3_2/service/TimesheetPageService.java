package k44.hw3_2.service;

import k44.hw3_2.controllers.TimesheetPageDTO;
import k44.hw3_2.model.Project;
import k44.hw3_2.model.TimeSheet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TimesheetPageService {
    private final TimesheetService timesheetService;
    private final ProjectService projectService;

    public List<TimesheetPageDTO> findAll() {
        return timesheetService.getAll().stream()
                .map(this::convert).toList();
    }

    public Optional<TimesheetPageDTO> findById(Long id) {
        return timesheetService.get(id)
                .map(this::convert);

    }
    private TimesheetPageDTO convert(TimeSheet timeSheet) {
        Project project = projectService.getById(timeSheet.getProjectName())
                .orElseThrow();

        TimesheetPageDTO timesheetPageDTO = new TimesheetPageDTO();

        timesheetPageDTO.setProjectName(project.getName());
        timesheetPageDTO.setProjectId(project.getId());
        timesheetPageDTO.setId(timeSheet.getId().toString());
        timesheetPageDTO.setMinutes(String.valueOf(timeSheet.getMinutes()));
        timesheetPageDTO.setCreatedAt(String.valueOf(timeSheet.getCreated().toString()));


        return timesheetPageDTO;
    }
}
