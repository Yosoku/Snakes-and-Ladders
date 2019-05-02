package com.company.app;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class BufferedImageLoader {


    public static BufferedImage loadBufferedImage(String path)
    {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }
}