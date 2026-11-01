
public enum Biome {

    FOREST(
        new String[]{"Goblin", "Wolf", "Forest Spider"},
        40, 35
    ),

    DESERT(
        new String[]{"Scorpion", "Sand Bandit", "Desert Serpent"},
        55, 30
    ),

    COAST(
        new String[]{"Crab", "Sea Serpent", "Drowned Sailor"},
        50, 35
    );

    private final String[] enemies;
    private final int enemyChance;
    private final int treasureChance;

    Biome(String[] enemies, int enemyChance, int treasureChance) {
        this.enemies = enemies;
        this.enemyChance = enemyChance;
        this.treasureChance = treasureChance;
    }

    public String[] getEnemies() {
        return enemies.clone();
    }

    public int getEnemyChance() {
        return enemyChance;
    }

    public int getTreasureChance() {
        return treasureChance;
    }
}
