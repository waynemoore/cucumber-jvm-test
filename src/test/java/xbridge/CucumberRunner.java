package xbridge;

import cucumber.cli.Main;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class CucumberRunner {

    public static void main(String[] argv) throws Throwable {

        final List<String> args = new ArrayList<String>(asList(argv));

        String rerunFileLocation;
        for (int i = 0; i < args.size(); i++) {
            String arg = args.get(i);
            if ("--rerun".equals(arg)) {
                rerunFileLocation = args.get(i + 1);
            }
        }

        for (String arg : args) {
            System.out.println(arg);
        }

        Main.main(args.toArray(new String[]{}));
    }
}
