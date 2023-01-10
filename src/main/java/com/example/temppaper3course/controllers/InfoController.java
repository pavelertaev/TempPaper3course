package com.example.temppaper3course.controllers;

import com.example.temppaper3course.record.InfoRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class InfoController {


        @GetMapping
        public String shop() {
            return "Интернет магазин запущен";
        }

        @GetMapping("/info")
        public InfoRecord info() {
            return new InfoRecord("Ертаев Павел ", "Интернет магазин по продаже носков");
        }
}
