package banking.welcome;

import banking.Repository.Bank;
import banking.dto.AccountDetails;

public class WelcomeModel implements WelcomeModelToController {
    WelcomeControllerToModel welcomeController;

    WelcomeModel(WelcomeController welcomeController) {
        this.welcomeController = welcomeController;
    }

    @Override
    public void verifycredentials(String username, String password) {

       boolean flag= Bank.getInstance().verifyCredentials(username,password);
       if(flag)
           valid(username);
       else
           inValid();
    }
    private void valid(String username){
         welcomeController.valid(username);
    }
    private void inValid(){
        welcomeController.invalid();
    }
}