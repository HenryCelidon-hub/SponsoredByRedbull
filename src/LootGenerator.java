
import java.util.Random;
import java.util.Scanner;

public class LootGenerator {

    private final Random random = new Random();

    private Rarity generateRarity(int level) {
        int roll = random.nextInt(100);

        if (level >= 10 && roll < 3) {
            return Rarity.LEGENDARY;
        }

        if (level >= 6 && roll < 15) {
            return Rarity.RARE;
        }

        if (level >= 3 && roll < 40) {
            return Rarity.UNCOMMON;
        }

        return Rarity.COMMON;
    }

    public Item generateItem(int level, Character player) {
        int roll = random.nextInt(100);

        // 40% weapon, 30% armor, 30% potion
        if (roll < 40) {
            WeaponType type;
            String name;

            if (player instanceof Warrior) {
                type = WeaponType.SWORD;
                name = "Sword";
            } else if (player instanceof Mage) {
                type = WeaponType.STAFF;
                name = "Staff";
            } else {
                type = WeaponType.BOW;
                name = "Bow";
            }

            return new Weapon(
                name,
                "A weapon discovered during exploration.",
                type,
                generateRarity(level)
            );
        }

        if (roll < 70) {
            return new Armor(
                "Armor",
                "Protective equipment discovered during exploration.",
                generateRarity(level)
            );
        }

        if (player instanceof Mage && random.nextBoolean()) {
            return new Potion(
                "Mana Potion",
                "Restores 40 mana.",
                PotionType.MANA,
                40
            );
        }

        return new Potion(
            "Health Potion",
            "Restores 50 health.",
            PotionType.HEALTH,
            50
        );
    }

    private void displayItem(Item item) {
        if (item instanceof Weapon) {
            Weapon weapon = (Weapon) item;
            System.out.println(weapon.getRarity() + " "
                    + weapon.getName() + " (+"
                    + weapon.getDamageBonus() + " damage)");

        } else if (item instanceof Armor) {
            Armor armor = (Armor) item;
            System.out.println(armor.getRarity() + " "
                    + armor.getName() + " (+"
                    + armor.getDefenseBonus() + " defense)");

        } else if (item instanceof Potion) {
            Potion potion = (Potion) item;
            System.out.println(potion.getName() + " (+"
                    + potion.getRestoreAmount() + " "
                    + potion.getType() + ")");
        }
    }

    private void addToInventory(Item item, Character player) {
        Inventory inventory = player.getInventory();

        if (item instanceof Weapon) {
            inventory.addWeapon((Weapon) item);
        } else if (item instanceof Armor) {
            inventory.addArmor((Armor) item);
        } else if (item instanceof Potion) {
            inventory.addPotion((Potion) item);
        }
    }

    private void offerItem(Item item, Character player) {
        System.out.println("\nYou received:");
        displayItem(item);
        addToInventory(item, player);
    }

    public void openChest(Character player, Scanner scanner) {
        System.out.println("\nYou discovered a treasure chest!");

        int roll = random.nextInt(100);

        if (roll < 20) {
            System.out.println("The chest is empty!");
            return;
        }

        Item first = generateItem(player.getLevel(), player);

        if (roll < 50) {
            offerItem(first, player);
            return;
        }

        Item second = generateItem(player.getLevel(), player);

        System.out.println("\nChoose one item:");
        System.out.print("1. ");
        displayItem(first);
        System.out.print("2. ");
        displayItem(second);
        System.out.println("3. Leave both items");

        while (true) {
            System.out.print("Your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    offerItem(first, player);
                    return;

                case "2":
                    offerItem(second, player);
                    return;

                case "3":
                    System.out.println("You leave the treasure behind.");
                    return;

                default:
                    System.out.println("Please choose 1, 2, or 3.");
            }
        }
    }

    public void generateEnemyDrop(Enemy enemy, Character player) {
        // 40% chance to drop an item
        if (random.nextInt(100) >= 40) {
            System.out.println("The enemy dropped no items.");
            return;
        }

        Item item = generateItem(enemy.getLevel(), player);

        System.out.println("\nThe enemy dropped an item!");
        offerItem(item, player);
    }
}
