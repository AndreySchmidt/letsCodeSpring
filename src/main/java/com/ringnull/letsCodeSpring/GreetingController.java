package com.ringnull.letsCodeSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//@Controller была ошибка, поэтому заменил на @RestController... всё ок
@RestController
public class GreetingController {

    //    По пути ("/greeting") слушает запросы от пользователя и возвращает данные
    // Model model, addAttribute --- при работе с thymeleaf
//    @GetMapping ("/greeting")
//    public String greeting (@RequestParam (name="name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    // при работе с mustache -- Map<String, Object>, model.put
    @GetMapping ("/greeting")
    public String greeting (@RequestParam (name="name", required = false, defaultValue = "World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    // пустая аннотация потому, что она отвечает за корневой урл
    @GetMapping
    public String main (Map<String, Object> model) {
        model.put("Some", "here I am");
        return "main";
    }
}
