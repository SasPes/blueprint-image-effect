package com.saspes.opencv;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.stereotype.Service;

@Service
public class ImageProcessingImpl implements ImageProcessing {

    @Override
    public String blueprint(String pngImage) {
        // String pngImage = "https://patentimages.storage.googleapis.com/76/c8/67/c6c729c7eabb9d/US4393673-drawings-page-2.png";
        String imgName = pngImage.substring(pngImage.lastIndexOf('/') + 1);
        try {
            BufferedInputStream in = new BufferedInputStream(new URL(pngImage).openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(imgName);

            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }

            // locla img for testing
//            URL img_url = getClass().getClassLoader().getResource("US4393673-drawings-page-2.png");
//            String img_path = img_url.getPath();
//            if (img_path.startsWith("/")) {
//                img_path = img_path.substring(1);
//            }
            
            String img_path = System.getProperty("user.dir") + "\\" + imgName;
            Mat imgMat = Imgcodecs.imread(img_path);

            Utils.blueprint(
                    Utils.transparetn(Utils.invertImage(imgMat)),
                    Utils.backgraund(imgMat),
                    "blueprint-" + imgName
            );
            return "blueprint-" + imgName; 
        } catch (MalformedURLException ex) {
            Logger.getLogger(ImageProcessingImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ImageProcessingImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
