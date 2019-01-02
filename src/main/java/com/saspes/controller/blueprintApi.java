package com.saspes.controller;

import com.saspes.opencv.ImageProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class blueprintApi {

    @Autowired
    private ImageProcessing imageProcessing;

    @GetMapping("/blueprint")
    public void blueprint() {
        imageProcessing.blueprint();
    }
}
