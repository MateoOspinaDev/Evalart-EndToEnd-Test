package task;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ui.Select;
import org.apache.commons.lang3.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;
import static userinterface.EvalartHomePage.TITULO;

public class CountLetter implements Task {

    private String letter;
    private int repetitions;

    public CountLetter() {
        if(TITULO.of("Escriba").resolveAllFor(theActorInTheSpotlight()).size() > 0) {
            this.letter = TITULO.of("Escriba")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[5];
            this.repetitions = Integer.parseInt(TITULO.of("Escriba")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[1]);
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(letter != null){
            String letterRepetitions = StringUtils.repeat(letter, repetitions);
            letterRepetitions = letterRepetitions.replace("'","");
            actor.attemptsTo(
                    Enter.keyValues(letterRepetitions).into(REPEAT_LETTER_ANSWER)
            );
        }

    }

    public static CountLetter countLetter(){
        return instrumented(CountLetter.class);
    }
}
