package xbridge;

import cucumber.cli.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CucumberReRunner {

    public static void main(String[] argv) throws Throwable {

        String baseDir = null;
        String[] failedFeatures = null;

        final List<String> args = new ArrayList<String>(asList(argv));
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if ("--rerun".equals(arg)) {
                args.remove(i);
                String rerunFileLocation = args.remove(i);
                baseDir = args.remove(i);

                try {
                    File file = new File(rerunFileLocation);
                    final String content = FileUtils.readFileToString(file);
                    failedFeatures = content.split(" ");

                    for (String failedFeature : failedFeatures) {
                        System.out.println("****** Failed feature: " + failedFeature);
                    }

                } catch (IOException e) {
                    // ignore ??
                }

                break;
            }
        }

        if (failedFeatures != null) {

            // append base dir
            for (String failedFeature : failedFeatures) {
               args.add(baseDir + "/" + failedFeature);
            }

            for (String arg : args) {
                System.out.println(arg);
            }

            Main.main(args.toArray(new String[]{}));
        }
    }
}
