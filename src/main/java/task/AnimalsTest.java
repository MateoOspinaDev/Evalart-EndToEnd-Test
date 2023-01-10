package task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static userinterface.EvalartHomePage.*;

public class AnimalsTest implements Task {

    private String animal;

    public AnimalsTest() {
        if(ANIMALS.resolveAllFor(theActorInTheSpotlight()).size() > 0){
            this.animal = TITULO.of("Indique cuantos")
                    .resolveFor(theActorInTheSpotlight()).getText()
                    .split(" ")[2];
        }
    }

    private int countAnimals(String animal){
        int cont = 0;
        String animales = ANIMALS.resolveFor(theActorInTheSpotlight()).getText().replace(animal,"a");
        for(int i = 0; i < animales.length(); i++){
            if(animales.charAt(i) == 'a'){
                cont++;
            }
        }
        return cont;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(animal != null){
            actor.attemptsTo(
                    Enter.keyValues(String.valueOf(countAnimals(animal))).into(INPUT_ANIMAL_ANSWER)
            );
        }
    }

    public static AnimalsTest animalsTest(){
        return instrumented(AnimalsTest.class);
    }
}
