package banking.welcome;

public class WelcomeController implements WelcomeControllerToView, WelcomeControllerToModel {
    private WelcomeViewToController welcomeView;
    private WelcomeModelToController welcomeModel;

    WelcomeController(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        welcomeModel = new WelcomeModel(this);
    }

    @Override
    public void checkUserChoice(int choice) {
        switch (choice){
            case 2: welcomeView.attemptToLogin();
                    break;

            case 1: welcomeView.newUser();
                    break;

            default:
                System.out.println("Invalid Choice, Enter again");
                welcomeView.create();
        }
    }

    @Override
    public void verifycredentials(String username, String password) {
        welcomeModel.verifycredentials(username,password);
    }

    @Override
    public void valid(String username) {
        welcomeView.valid(username);
    }

    @Override
    public void invalid() {
        welcomeView.invalid();
    }
}