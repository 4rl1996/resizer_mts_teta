package testing;
    
import picocli.*;

import java.util.concurrent.Callable;

public class CommandLineTest implements Callable<Integer> {




    @CommandLine.Option(names = "convert", description = "Convert file")
    boolean create;

    @CommandLine.Option(names = "--quality", paramLabel = "")
    private int value;





    @Override
    public Object call() throws Exception {
        return null;
    }
}





