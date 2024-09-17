package k44.hw3_2.controllers;

import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.service.TimesheetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/timesheets")
public class TimeSheetController {
    private final TimesheetService timesheetService;

    public TimeSheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @PostMapping
    public ResponseEntity<TimeSheet> create(@RequestBody TimeSheet timeSheet) {
        if (timesheetService.create(timeSheet) != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(timeSheet);
        }
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<TimeSheet> get(@PathVariable Long id) {
        Optional<TimeSheet> ts = timesheetService.get(id);
        if (ts.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(ts.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TimeSheet>> getAll(@RequestParam(required = false, name = "createdAtBefore") LocalDate beforeDate,
                                                  @RequestParam(required = false, name = "createdAtAfter") LocalDate afterDate) {
        if (beforeDate != null) {
            List<TimeSheet> timesheets = timesheetService.getBeforeDate(beforeDate);
            return ResponseEntity.status(HttpStatus.OK).body(timesheets);
        } else if (afterDate != null) {
            List<TimeSheet> timesheets = timesheetService.getAfterDate(afterDate);
            return ResponseEntity.status(HttpStatus.OK).body(timesheets);
        }
        return ResponseEntity.ok(timesheetService.getAll());
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        timesheetService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
