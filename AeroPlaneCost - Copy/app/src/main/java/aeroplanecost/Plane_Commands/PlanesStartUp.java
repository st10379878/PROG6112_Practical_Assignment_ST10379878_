package aeroplanecost.Plane_Commands;
import java.util.Scanner;
public class PlanesStartUp {

    
    public static void launchWelcomeMenu() {
        System.out.println("\nWith traffic going from bad to worse(Including the driver's themselves (=__=) ),"
                + "\nmany of us have joked and said that we should buy a plane instead." +
                "\nWhy should this remain a distant dream? We are here to make your flying aspirations a reality");
        System.out.println("__________________WELCOME TO________________________");
        System.out.println("____A E R O P L A N E____C O S T____ A N A L Y S I S");
        System.out.println("\n===========================================================");
    }
// Method to launch Selection Menu
    public static int launchSelectionMenu() {
        System.out.println("Please select one of the following menu items: " + "\n"
                + "(1)  View Planes" + "\n"
                + "(2)  Make a banker reference" + "\n"
                + "(3)  Print List of referrals" + "\n"
                + "(4)  Exit Application" + "\n");
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();
        return userChoice;
    }
// Termination method
    public static void exitPlaneApplication() {
        System.out.println("\n" +
                " ____________  / Safe flying fellow Aviator" + "\n" +
                "{____________}/" + "\n" +
                " |(-)____(-)/|" + "\n" +
                " |  |     |/ |" + "\n" +
                " |  |_____|  |");
    }
}
