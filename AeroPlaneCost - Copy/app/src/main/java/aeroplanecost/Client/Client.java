package aeroplanecost.Client;

import java.util.*;

public class Client {
    static String clientName, clientSurname, clientEmail;
    static double clientBudget;

    String bankerName, bankerSurname, bankerEmail;
    int bankerBranchCode;
    private static double budgetMinimum = 275000;
    // Array list to store referrrals
    private static ArrayList<Client> listOfBankerReference = new ArrayList<Client>();

    public static double getBudgetMin() {
        return budgetMinimum;
    }
    //Method for Collecting user info
    public static void captureClient() {
        Scanner input = new Scanner(System.in);
        System.out.println("There is some Key information we need before proceeding:");
        System.out.println("\n____C L I E N T____I N F O R M A T I O N____");
        System.out.println("Enter your name:");
        clientName = input.nextLine();
        System.out.println("Enter the your surname:");
        clientSurname = input.nextLine();
        System.out.println("Enter the your Email:");
        clientEmail = input.nextLine();
        // Checking Email
        checkEmail(clientEmail);

        System.out.println("\n======================================"
                + "\nPlease take note of the following:"
                + "\n1. A minimum budget of $" + getBudgetMin() + " is required"
                + "\n======================================");
        System.out.println("Please enter your budget");
        clientBudget = input.nextDouble();
        minBudgeMet(clientBudget);
    }
    //Method to check email
    public static boolean checkEmail(String email) {
        Scanner getEmail = new Scanner(System.in);
        boolean isValid = (email.contains("@") && email.contains("."));

        while (!isValid) {
            System.out.println("Incorrect email format" + "\nPlease ensure email has the following: " +
                    "\n1.Includes an @" + "\n2.Ends with a ." + "Re-enter:");
            email = getEmail.nextLine();
            if (email.contains("@") && email.contains(".")) {
                isValid = true;
            }
        }
        return isValid;
    }
    //Method to compare minimum budget
    public static boolean minBudgeMet(double minBudget) {
        double clBudget = minBudget;
        boolean isValid = (clBudget >= 500000);
        if (!isValid) {
            System.out.println("You have not met the minimum budget" + "\n Re-enter an Amount");
            isValid = false;
        }
        return isValid;
    }
    
    //Method to print client details at end of program
    public static void printClient() {

        System.out.println("Thank you for your time: " + clientName + " " + clientSurname
                + "\nUsing the email: " + clientEmail + "\nWe will get back to you when possible.");
    }
    
    //method for capturing banker referral info
    public static void captureBanker() {
        Scanner input = new Scanner(System.in);
        // create users
        Client clientBankerReferral = new Client();
        System.out.println("In order to ensure maximum success in your application for aquiring a aircraft(s),"
                + "We require a referral from your Personal banker(s) in order to further understand your assets."
                + "\nPlease enter their details below:"
                + "\n*****************************************");

        System.out.println("Enter the Banker Name:");
        clientBankerReferral.bankerName = input.nextLine();
        System.out.println("Enter the Banker Surname:");
        clientBankerReferral.bankerSurname = input.nextLine();
        System.out.println("Enter the Banker Email:");
        clientBankerReferral.bankerEmail = input.nextLine();
        checkEmail(clientBankerReferral.bankerEmail);
        System.out.println("Enter the Banker Branch Code ID(1011 etc):");
        clientBankerReferral.bankerBranchCode = input.nextInt();

        // Saving Banker
        saveClientReferral(
                clientBankerReferral.bankerName,
                clientBankerReferral.bankerSurname,
                clientBankerReferral.bankerEmail,
                clientBankerReferral.bankerBranchCode);
    }

    // Method to add a Client to the arrayList
    public static void addClientReferenceToList(Client newBanker) {
        // add banker to arraylist
        listOfBankerReference.add(newBanker);
    }

    // Method to save referral details
    public static void saveClientReferral(String Name, String Surname, String Email, int Id) {
        // Create a new student
        Client clientReferral = new Client();
        // Setting student details
        clientReferral.bankerName = Name;
        clientReferral.bankerSurname = Surname;
        clientReferral.bankerEmail = Email;
        clientReferral.bankerBranchCode = Id;
        // Add the banker to the list
        Client.addClientReferenceToList(clientReferral);
    }

    // Method to fetch banker list
    public static ArrayList<Client> getBanker() {
        return listOfBankerReference;
    }

    public static int findStudentIndexById(String bankerId, ArrayList<Client> bankers) {
        for (int index = 0; index < bankers.size(); index++) {
            if (bankerId.equals(bankers.get(index).bankerBranchCode)) {
                return index;
            }
        }
        return -1; // Banker not found
    }

    // Method to delete user if confirmed
    public static boolean deleteBanker(String studentId, boolean confirmDelete) {
        ArrayList<Client> createdUsers = Client.getBanker();
        int index = findStudentIndexById(studentId, createdUsers);

        if (index == -1) {
            return false; // Banker not found
        }

        if (confirmDelete) {
            createdUsers.remove(index);
            return true; // Banker deleted
        }
        return false; // Deletion not confirmed
    }

    public static void DeleteBanker() {
        Scanner deleteStud = new Scanner(System.in);
        ArrayList<Client> createdUsers = Client.getBanker();
        System.out.println("Enter student id to delete: ");
        String toDelete = deleteStud.nextLine();

        int index = findStudentIndexById(toDelete, createdUsers);
        if (index == -1) {
            System.out.println("Banker with Branch Code: " + toDelete + " not found.");
        }
        // confirming deletion
        System.out.println("____C O N F I R M____R E M O V A L____");
        System.out.println("Are you sure you want to remove Banker from Branch: " + toDelete + " from the system?"
                + "\nYes (y) to delete"
                + "\nNo (Any key) to cancle");
        String confirmDelete = deleteStud.nextLine();

        boolean isDeleted = deleteBanker(toDelete, confirmDelete.equalsIgnoreCase("y"));

        if (isDeleted) {
            System.out.println("\n_____D E L E T I O N_____");
            System.out.println("Banker with Branch Code: " + toDelete + " WAS deleted!");
            System.out.println("----------------------------------------------------------------");
        } else {
            System.out.println("banker from Branch" + toDelete + " removal has been cancled");
        }
    }
}