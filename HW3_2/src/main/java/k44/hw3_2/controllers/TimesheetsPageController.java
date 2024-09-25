package k44.hw3_2.controllers;

import k44.hw3_2.service.TimesheetPageService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@RequestMapping("/home/timesheets")
@RequiredArgsConstructor
public class TimesheetsPageController {

    private final TimesheetPageService service;
    @RequestMapping
    public String getAllTimesheets(Model model) {
        List<TimesheetPageDTO> timesheets = service.findAll();
        model.addAttribute("timesheets", timesheets);
        return "timesheets-page.html";
    }
    @GetMapping("/{id}")
    public String getTimesheetsPage(@PathVariable Long id, Model model) {
        Optional<TimesheetPageDTO> timeSheetOpt = service.findById(id);
        if (timeSheetOpt.isEmpty()) {
            return "not-found.html";
            //FIXME
            //throw new NoSuchElementException();
        }
        model.addAttribute("timesheet", timeSheetOpt.get());

        return "timesheet-page.html";
    }
}
