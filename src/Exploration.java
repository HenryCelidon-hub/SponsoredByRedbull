
import java.util.Random;
import java.util.Scanner;

public class Exploration {

    private final Character player;
    private final Scanner scanner;
    private final Random random;
    private final LootGenerator lootGenerator;

    public Exploration(Character player, Scanner scanner) {
        this.player = player;
        this.scanner = scanner;
        this.random = new Random();
        this.lootGenerator = new LootGenerator();
    }

    public void explore(Biome biome) {

        if (player.getHealth() <= 0) {
            System.out.println("You cannot explore while defeated.");
            return;
        }

        System.out.println("\nExploring the " + biome + "...");

        int roll = random.nextInt(100);

        if (roll < biome.getEnemyChance()) {
            encounterEnemy(biome);

        } else if (roll < biome.getEnemyChance()
                + biome.getTreasureChance()) {
            lootGenerator.openChest(player, scanner);

        } else {
            System.out.println("You explored the area but found nothing.");
        }
    }

    private void encounterEnemy(Biome biome) {

        String[] enemies = biome.getEnemies();
        String enemyName = enemies[random.nextInt(enemies.length)];

        int playerLevel = player.getLevel();

        int minLevel = Math.max(1, playerLevel - 5);
        int maxLevel = playerLevel + 3;

        int enemyLevel = random.nextInt(
                maxLevel - minLevel + 1
        ) + minLevel;

        Enemy enemy = new Enemy(enemyName, enemyLevel);

        Combat combat = new Combat(player, enemy, scanner);
        CombatResult result = combat.start();

        if (result == CombatResult.VICTORY) {
            lootGenerator.generateEnemyDrop(enemy, player);

        } else if (result == CombatResult.FLED) {
            System.out.println("You escaped without receiving rewards.");

        } else {
            System.out.println("Your exploration has ended.");
        }
    }
}
