package task;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ui.Select;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;

public class OperacionNoRadius  implements Task {

    private String operacion;

    public OperacionNoRadius() {
        if(SELECT_INPUT_ANSWER_MATH.resolveAllFor(theActorInTheSpotlight()).size() > 0){
            operacion = NUMBERS_FOR_OPERATION.resolveFor(theActorInTheSpotlight()).getText();
        }
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(operacion != null){
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object operation = engine.eval(operacion);
            System.out.println(operation);
            actor.attemptsTo(
                    Select.option(operation.toString()).from(SELECT_INPUT_ANSWER_MATH)
            );
        }

    }

    public static OperacionNoRadius operacionNoRadius(){
        return instrumented(OperacionNoRadius.class);
    }
}
