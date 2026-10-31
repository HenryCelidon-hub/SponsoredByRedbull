import java.util.Random;
import java.util.Scanner;

public class Combat {

    private Character player;
    private Enemy enemy;
    private Scanner scanner;
    private Random random;

    public Combat(Character player, Enemy enemy, Scanner scanner) {
        this.player = player;
        this.enemy = enemy;
        this.scanner = scanner;
        this.random = new Random();
    }

    public void start() {

        System.out.println("\nA wild " + enemy.getName() + " appears!");

        while (player.getHealth() > 0 && enemy.isAlive()) {

            System.out.println("\n===== COMBAT =====");
            System.out.println(player.getName() + ": "
                    + player.getHealth() + "/" + player.getMaxHealth() + " HP");
            System.out.println(enemy.getName() + ": "
                    + enemy.getHealth() + "/" + enemy.getMaxHealth() + " HP");

            System.out.println("1. Attack");
            System.out.println("2. Use Speacial Ability");
            System.out.println("3. Use Potion");
            System.out.println("4. Flee");
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    playerAttack();
                    break;

                case "2":
                    if(!specialAttack()) {
                        continue;
                    }
                    break;

                case "3":
                    player.getInventory().displayInventory();
                    System.out.print("Potion number: ");

                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;

                        if (!player.getInventory().usePotion(index, player)) {
                            System.out.println("Cannot use that potion.");
                            continue;
                        }

                        System.out.println("Potion used!");

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number.");
                        continue;
                    }
                    break;

                case "4":
                    if (random.nextInt(100) < 50) {
                        System.out.println("You escaped successfully!");
                        return;
                    }

                    System.out.println("Failed to escape!");
                    break;

                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            if (enemy.isAlive()) {
                enemyAttack();
            }
        }

        if (!enemy.isAlive()) {
            System.out.println("\nYou defeated " + enemy.getName() + "!");
            System.out.println("Gained " + enemy.getExperienceReward() + " XP.");
            player.gainExperience(enemy.getExperienceReward());
        }

        if (player.getHealth() <= 0) {
            System.out.println("\nYou have been defeated!");
        }
    }

    private void playerAttack() {

        double strengthWeight = 1.0;
        double agilityWeight = 1.0;

        if (player instanceof Warrior) {
            strengthWeight = 1.5;
            agilityWeight = 0.5;
        } else if (player instanceof Mage) {
            strengthWeight = 0.5;
            agilityWeight = 0.5;
        } else if (player instanceof Archer) {
            strengthWeight = 0.7;
            agilityWeight = 1.3;
        }

        double baseDamage =
                player.getStrength() * strengthWeight
                + player.getAgility() * agilityWeight;

        int weaponBonus = player.getInventory().getDamageBonus();

        double multiplier = 0.8 + random.nextDouble() * 0.4;

        int damage = (int) Math.round(
                (baseDamage + weaponBonus) * multiplier
        );

        damage = Math.max(1, damage - enemy.getDefense());

        enemy.takeDamage(damage);

        System.out.println("You dealt " + damage + " damage!");
    }

    private void enemyAttack() {

        int damage = enemy.getAttack() + random.nextInt(5);

        damage -= player.getInventory().getDefenseBonus();
        damage = Math.max(1, damage);

        player.takeDamage(damage);

        System.out.println(enemy.getName() + " dealt "
                + damage + " damage!");
    }


private boolean specialAttack() {

    String abilityName;

    if (player instanceof Warrior) {
        abilityName = "Power Strike";
    } else if (player instanceof Mage) {
        abilityName = "Fireball";
    } else if (player instanceof Archer) {
        abilityName = "Precision Shot";
    } else {
        return false;
    }

    int baseDamage = player.useSpecialAbility();

    if (baseDamage < 0) {
        System.out.println("Not enough mana!");
        return false;
    }

    int weaponBonus = player.getInventory().getDamageBonus();

    double multiplier = 0.8 + random.nextDouble() * 0.4;

    int damage = (int) Math.round(
        (baseDamage + weaponBonus) * multiplier
    );

    damage = Math.max(1, damage - enemy.getDefense());

    enemy.takeDamage(damage);

    System.out.println(player.getName() + " used "
            + abilityName + "!");

    System.out.println("Dealt " + damage + " damage!");

    return true;
}

}
