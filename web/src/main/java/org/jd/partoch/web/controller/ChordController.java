package org.jd.partoch.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChordController {

    @GetMapping("/chord")
    public String chord(@RequestParam(name = "tone", required = false, defaultValue = "C") String tone, Model model) {
        model.addAttribute("tone", tone);
        return "chord";
    }
}
