package xbridge;

import cucumber.cli.Main;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CucumberRunner {

    public static void main(String[] argv) throws Throwable {

        final List<String> args = new ArrayList<String>(asList(argv));

        String rerunFileLocation = null;
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if ("--rerun".equals(arg)) {
                rerunFileLocation = args.get(i + 1);
            }
        }

        try {
            File file = new File(rerunFileLocation);
            final String content = FileUtils.readFileToString(file);
            final String[] failedFeatures = content.split(" ");

            for (String failedFeature : failedFeatures) {
                System.out.println("****** Failed feature: " + failedFeature);
            }


        } catch (IOException e) {
            // if file does not exist use feature path
        }

        for (String arg : args) {
            System.out.println(arg);
        }

        Main.main(args.toArray(new String[]{}));
    }
}
