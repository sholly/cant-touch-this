package com.jayshollenberger.canttouchthis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CantTouchController {

    @GetMapping("/")
    public String root() {
        return "can't touch this root";
    }

    @GetMapping("/cant")
    public String cantTouch() {
        return "after v0.0.8";
    }

    @GetMapping("/touch")
    public String noTouching() {
        return "no touching";
    }

    @GetMapping("/showenv")
    public String showEnv() {

        Map<String, String> env = System.getenv();

        return env.entrySet().toString();
    }
}
