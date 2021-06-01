package mts.teta.resizer;

import mts.teta.resizer.imageprocessor.BadAttributesException;
import mts.teta.resizer.imageprocessor.ImageProcessor;
import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true,
        version = "https://github.com/4rl1996/resizer_mts_teta.git", description = "Available formats: jpeg png webp")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {


    public static void main(String... args) {
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {

        String input = (getInputPath());
        boolean endingJpg = input.endsWith(".jpg");
        boolean endingJpeg = input.endsWith(".jpeg");
        boolean endingPng = input.endsWith(".png");
        boolean endingWebp = input.endsWith(".webp");

        if (!endingJpg && !endingJpeg && !endingPng && !endingWebp) {
            throw new BadAttributesException("Can't read input file!");
        }

        if (getQualityValue() != null && (getQualityValue() < 0 || getQualityValue() > 100)) {
            throw new BadAttributesException("Please check params!");
        }

        if (getCropArgs() != null) {
            if (getCropArgs().size() < 4) {
                throw new BadAttributesException("Please check params!");
            } else {
                Integer cropWidth = getCropArgs().get(0);
                Integer cropHeight = getCropArgs().get(1);
                Integer cropX = getCropArgs().get(2);
                Integer cropY = getCropArgs().get(3);
                if (cropWidth < 1 || cropHeight < 1 || cropX < 0 || cropY < 0) {
                    throw new BadAttributesException("Please check params!");
                }
            }
        }

        if (getResizeArgs() != null) {
            if (getResizeArgs().size() < 2) {
                throw new BadAttributesException("Please check params!");
            } else {
                Integer width = getResizeArgs().get(0);
                Integer height = getResizeArgs().get(1);
                if (width < 1 || height < 1) {
                    throw new BadAttributesException("Please check params!");
                }
            }

        }

        if (getBlurRadius() != null && getBlurRadius() < 0) {
            throw new BadAttributesException("Please check params!");
        }

        if (getOutputFormat() != null) {
            boolean jpgFormat = getOutputFormat().endsWith("jpg");
            boolean jpegFormat = getOutputFormat().endsWith("jpeg");
            boolean pngFormat = getOutputFormat().endsWith("png");
            if (!jpegFormat && !jpgFormat && !pngFormat) {
                throw new BadAttributesException("Please check params!");
            }
        }

        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(ImageIO.read(new File(getInputPath())), this);
        return 0;
    }
}
