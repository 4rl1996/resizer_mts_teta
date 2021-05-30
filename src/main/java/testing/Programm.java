package testing;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public class Programm implements Callable <Integer> {

    @CommandLine.Option(names = "-input-file", description = "input file path")
    String originPath;

    @CommandLine.Option(names = "-output-file", description = "output file path")
    String resultPath;



    @CommandLine.Option(names = "-width", description = "width")
    int width;

    @CommandLine.Option(names = "-height", description = "height")
    int height;

    @CommandLine.Option(names = "-x", description = "x coordinate")
    int x;

    @CommandLine.Option(names = "-y", description = "y coordinate")
    int y;

    @CommandLine.Option(names = "-value", description = "compression level")
    int value;

    @CommandLine.Option(names = "-radius", description = "blur radius")
    int radius;

    @CommandLine.Option(names = "-format", description = "output format")
    String outputFormat;



    public static void main(String[] args) throws Exception{

        int exitCode = runConsole(args);
        System.exit(exitCode);

        //  --resize width height

       Resizing rImage = new Resizing();
        rImage.resizeImage("/home/user/Загрузки/nar.jpg", 100, 100,
                "/home/user/Загрузки/testOut.jpg");

        // -- quality value

        Compressing qImage = new Compressing();
        qImage.changeQuality("/home/user/Загрузки/nar.jpg", 15, "/home/user/Загрузки/testComp15.jpg");

        // --crop width height x y

        Crop cImage = new Crop();
        cImage.cropImage("/home/user/Загрузки/nar.jpg", 60,32,500,700, "/home/user/Загрузки/testCrop2.jpg");

        // --blur radius

        Blur bImage = new Blur();
        bImage.blurImage("/home/user/Загрузки/nar.jpg",5, "/home/user/Загрузки/testBlur50.jpg");

        // --format "outputFormat"

        Converting convertImage = new Converting();
        convertImage.convertImage("/home/user/Загрузки/nar.jpg", "png", "/home/user/Загрузки/convertedNAR");

    }

    protected static int runConsole(String[] args) {
        return new CommandLine(new Programm()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(value);
//        ImageProcessor imageProcessor = new ImageProcessor();
//        File file = new File("");
//        imageProcessor.processImage(ImageIO.read(file), this);
        return 0;
    }

}