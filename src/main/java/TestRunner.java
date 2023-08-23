import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@test",
        glue = "steps",
        features = "classpath:features",
        plugin = {"pretty"}
)
public class TestRunner {

}
