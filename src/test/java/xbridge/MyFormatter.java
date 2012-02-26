package xbridge;

import gherkin.formatter.Formatter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFormatter implements Formatter {

    private FileWriter appendable;

    public MyFormatter(Appendable appendable) {
        this.appendable = (FileWriter) appendable;
        System.out.println(appendable);
    }

    public void uri(String s) {

    }

    public void feature(Feature feature) {
    }

    public void background(Background background) {
    }

    public void scenario(Scenario scenario) {
    }

    public void scenarioOutline(ScenarioOutline scenarioOutline) {
    }

    public void examples(Examples examples) {
    }

    public void step(Step step) {
    }

    public void eof() {
    }

    public void syntaxError(String s, String s1, List<String> strings, String s2, int i) {
    }

    public void done() {
    }

    public void close() {
        try {
            appendable.write("Done");
            appendable.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("*** Closing");
    }
}