package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;

//¿Cuál de estos números
public class MultipleTest  implements Task {

    private Integer number;

    public MultipleTest() {
        if(CHECKS.resolveAllFor(theActorInTheSpotlight()).size() > 0){
            this.number = Integer.parseInt(TITULO.of("de estos")
                    .resolveFor(theActorInTheSpotlight()).getTextContent()
                    .split(" ")[7]
                    .replace("?",""));
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(number != null) {
            CHECKS.resolveAllFor(theActorInTheSpotlight()).stream()
                    .forEach(check -> {
                        if (Integer.parseInt(check.getValue()) % number == 0) {
                            check.click();
                        }
                    });
        }
    }

    public static MultipleTest multipleTest(){
        return instrumented(MultipleTest.class);
    }

}
