import java.util.Scanner;

public class Game {

    private Character player;
    private Scanner scanner;

    public Game(Character player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }

    public void start() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. View Character Stats");
            System.out.println("2. Allocate Attribute Points");
            System.out.println("3. Explore");
            System.out.println("4. Inventory");
            System.out.println("5. Exit Game");

            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    player.displayStats();
                    break;

                case "2":
                    allocatePoints();
                    break;

                case "3":
                    System.out.println("Exploration coming soon!");
                    break;

                case "4":
                    System.out.println("Inventory coming soon!");
                    break;

                case "5":
                    running = false;
                    System.out.println("Thanks for playing!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void allocatePoints() {

        while (player.getAttributePoints() > 0) {

            System.out.println("\nAvailable points: "
                    + player.getAttributePoints());

            System.out.println("1. Increase Strength");
            System.out.println("2. Increase Agility");
            System.out.println("3. Return to Main Menu");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {

                case "1":
                    player.allocateStrength(1);
                    System.out.println("Strength increased!");
                    break;

                case "2":
                    player.allocateAgility(1);
                    System.out.println("Agility increased!");
                    break;

                case "3":
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("No attribute points available.");
    }
}
