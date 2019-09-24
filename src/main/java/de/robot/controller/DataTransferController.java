package de.robot.controller;

import de.robot.service.RecordService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/dataTransfer")
public class DataTransferController {

    private RecordService recordService;

    public DataTransferController(RecordService recordService) {
        this.recordService = recordService;
    }


    @GetMapping(value = "/getMove", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody int dataTransfer() {
        return recordService.findTopByOrderByIdDesc().getMove();
    }
}
