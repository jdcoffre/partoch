package org.jd.partoch.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {

    @RequestMapping("edit/new")
    public String getSongCreationForm(){
        return "songCreationForm";
    }

}
