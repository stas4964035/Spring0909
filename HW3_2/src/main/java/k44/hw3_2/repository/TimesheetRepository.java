package k44.hw3_2.repository;

import k44.hw3_2.model.TimeSheet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TimesheetRepository {
    private Long sequence = 1L;
    private final List<TimeSheet> timesheets = new ArrayList<>();


    public TimeSheet create(TimeSheet timeSheet) {
        timeSheet.setId(sequence++);
        timesheets.add(timeSheet);

        return timeSheet;
    }


    public Optional<TimeSheet> get(Long id) {
        return timesheets.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();

    }


    public List<TimeSheet> getAll() {
        return List.copyOf(timesheets);
    }


    public void delete(Long id) {
        timesheets.stream()
                .filter(ts -> ts.getId().equals(id))
                .findFirst()
                .ifPresent(timesheets::remove);

    }

    public List<TimeSheet> getBeforeDate(LocalDate date){
        return List.copyOf(timesheets.stream().filter(ts -> ts.getCreated().isBefore(date)).toList());
    }

    public List<TimeSheet> getAfterDate(LocalDate date){
        return List.copyOf(timesheets.stream().filter(ts -> ts.getCreated().isAfter(date)).toList());
    }

}
