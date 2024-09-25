package k44.hw3_2.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class TimeSheet {
    private Long id;
    private Long projectName;
    private int minutes;
    private LocalDate created;

}
