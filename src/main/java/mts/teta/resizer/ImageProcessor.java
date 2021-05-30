/*package mts.teta.resizer;

import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import net.coobird.thumbnailator.*;
import org.bytedeco.javacpp.presets.opencv_core;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcessor{

    String originPath;
   String resultPath;
    int width;
    int height;

    // метод для иземнения размера изображения

    public void resizeImage(String origin, int width, int height, String output)
            throws Exception{

        Thumbnails.of(new File(origin))
                .size(width, height)
                .toFile(new File(output));

    }

    public void resizeImage(String originPath, int width, int height, String resultPath) throws Exception{
        MarvinImage image = MarvinImageIO.loadImage(this.originPath = originPath);
        MarvinPluginCollection.scale(image.clone(), image, this.width = width, this.height = height);
        MarvinImageIO.saveImage(image, this.resultPath = resultPath);
    }

}
*/
