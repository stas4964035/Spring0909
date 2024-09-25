package k44.hw3_2.service;

import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.repository.TimesheetRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
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
        if (timeSheet.getProjectName() == null) {
            throw new IllegalArgumentException("TimeSheet must have an Project ID");
        }
        if (projectService.getById(timeSheet.getProjectName()).isEmpty()) {
            throw new NoSuchElementException("Project ID not found");
        }
        return timesheetRepository.create(timeSheet);
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

//    public List<TimeSheet> getBeforeDate(LocalDate date) {
//        return timesheetRepository.getBeforeDate(date);
//    }
//    public List<TimeSheet> getAfterDate(LocalDate date) {
//        return timesheetRepository.getAfterDate(date);
//    }

    public List<TimeSheet> getAll(LocalDate beforeDate, LocalDate afterDate) {
        if (beforeDate == null && afterDate == null) {
            return timesheetRepository.getAll();
        }
        return timesheetRepository.getAll(beforeDate, afterDate);
    }
}
