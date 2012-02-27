package xbridge;

import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ReRunFormatter implements Formatter, Reporter {

    private FileWriter appendable;

    private String featureURI;

    private int lineNumber;

    public ReRunFormatter(Appendable appendable) {
        this.appendable = (FileWriter) appendable;
    }

    /**
     * Called at the start of running the feature.
     * @param featureURI The relative path to the feature file.
     */
    public void uri(String featureURI) {
        log("FeatureURI: " + featureURI);
        this.featureURI = featureURI;
    }

    public void feature(Feature feature) {
        log("Processing feature: " + featureURI);
    }

    public void background(Background background) {
    }

    public void scenario(Scenario scenario) {
        log("Processing scenario for feature: " + featureURI);
        this.lineNumber = scenario.getLine();
    }

    public void scenarioOutline(ScenarioOutline scenarioOutline) {
        log("Processing scenario outline for feature: " + featureURI);
    }

    public void examples(Examples examples) {
        log("Processing examples for feature: " + featureURI);
    }

    public void step(Step step) {
        log("Processing step for feature: " + featureURI);
    }

    /**
     * Called when the current feature file has been run.
     */
    public void eof() {
        log("End of feature: " + featureURI);
    }

    public void syntaxError(String state, String event, List<String> legalEvents, String uri, int line) {
    }

    /**
     * Called when all features are processed.
     */
    public void done() {
        log("Processed all features");
    }

    /**
     * Called to close formatter.
     */
    public void close() {
        log("Closing formatter");
        try {
            appendable.close();
        } catch (IOException e) {
            throw new RuntimeException("Unable to close file", e);
        }
    }

    private void log(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        try {
            appendable.write(message);
            appendable.write(" ");
            appendable.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void result(Result result) {

        log("Result for featureURI: " + format());
        if (result != null && Result.FAILED.equals(result.getStatus())) {
           print(format());
        }
    }

    private String format() {
        return featureURI;
        // return featureURI + ":" + lineNumber;
    }

    /**
     * Called when a matching method is found in the glue code.
     * <br/> The match will be null if none was found.
     *
     * @param match
     */
    public void match(Match match) {
    }

    public void embedding(String mimeType, InputStream data) {
        throw new UnsupportedOperationException("Embedding not supported");
    }

    public void write(String text) {
        throw new UnsupportedOperationException("Write not supported");
    }
}