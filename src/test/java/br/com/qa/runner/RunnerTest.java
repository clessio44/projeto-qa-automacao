package br.com.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "br.com.qa.steps",
    tags = "@tag1", // Especifique as tags que deseja executar aqui
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunnerTest {

}
