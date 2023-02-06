package com.nekrosis.shorter.controller;

import com.nekrosis.shorter.model.Url;
import com.nekrosis.shorter.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class UrlController {
    @Autowired
    UrlService service;
    
    @GetMapping("/")
    public String getLongUrl(@ModelAttribute("url")Url url) {
        return "index";
    }

    @PostMapping("/")
    public String createShort(Url url, Model model) {
        model.addAttribute("url", service.generatedShortUrl(url.getLongUrl()));
        return "result";
    }

    @GetMapping("/{id}")
    public String getLong(@PathVariable String id) {
        return "redirect:" + service.getLongUrl(id);
    }
}
