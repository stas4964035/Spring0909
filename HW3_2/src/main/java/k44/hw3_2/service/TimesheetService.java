package k44.hw3_2.service;

import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.repository.TimesheetRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class TimesheetService {
    private final TimesheetRepository timesheetRepository;
    private final ProjectService projectService;

    public TimesheetService(TimesheetRepository timesheetRepository, ProjectService projectService) {
        this.timesheetRepository = timesheetRepository;
        this.projectService = projectService;
    }

    public TimeSheet create(TimeSheet timeSheet) {
        timeSheet.setCreated(LocalDate.now());
        if(projectService.getById(timeSheet.getProjectId()).isPresent()) {
            return timesheetRepository.create(timeSheet);
        }
        return null;
    }


    public Optional<TimeSheet> get(Long id) {
        return timesheetRepository.get(id);

    }



    public List<TimeSheet> getAll() {
        return timesheetRepository.getAll();
    }


    public void delete(Long id) {
        timesheetRepository.delete(id);
    }

    public List<TimeSheet> getBeforeDate(LocalDate date) {
        return timesheetRepository.getBeforeDate(date);
    }
    public List<TimeSheet> getAfterDate(LocalDate date) {
        return timesheetRepository.getAfterDate(date);
    }
}
