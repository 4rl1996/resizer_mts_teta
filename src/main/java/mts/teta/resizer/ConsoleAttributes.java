package mts.teta.resizer;

import picocli.CommandLine;

import java.util.List;

public class ConsoleAttributes {

    @CommandLine.Parameters(index = "0")
    private String inputPath;

    @CommandLine.Parameters(index = "1")
    private String outputPath;

    @CommandLine.Option(names = {"--resize"}, arity = "2", description = "resize the image")
    private List<Integer> resizeArgs; // width height

    @CommandLine.Option(names = {"--crop"}, arity = "4",
            description = "сut out one or more rectangular regions of the image")
    private List<Integer> cropArgs; //cropWidth, cropHeight, cropX, cropY;

    @CommandLine.Option(names = "--quality", description = "PEG/PNG compression level")
    private Integer qualityValue;

    @CommandLine.Option(names = "--blur", description = "reduce image noise and reduce detail levels")
    private Integer blurRadius;

    @CommandLine.Option(names = "--format", description = "the image format type")
    private String outputFormat;

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public Integer getQualityValue() {
        return qualityValue;
    }

    public Integer getBlurRadius() {
        return blurRadius;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public List<Integer> getCropArgs() {
        return cropArgs;
    }

    public List<Integer> getResizeArgs() {
        return resizeArgs;
    }

    // Сеттеры используются только для тестов

    public void setQualityValue(Integer qualityValue) {
        this.qualityValue = qualityValue;
    }

    public void setResizeArgs(List<Integer> resizeArgs) {
        this.resizeArgs = resizeArgs;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
}

