package menu;


        import operation.Validation;

        import java.util.Objects;
        import java.util.Scanner;

public class Home {

    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("********************* Welcome to Maktab Hospital *********************");
            System.out.println(" ----  please select your service number: ");
            System.out.println("1- signUp");
            System.out.println("2- signIn");
            System.out.println("3- Exit");
            System.out.print("------- Enter command: ");
            String command = scanner.next();
            if (Objects.equals(command, "2")) {
                Validation validation = new Validation();
                validation.loginMenu();
            } else if (Objects.equals(command, "1")) {
                Validation validation = new Validation();
                validation.signupMenu();
            } else if ((Objects.equals(command, "3"))) {
                break;
            } else {
                System.out.println("Wrong command.");
            }

        }
    }

}
