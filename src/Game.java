import java.util.Scanner;

public class Game {

    private Character player;
    private Scanner scanner;

    public Game(Character player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
    }


private void giveStartingItems() {

    Inventory inventory = player.getInventory();

    if (player instanceof Warrior) {
        inventory.addWeapon(new Weapon(
            "Sword", "A basic sword.",
            WeaponType.SWORD, Rarity.COMMON
        ));

    } else if (player instanceof Mage) {
        inventory.addWeapon(new Weapon(
            "Staff", "A basic magic staff.",
            WeaponType.STAFF, Rarity.COMMON
        ));

        for (int i = 0; i < 2; i++) {
            inventory.addPotion(new Potion(
                "Mana Potion", "Restores mana.",
                PotionType.MANA, 40
            ));
        }

    } else if (player instanceof Archer) {
        inventory.addWeapon(new Weapon(
            "Bow", "A basic wooden bow.",
            WeaponType.BOW, Rarity.COMMON
        ));
    }

    inventory.addArmor(new Armor(
        "Cloth Armor", "Basic protective clothing.",
        Rarity.COMMON
    ));

    for (int i = 0; i < 2; i++) {
        inventory.addPotion(new Potion(
            "Health Potion", "Restores health.",
            PotionType.HEALTH, 50
        ));
    }

    inventory.equipWeapon(0, player);
    inventory.equipArmor(0);
}


    public void start() {

        giveStartingItems();
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
                    inventoryMenu();
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

    
private void inventoryMenu() {

    Inventory inventory = player.getInventory();

    while (true) {
        System.out.println("\n===== INVENTORY MENU =====");
        System.out.println("1. View Inventory");
        System.out.println("2. Equip Weapon");
        System.out.println("3. Equip Armor");
        System.out.println("4. Use Potion");
        System.out.println("5. Return to Main Menu");
        System.out.print("Choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                inventory.displayInventory();
                break;

            case "2": {
                inventory.displayInventory();
                int index = readItemNumber();

                if (inventory.equipWeapon(index - 1, player)) {
                    System.out.println("Weapon equipped!");
                } else {
                    System.out.println("Invalid or incompatible weapon.");
                }
                break;
            }

            case "3": {
                inventory.displayInventory();
                int index = readItemNumber();

                if (inventory.equipArmor(index - 1)) {
                    System.out.println("Armor equipped!");
                } else {
                    System.out.println("Invalid armor selection.");
                }
                break;
            }

            case "4": {
                inventory.displayInventory();
                int index = readItemNumber();

                if (inventory.usePotion(index - 1, player)) {
                    System.out.println("Potion used!");
                } else {
                    System.out.println("Cannot use that potion.");
                }
                break;
            }

            case "5":
                return;

            default:
                System.out.println("Invalid option.");
        }
    }
}

private int readItemNumber() {
    System.out.print("Enter item number: ");

    try {
        return Integer.parseInt(scanner.nextLine().trim());
    } catch (NumberFormatException e) {
        return -1;
    }
}

}