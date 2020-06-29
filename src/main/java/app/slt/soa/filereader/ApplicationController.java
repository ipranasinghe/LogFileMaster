package app.slt.soa.filereader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController{

    @GetMapping("/index")
    public String homePage(){
        return "index";
    }
}
