package lk.slt.security.logfilemaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

//    @GetMapping("/index")
//    public String homePage() {
//        return "index";
//    }
//
//    @GetMapping("/")
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping("/logout")
//    public String logout(){
//        return "login";
//    }

    @GetMapping("/index")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/login")
        public String login(){
            return "loginForm";
        }


    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

}
