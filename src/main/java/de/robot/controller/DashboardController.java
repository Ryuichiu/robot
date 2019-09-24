package de.robot.controller;

import de.robot.model.Record;
import de.robot.service.AuthenticationService;
import de.robot.service.RecordService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/dashboard")
public class DashboardController {

    private AuthenticationService authenticationService;

    private RecordService recordService;

    public DashboardController(AuthenticationService authenticationService, RecordService recordService) {
        this.authenticationService = authenticationService;
        this.recordService = recordService;
    }


    @GetMapping("/")
    public ModelAndView dashboard() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("loggedInUser", authenticationService.findLoggedInUser());
        mav.addObject("Record", new Record());
        mav.setViewName("dashboard");
        return mav;
    }

    @PostMapping(value = "/setMove", produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView setMove(@Valid Record record) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/dashboard/");
        recordService.saveRecord(record);
        return mav;
    }
}
