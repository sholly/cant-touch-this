package com.jayshollenberger.canttouchthis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CantTouchController {

    @GetMapping("/cant")
    public String cantTouch() {
        return "after v0.0.6";
    }

    @GetMapping("/touch")
    public String noTouching() {
        return "no touching";
    }
}
