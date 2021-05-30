package testing;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

public class Converting {

    public void convertImage(String originPath, String outputFormat, String resultPath) throws IOException {

        Thumbnails.of(new File(originPath))
                .scale(1)
                .outputFormat(outputFormat)
                .toFile(new File(resultPath));

    }


}
