package lk.slt.soa.logfilesmaster.controller;

import lk.slt.soa.logfilesmaster.models.LogError;
import lk.slt.soa.logfilesmaster.service.LogFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LogFileController {

    @Autowired
    private LogFileService logFileService;

    @RequestMapping(value="/ViewPage", method = RequestMethod.GET)
    public Model GetLogFileErrors(Model model) {

        List<LogError> errorList = logFileService.GetAllLogErrors();
        model.addAttribute("errorList", errorList);
        return model;
    }
}
