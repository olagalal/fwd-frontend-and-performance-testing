package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/main/resources/features",
        glue = "stepDefinitions",
        monochrome = true,
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"},
        dryRun = false
        //tags = "@scenario1 then @scenario2"
        //@scenario2, @scenario3, @scenario4, @scenario5, @scenario6, @scenario7, @scenario8, @scenario9, @scenario10, @scenario11, @scenario12""
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
