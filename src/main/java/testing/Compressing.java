package testing;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;


public class Compressing {

    public void changeQuality(String originPath, int value, String resultPath) throws Exception {

        float usageQuality = (float) value /100;



        Thumbnails.of(new File(originPath))
                    .outputQuality(usageQuality)
                    .scale(1)
                    .toFile(new File(resultPath));

        }

    }


