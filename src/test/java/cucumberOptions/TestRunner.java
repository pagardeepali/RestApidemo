package cucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
    @RunWith(Cucumber.class)
    @CucumberOptions(
            features="src/test/java/features",
                    glue = {"stepDefination"},//tags = "@AddPlace",
            plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}

    )

    public class TestRunner {
    }

