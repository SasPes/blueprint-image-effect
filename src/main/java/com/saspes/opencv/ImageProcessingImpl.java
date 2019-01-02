package com.saspes.opencv;

import java.net.URL;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingImpl implements ImageProcessing {

    @Override
    public void blueprint() {
        URL img_url = getClass().getClassLoader().getResource("US4393673.png");
//        URL img_url = getClass().getClassLoader().getResource("bmw.jpg");
        String img_path = img_url.getPath();
        if (img_path.startsWith("/")) {
            img_path = img_path.substring(1);
        }
        Mat imgMat = Imgcodecs.imread(img_path);

        Utils.blueprint(
                Utils.transparetn(Utils.edgeDetection(imgMat)),
                Utils.backgraund(imgMat)
        );
    }

}
