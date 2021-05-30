package testing;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;

public class Resizing{

    public void resizeImage(String originPath, int width, int height, String resultPath)
            throws Exception {
        Thumbnails.of(new File(originPath))
                .size(width, height)
                .toFile(new File(resultPath));
    }
}