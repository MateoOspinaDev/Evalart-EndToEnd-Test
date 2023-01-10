package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://tasks.evalartapp.com/automatization/")
public class EvalartappLogin extends PageObject {

    public static final Target USER_NAME = Target.the("User name")
            .locatedBy("/html/body/div/div[2]/form/input[1]");

    public static final Target PASSWORD = Target.the("Password")
            .locatedBy("/html/body/div/div[2]/form/input[2]");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("/html/body/div/div[2]/form/button");

}
