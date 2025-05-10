package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> /*Runnable*/ {
    @Option(names = { "-f", "--format" }, paramLabel = "format", description = "output format [default: stylish]")
    private String format;
    @Parameters(index = "0", description = "path to first file")
    private static String filepath1;
    @Parameters(index = "1", description = "path to second file")
    private static String filepath2;

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public String call() throws Exception {
        String resultString = Differ.generate(filepath1/*path1*/, filepath2/*path2*/);

        System.out.println(resultString);

        return "";
    }
}
