package testing;


import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;
import java.lang.*;

import static marvinplugins.MarvinPluginCollection.crop;

public class Crop {

   public void cropImage(String originPath, int x, int y, int width, int height, String resultPath) throws Exception {


       MarvinImage cImage = MarvinImageIO.loadImage(originPath);
       crop(cImage.clone(), cImage, x, y, width, height);
       MarvinImageIO.saveImage(cImage, resultPath);

   }



}
