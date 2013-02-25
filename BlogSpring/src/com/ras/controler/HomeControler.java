package com.ras.controler;
 
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeControler {
	
	private static final Logger log = Logger.getLogger(HomeControler.class);
 
    @RequestMapping(value = "/")
    public String home() {
        log.debug("HomeController: Passing through...");
        
        return "/site/home.jsp";
    }
}