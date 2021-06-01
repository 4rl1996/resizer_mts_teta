package mts.teta.resizer.imageprocessor;

import marvin.image.MarvinImage;
import marvinplugins.MarvinPluginCollection;
import mts.teta.resizer.ResizerApp;
import net.coobird.thumbnailator.Thumbnails;

import java.awt.image.BufferedImage;

public class ImageProcessor extends Exception {


    public void processImage(BufferedImage bufferedImage, ResizerApp resizerApp) throws Exception {

        if (resizerApp.getResizeArgs() != null) {
            bufferedImage = resizeImage(
                    bufferedImage,
                    resizerApp.getResizeArgs().get(0),
                    resizerApp.getResizeArgs().get(1));
        }

        if (resizerApp.getBlurRadius() != null) {
            bufferedImage = blurImage(bufferedImage, resizerApp.getBlurRadius());
        }

        if (resizerApp.getCropArgs() != null) {
            bufferedImage = cropImage(
                    bufferedImage,
                    resizerApp.getCropArgs().get(0),
                    resizerApp.getCropArgs().get(1),
                    resizerApp.getCropArgs().get(2),
                    resizerApp.getCropArgs().get(3));
        }

        Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(bufferedImage).scale(1);

        if (resizerApp.getQualityValue() != null) {
            builder = compressImage(builder, resizerApp.getQualityValue());
        }

        if (resizerApp.getOutputFormat() != null) {
            builder = convertImage(builder, resizerApp.getOutputFormat());
        }

        builder
                .toFile(resizerApp.getOutputPath());
    }

    private BufferedImage resizeImage(BufferedImage bufferedImage, Integer width, Integer height) throws Exception {
        return Thumbnails.of(bufferedImage)
                .forceSize(width, height)
                .asBufferedImage();
    }

    private Thumbnails.Builder<BufferedImage> compressImage(Thumbnails.Builder<BufferedImage> builder, Integer value) throws Exception {
        float usageQuality = (float) value / 100;

        return builder
                .outputQuality(usageQuality);
    }

    private BufferedImage blurImage(BufferedImage bufferedImage, Integer radius) throws Exception {

        MarvinImage bImageOut = new MarvinImage(bufferedImage);
        MarvinPluginCollection.gaussianBlur(bImageOut.clone(), bImageOut, radius);
        return bImageOut.getBufferedImageNoAlpha();
    }

    private BufferedImage cropImage(BufferedImage bufferedImage,
                                    Integer cropWidth,
                                    Integer cropHeight,
                                    Integer cropX,
                                    Integer cropY) throws Exception {


        MarvinImage cImage = new MarvinImage(bufferedImage);
        MarvinPluginCollection.crop(cImage.clone(), cImage, cropX, cropY, cropWidth, cropHeight);
        return cImage.getBufferedImageNoAlpha();
    }

    private Thumbnails.Builder<BufferedImage> convertImage(Thumbnails.Builder<BufferedImage> builder, String outputFormat) throws Exception {

        return builder
                .outputFormat(outputFormat);
    }
}

