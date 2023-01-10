package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EvalartHomePage extends PageObject {

    public static final Target PRUEBA_AUTOMATIZACION_TEXT = Target.the("Prueba text")
            .locatedBy("/html/body/div[1]/h1");

    public static final Target TITULO = Target.the("titulos")
            .locatedBy("//p[contains(text(), '{0}')]");


    //Operacion matematica con seleccion:
    public static final Target SELECT_INPUT_ANSWER_MATH = Target.the("Select input answer")
            .located(By.name("select"));

    public static final Target NUMBERS_FOR_OPERATION = Target.the("Select NUMBERS FOR OPERATION")
            //.locatedBy("//p[contains(text(), 'Complete la siguiente')]/following::p");
            .locatedBy("//select/preceding-sibling::p[1]");




    //Seleccionar cantidad de animales
    public static final Target INPUT_ANIMAL_ANSWER = Target.the("Select amount of animals")
            .located(By.name("number"));

    public static final Target ANIMALS = Target.the("animals")
            .locatedBy("//p[contains(text(), 'Indique cuantos')]/following::p");


    //seleccionar resultado operacion radio button
    public static final Target INPUT_RADIO_BUTTON_MATH = Target.the("Input name")
            .located(By.name("radio"));


    //Escriber una letra tantas veces
    public static final Target REPEAT_LETTER_ANSWER = Target.the("Repeat letter")
            .located(By.name("text"));

    //Fecha
    public static final Target INPUT_DATE = Target.the("Input date")
            .located(By.name("date"));

    //Fecha despues de
    public static final Target TITULO_FECHAS = Target.the("Titulos fechas")
            .locatedBy("//p[contains(text(), 'el') and contains(text(), 'desde')]");

    //Multiplo
    public static final Target CHECKS = Target.the("")
            .located(By.name("checkbox"));

    public static final Target INPUT_BUTTON = Target.the("Input button")
            .locatedBy("//button");

}
