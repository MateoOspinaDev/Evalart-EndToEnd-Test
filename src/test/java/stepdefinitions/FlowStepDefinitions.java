package stepdefinitions;

import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import task.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.INPUT_BUTTON;

public class FlowStepDefinitions {

    @When("Juan the user make the tests")
    public void juanTheUserMakeTheTests() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            theActorInTheSpotlight().attemptsTo(
                    AnimalsTest.animalsTest(),
                    OperacionRadius.operacionRadius(),
                    OperacionNoRadius.operacionNoRadius(),
                    CountLetter.countLetter(),
                    DateTest.dateTest(),
                    MultipleTest.multipleTest(),
                    DateTestAfter.dateTestAfter(),
                    Click.on(INPUT_BUTTON)

            );
            Thread.sleep(5000);
        }
    }
}
