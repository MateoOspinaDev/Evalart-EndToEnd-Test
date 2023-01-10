package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;

public class DateTestAfter implements Task {

    private String days;
    private String date;

    public DateTestAfter() {
        if(TITULO_FECHAS.of("antes de").resolveAllFor(theActorInTheSpotlight()).size() > 0) {
            this.days = TITULO_FECHAS.of("antes de")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[6];
            this.date = TITULO_FECHAS.of("antes de")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[12];
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("days: " + days);
        System.out.println("date: " + date);
        if(days != null && date != null){
            String[] dateParts = date.split("/");
            LocalDate localDate = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
            localDate = localDate.plusDays(Integer.parseInt(days));
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyy");
            String finalDate = localDate.format(formatters);
            actor.attemptsTo(
                    Enter.keyValues(finalDate).into(INPUT_DATE));

        }
    }

    public static DateTestAfter dateTestAfter(){
        return instrumented(DateTestAfter.class);
    }
}
