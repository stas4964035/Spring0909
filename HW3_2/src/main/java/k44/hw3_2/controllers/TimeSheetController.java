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
import java.util.NoSuchElementException;
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
        timesheetService.create(timeSheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeSheet);


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
    public ResponseEntity<List<TimeSheet>> getAll(@RequestParam(required = false) LocalDate beforeDate,
                                                  @RequestParam(required = false) LocalDate afterDate) {

        return ResponseEntity.ok(timesheetService.getAll(beforeDate, afterDate));
    }
//    @GetMapping
//    public ResponseEntity<List<TimeSheet>> getAll(@RequestParam(required = false) LocalDate beforeDate,
//                                                  @RequestParam(required = false) LocalDate afterDate) {
//
//        return ResponseEntity.ok(timesheetService.getAll(beforeDate, afterDate));
//    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        timesheetService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
