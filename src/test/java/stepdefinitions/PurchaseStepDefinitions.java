package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import model.Candidate;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import userinterface.EvalartappLogin;

import static model.Candidate.CANDIDATE_INFORMATION;
import static model.CandidateFactory.createByName;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static task.Authenticate.authenticate;

public class PurchaseStepDefinitions {

    private EvalartappLogin loginPage; //Para no pasar new cuando lo usemos, no es necesario instanciarlo ya que serenity lo hace con los page object

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast()); //Con esta linea serenity tiene el poder para orquestar, importa varias cosas de selenium
    }

    @Given("^(.*) is authenticated$")
    public void Authenticate(String actorName) {
        Candidate aCandidate=createByName(actorName);

        theActorCalled(actorName).attemptsTo(
                Open.browserOn(loginPage),
                authenticate(aCandidate.getCredentials())
        );
        theActorInTheSpotlight().remember(CANDIDATE_INFORMATION, aCandidate);
    }

//    @Given("^add from (.*) [a-z]{1,2} (.*)$")
//    public void addToCart(String category, String product) {
//        Product aProduct = Product.builder().category(category).name(product).build();//Producto creado con los arumentos del feature
//
//        theActorInTheSpotlight().wasAbleTo(
//            Add.toCart(aProduct)
//        );
//    }
//
//
//    @When("^[a-zA-Z]{3,50} makes the purchase$")
//    public void purchase() {
//        theActorInTheSpotlight().attemptsTo(
//            buy()
//        );
//
//    }
//
//    @Then("should see the message Thank you for your purchase")
//    public void shouldSeeTheMessageThankYouForYourPurchase() {
//        theActorInTheSpotlight().should(
//                seeThat(thePurchaseIsSuccessful()));
//    }

}
