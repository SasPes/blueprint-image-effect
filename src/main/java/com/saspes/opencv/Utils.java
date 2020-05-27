package com.saspes.opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Utils {

    public static void blueprint(Mat transparent, Mat blueprint, String name) {
        double grid[] = {255, 255, 255, 150};
        for (int y = 0; y < transparent.rows(); ++y) {
            for (int x = 0; x < transparent.cols(); ++x) {
                double info[] = transparent.get(y, x);
                if (info[3] != 0) {
                    blueprint.put(y, x, info);
                } else if (y % 175 == 0 || x % 175 == 0) {
                    blueprint.put(y, x, grid);
                }

            }
        }
        Imgcodecs.imwrite(name, blueprint);
    }

    public static Mat backgraund(Mat imgMat) {
        // backgraund blue #065094 {6,80,148, 0.8}
        Mat blueprint = imgMat.clone();
        blueprint.setTo(new Scalar(148, 80, 6, 0.8));
        Imgproc.cvtColor(blueprint, blueprint, Imgproc.COLOR_RGB2RGBA);
        return blueprint;
    }

    // not needed
    public static Mat edgeDetection(Mat imgMat) {
        Mat detectedEdges = new Mat();
        Imgproc.cvtColor(imgMat, detectedEdges, Imgproc.COLOR_BGR2GRAY); // convert to grayscale
        Imgproc.blur(detectedEdges, detectedEdges, new Size(5, 5));  // reduce noise with a 3x3 kernel
        // canny detector, with ratio of lower:upper threshold of 3:1
        Double threshold = 50.0;
        Imgproc.Canny(detectedEdges, detectedEdges, threshold, threshold * 3);
        return detectedEdges;
    }

    public static Mat transparetn(Mat imgMat) {
        // replace gray with white
        Mat threshold = new Mat();
        Imgproc.threshold(imgMat, threshold, 100, 255, Imgproc.THRESH_BINARY);

        // convert to grayscale
        Mat grayscale = new Mat();
        Imgproc.cvtColor(threshold, grayscale, Imgproc.COLOR_BGR2GRAY);

        // transparent
        Mat transparent = new Mat();
        Imgproc.cvtColor(grayscale, transparent, Imgproc.COLOR_GRAY2RGBA);

        // start at row 0/col 0
        for (int y = 0; y < transparent.rows(); ++y) {
            for (int x = 0; x < transparent.cols(); ++x) {
                double info[] = transparent.get(y, x);
                if (info[0] == 0 && info[1] == 0 && info[2] == 0) {
                    info[3] = 0;
                    transparent.put(y, x, info);
                }
            }
        }

        return transparent;
    }

    public static Mat invertImage(Mat imgMat) {
        //Apply gaussian blur to remove noise
        Imgproc.GaussianBlur(imgMat, imgMat, new Size(5, 5), 0);

        //Invert the image
        Core.bitwise_not(imgMat, imgMat);

        return imgMat;
    }
}
