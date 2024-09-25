package k44.hw3_2.controllers;

import lombok.Data;

@Data
public class TimesheetPageDTO {
    private String projectName;
    private Long projectId;
    private String id;
    private String minutes;
    private String createdAt;

}
