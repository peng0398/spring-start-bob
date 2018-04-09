package com.play.bob.home.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author baobo.peng
 */
@Controller
@EnableAutoConfiguration
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Welcome you!";
    }
}
