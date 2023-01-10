package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.INPUT_DATE;
import static userinterface.EvalartHomePage.TITULO;

//Indique la fecha
public class DateTest implements Task {

    private String days;
    private String date;

    public DateTest() {
        if(TITULO.of("antes de").resolveAllFor(theActorInTheSpotlight()).size() > 0) {
            this.days = TITULO.of("antes de")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[6];
            this.date = TITULO.of("antes de")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[13];
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("days: " + days);
        System.out.println("date: " + date);
        if(days != null && date != null){
            String[] dateParts = date.split("/");
            LocalDate localDate = LocalDate.of(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[0]));
            localDate = localDate.minusDays(Integer.parseInt(days));
            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyy");
            String finalDate = localDate.format(formatters);
            actor.attemptsTo(
                    Enter.keyValues(finalDate).into(INPUT_DATE));

        }
    }

    public static DateTest dateTest(){
        return instrumented(DateTest.class);
    }
}
