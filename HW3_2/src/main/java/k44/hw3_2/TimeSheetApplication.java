package k44.hw3_2;

import k44.hw3_2.model.Project;
import k44.hw3_2.model.TimeSheet;
import k44.hw3_2.repository.ProjectsRepository;
import k44.hw3_2.repository.TimesheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class TimeSheetApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TimeSheetApplication.class, args);
        ProjectsRepository projectsRepository = ctx.getBean(ProjectsRepository.class);
        for(int i = 1; i<10; i++){
            Project project = new Project();
            project.setId((long)i);
            project.setName("Project #" + i);
            projectsRepository.create(project);
        }
        TimesheetRepository timesheetRepository = ctx.getBean(TimesheetRepository.class);
        LocalDate createdAt = LocalDate.now();
        for (int i = 0; i < 10; i++) {
            createdAt.plusDays(1);
            TimeSheet timeSheet = new TimeSheet();
            timeSheet.setId((long) i);
            timeSheet.setProjectName(ThreadLocalRandom.current().nextLong(1,11));
            timeSheet.setCreated(createdAt);
            timeSheet.setMinutes(ThreadLocalRandom.current().nextInt(100, 1000));

            timesheetRepository.create(timeSheet);

        }

    }

}
