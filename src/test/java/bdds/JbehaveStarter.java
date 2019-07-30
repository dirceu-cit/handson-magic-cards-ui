package bdds;


import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.context.Context;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.*;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.ScanningStepsFactory;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(JUnitReportingRunner.class)
public class JbehaveStarter extends JUnitStories {

    private static final String SRC_TEST_JAVA_STORIES_PATH = "/src/test/java/bdds/stories";
    private static final String ALL_STORIES = "**/*.story";
    private static final String STEPS_PACKAGE = "bdds.steps";
    private Configuration configuration;


    public JbehaveStarter() {
        Embedder embedder = configuredEmbedder();
        embedder.embedderControls()
                .doVerboseFailures(true)
                .useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        final CrossReference xref = new CrossReference();
        final Context context = new Context();
        final Format contextFormat = new ContextOutput(context);
        configuration = new MostUsefulConfiguration()
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withFormats(contextFormat)
                        .withCrossReference(xref))
                .useStoryLoader(new LoadFromClasspath(this.getClass()))
                .useFailureStrategy(new FailingUponPendingStep());
        return configuration;
    }
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new ScanningStepsFactory(configuration, STEPS_PACKAGE);
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(SRC_TEST_JAVA_STORIES_PATH, ALL_STORIES, "");
    }
}