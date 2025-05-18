package ru.vladuss.railwayadministrationscisservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/admins")
    public String adminsPage() {
        return "admins";          // имя шаблона без .html
    }
}
