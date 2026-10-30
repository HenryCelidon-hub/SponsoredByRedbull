import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===========================");
        System.out.println("   TURN BASED ADVENTURE    ");
        System.out.println("===========================");

        System.out.print("\nEnter your character name: ");
        String name = scanner.nextLine().trim();

        while (name.isEmpty()) {
            System.out.print("Name cannot be empty. Try again: ");
            name = scanner.nextLine().trim();
        }

        System.out.println("\nChoose your character class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");

        int choice = 0;

        while (choice < 1 || choice > 3) {
            System.out.print("Enter your choice (1-3): ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Please enter a number.");
                scanner.next();
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid class selection.");
            }
        }

        Character player;

        switch (choice) {
            case 1:
                player = new Warrior(name);
                break;

            case 2:
                player = new Mage(name);
                break;

            case 3:
                player = new Archer(name);
                break;

            default:
                throw new IllegalStateException("Invalid class");
        }

        System.out.println("\nCharacter created successfully!");

        player.displayStats();

        scanner.close();
    }
}
