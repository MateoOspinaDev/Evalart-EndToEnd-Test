package task;

import model.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static userinterface.EvalartHomePage.PRUEBA_AUTOMATIZACION_TEXT;
import static userinterface.EvalartappLogin.*;

public class Authenticate implements Task {
    private final Credentials credentials;

    public Authenticate(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    @Step("{0}  performs an authentication") //Para personalizar el mensaje de reporte, toma el parametro del metodo (actor)
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(credentials.getUsername()).into(USER_NAME),
                Enter.keyValues(credentials.getPassword()).into(PASSWORD),
                Click.on(LOGIN_BUTTON)
        );
        actor.should(seeThat(the(PRUEBA_AUTOMATIZACION_TEXT),isVisible()));
    }

    public static Authenticate authenticate(Credentials credentials){
        return instrumented(Authenticate.class,credentials);
    }
}
