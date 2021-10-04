package com.jeremy.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jeremy.counter.App;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.servlet.http.HttpSession;
@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(App.class, args);

	}
	
    @RequestMapping("/")
    public String index(HttpSession session) {
        // If the count is not already in session
        if (session.getAttribute("count") == null) {
            // Use setAttribute to initialize the count in session
        	session.setAttribute("count", 1);
        }
        else {
            int counter = (int) session.getAttribute("count");
            counter++;
            session.setAttribute("count", counter);
        }
        return "index.jsp";
    }
    @RequestMapping("/counter")
    public String counter(Model model, HttpSession session) {
    	int counter = (int) session.getAttribute("count");
    	model.addAttribute("counter", counter);
    	return "counter.jsp";
    }
    
    


    //

}
