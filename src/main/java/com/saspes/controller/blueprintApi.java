package com.saspes.controller;

import com.saspes.opencv.ImageProcessing;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class blueprintApi {

    @Autowired
    private ImageProcessing imageProcessing;

    @GetMapping(value = "/blueprint", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody
    byte[] blueprint(@RequestParam String pngImage) throws IOException {
        System.out.println("pngImage = " + pngImage);
        String imgPath = System.getProperty("user.dir") + "/" + imageProcessing.blueprint(pngImage);
        final File initialFile = new File(imgPath);
        final InputStream in = new DataInputStream(new FileInputStream(initialFile));
        return IOUtils.toByteArray(in);
    }

}
