package testing;


import marvin.image.MarvinImage;

import marvin.image.MarvinImageMask;
import marvin.io.MarvinImageIO;
import marvinplugins.MarvinPluginCollection;


public class Blur {

    public void blurImage(String originPath, int radius, String resultPath) throws Exception{


        MarvinImage bImageIn = MarvinImageIO.loadImage(originPath);
       MarvinPluginCollection.gaussianBlur(bImageIn.clone(), bImageIn, radius);
       MarvinImageIO.saveImage(bImageIn, resultPath);


    }

}
