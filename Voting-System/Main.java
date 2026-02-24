import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VotingSystem system = new VotingSystem();

        system.addCandidate("Yuva");
        system.addCandidate("Yuvi");

        while (true) {

            System.out.println("\n1. Register");
            System.out.println("2. User Login");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Username: ");
                    String regUser = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String regPass = sc.nextLine();
                    system.registerUser(regUser, regPass);
                    break;

                case 2:
                    System.out.print("Enter Username: ");
                    String user = sc.nextLine();
                    System.out.print("Enter Password: ");
                    String pass = sc.nextLine();

                    User loggedUser = system.loginUser(user, pass);

                    if (loggedUser != null) {
                        system.showCandidates();
                        System.out.print("Choose Candidate Number: ");
                        int voteChoice = sc.nextInt();
                        system.vote(loggedUser, voteChoice);
                    } else {
                        System.out.println("Invalid Login!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Admin Username: ");
                    String adminUser = sc.nextLine();
                    System.out.print("Enter Admin Password: ");
                    String adminPass = sc.nextLine();

                    if (system.adminLogin(adminUser, adminPass)) {
                        system.showResults();
                    } else {
                        System.out.println("Invalid Admin Login!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
