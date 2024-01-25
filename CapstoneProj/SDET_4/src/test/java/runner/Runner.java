package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/resources/Feature/Verification.feature",
		glue={"StepDefinition","Base"},
	    monochrome=true
	
		)


//implementation of cucumber and testng

public class Runner extends AbstractTestNGCucumberTests {


	
}