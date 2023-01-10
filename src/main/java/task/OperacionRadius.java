package task;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import userinterface.EvalartHomePage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;

public class OperacionRadius implements Task {

    private String operacion;

    public OperacionRadius() {
        if(TITULO.of("=?").resolveAllFor(theActorInTheSpotlight()).size() > 0){
            operacion = TITULO.of("=?").resolveFor(theActorInTheSpotlight()).getText();
        }
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        if(operacion != null) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            operacion = operacion.replace("=?", "");
            Object operation = engine.eval(operacion);
            INPUT_RADIO_BUTTON_MATH.resolveAllFor(theActorInTheSpotlight())
                    .forEach(x -> {
                        if (x.getValue().equals(operation.toString()))
                            x.click();
                    });
        }
    }

    public static OperacionRadius operacionRadius(){
        return instrumented(OperacionRadius.class);
    }
}
