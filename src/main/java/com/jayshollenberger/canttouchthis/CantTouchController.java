package com.jayshollenberger.canttouchthis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.*;

import java.util.Map;

@RestController


public class CantTouchController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/")
    public String root() {
        return "can't touch this v0.0.2";
    }

    @GetMapping("/cant")
    public String cantTouch() {
        return "v0.0.2";
    }

    @GetMapping("/touch")
    public String noTouching() {
        return "no touching";
    }

    @GetMapping("/showenv")
    public String showEnv() {

        Map<String, String> env = System.getenv();
        logger.info("in showenv");

        return env.entrySet().toString();
    }
}
