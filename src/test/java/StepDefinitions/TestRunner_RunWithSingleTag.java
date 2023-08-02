package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureWithTags",
				glue= {"StepDefinitions"}, tags= "@mustRun" 
				//TAGS
				//@smoke for scenario tagged with @smoke
				//@smoke and @fast for scenario tagged with both @smoke and @fast
				//@smoke or @fast for scenarios tagged with either @smoke or @database or both
				//@smoke and not @fast scenarios tagged with @smoke that aren't also tagged with @fast
				//To skip or Ignore Tags -> tags = "@smoke and not @regression" or tags= "(@smoke or @regression) and not important"
		)
public class TestRunner_RunWithSingleTag {

}
