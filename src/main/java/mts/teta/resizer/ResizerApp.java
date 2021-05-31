package mts.teta.resizer;


import mts.teta.resizer.imageprocessor.BadAttributesException;
import picocli.CommandLine;

import javax.imageio.ImageIO;
import java.io.File;

import java.util.concurrent.Callable;

//@CommandLine.Command(name = "resizer", mixinStandardHelpOptions = true, version = "resizer 0.0.1", description = "...")
public class ResizerApp extends ConsoleAttributes implements Callable<Integer> {

//    @CommandLine.Parameters(index = "0")
//    private String inputPath;
//
//    @CommandLine.Parameters(index = "1")
//    private String outputPath;
//
//    @CommandLine.Option(names = {"--resize"}, arity = "2", description = "")
//    private List<Integer> resizeArgs; // width height
//
//    @CommandLine.Option(names = {"--crop"}, arity = "4", description = "")
//    private List<Integer> cropArgs; //cropWidth, cropHeight, cropX, cropY;
//
//    @CommandLine.Option(names = "--quality", description = "compression level")
//    private Integer qualityValue;
//
//    @CommandLine.Option(names = "--blur", description = "blur radius")
//    private Integer blurRadius;
//
//    @CommandLine.Option(names = "--format", description = "output format")
//    private String outputFormat;


    public static void main(String... args) {
        int exitCode = runConsole(args);
        System.exit(exitCode);
    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new ResizerApp()).execute(args);
    }

    @Override
    public Integer call() throws Exception {

        if (getQualityValue() != null && (getQualityValue() < 0 || getQualityValue() > 100)) throw new BadAttributesException("Please check params!");


//        String inputFormat = new String(getInputPath()); //todo
//        boolean endingJpg;
//        endingJpg = inputFormat.endsWith();
//        boolean endingJpeg;





        // validation

        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.processImage(ImageIO.read(new File(getInputPath())), this);
        return 0;
    }
}

//    public String getInputPath() {
//        return inputPath;
//    }
//
//    public String getOutputPath() {
//        return outputPath;
//    }
//
//    public Integer getQualityValue() {
//        return qualityValue;
//    }
//
//    public Integer getBlurRadius() {
//        return blurRadius;
//    }
//
//    public String getOutputFormat() {
//        return outputFormat;
//    }
//
//    public List<Integer> getCropArgs() {
//        return cropArgs;
//    }
//
//    public List<Integer> getResizeArgs() {
//        return resizeArgs;
//    }
//
//    public void setQualityValue(Integer qualityValue) {
//        this.qualityValue = qualityValue;
//    }
//
//    public void setBlurRadius(Integer blurRadius) {
//        this.blurRadius = blurRadius;
//    }
//
//    public void setOutputFormat(String outputFormat) {
//        this.outputFormat = outputFormat;
//    }
//
//    public void setCropArgs(List<Integer> cropArgs) {
//        this.cropArgs = cropArgs;
//    }
//
//    public void setResizeArgs(List<Integer> resizeArgs) {
//        this.resizeArgs = resizeArgs;
//    }
//
//    public void setOutputPath(String outputPath) {
//        this.outputPath = outputPath;
//    }
//
//    public void setInputPath(String inputPath) {
//        this.inputPath = inputPath;
//    }
//}
