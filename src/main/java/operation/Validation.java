package operation;

import entity.Person;
import entity.UserAccount;
import enums.AccountType;
import jakarta.persistence.Enumerated;
import menu.DoctorMenu;
import menu.PatientMenu;
import menu.SecretaryMenu;
import repository.person.impl.PersonRepoImpl;
import repository.userAccount.UserAccountRepoImpl;
import service.Person.PersonService;
import service.Person.impl.PersonServiceImpl;
import service.UserAccount.UserAccountService;
import service.UserAccount.impl.UserAccountServiceImpl;
import util.Hibernate;

import java.util.Optional;
import java.util.Scanner;

public class Validation {
    private final Scanner scanner = new Scanner(System.in);

    public void loginMenu() {

        System.out.println("Enter your username: ");
        String username = validName(scanner.next());
        System.out.println("Enter your password: ");
        String password = validName(scanner.next());
         UserAccountService userAccountService= new UserAccountServiceImpl(new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        Optional<UserAccount> optionalUserAccount = userAccountService.findUserAccount(username, password);
        optionalUserAccount.ifPresentOrElse(user -> {
            if(optionalUserAccount.get().getAccountType() == AccountType.DOCTOR) {
              DoctorMenu doctorMenu = new DoctorMenu();
              doctorMenu.showMenu(user);
            } else if (optionalUserAccount.get().getAccountType() == AccountType.PATIENT) {
                PatientMenu patientMenu = new PatientMenu();
                patientMenu.showMenu(user);
            } else if (optionalUserAccount.get().getAccountType() == AccountType.SECRETARY) {
                SecretaryMenu secretaryMenu = new SecretaryMenu();
                secretaryMenu.showMenu(user);
            }

        }, () -> System.out.println("username or password is wrong"));


    }

    private String validName(String name) {
        boolean check;
        while (true) {
            if (name.length() < 2 || name.length() > 20) {
                System.out.print("Name must between 2 and 20 character. Enter again: ");
                name = scanner.next();
                continue;
            }
            check = false;
            for (Character character : name.toCharArray()) {
                if (Character.isDigit(character)) {
                    System.out.print("Name cant have number. Enter again: ");
                    name = scanner.next();
                    check = true;
                    break;
                }
            }
            if (!check) return name;
        }
    }

    public void signupMenu() {
        System.out.println("Enter your firstname: ");
        String firstname = validName(scanner.next());
        System.out.println("Enter your lastname: ");
        String lastname = validName(scanner.next());
        System.out.println("Enter your nationalCode: ");
        Long nationalCode = scanner.nextLong();
        PersonService personService = new PersonServiceImpl(new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        Person person = new Person(firstname, lastname, nationalCode);
        System.out.println("Enter your username: ");
        String username = checkExistUsername(validName(scanner.next()));
        System.out.println("Enter your password: ");
        String password = scanner.next();
        System.out.println("1. Doctor ");
        System.out.println("2. Patient ");
        System.out.println("3. Secretary ");
        int accountTypeNum = scanner.nextInt();
        AccountType accountType = null;
        boolean a = true;
        while (a) {
            if (accountTypeNum == 1) {
                accountType = AccountType.DOCTOR;
                a = false;
            } else if (accountTypeNum == 2) {
                accountType = AccountType.PATIENT;
                a = false;
            } else if (accountTypeNum == 3) {
                accountType = AccountType.SECRETARY;
                a = false;
            } else {
                System.out.println("choose between 1, 2, 3");
            }
        }
        UserAccountService userAccountService= new UserAccountServiceImpl(new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
        UserAccount userAccount = new UserAccount(username, password, accountType, person);
        userAccountService.save(userAccount);
    }


    private String checkExistUsername(String username) {
        while (true) {
            UserAccountService userAccountService = new UserAccountServiceImpl(new UserAccountRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager()));
            Optional<UserAccount> optionalUser = userAccountService.findUserAccount(username);
            if (optionalUser.isPresent()) {
                System.out.print("This username is taken. try another one: ");
                username = scanner.next();
            } else {
                return username;
            }
        }
    }

}
