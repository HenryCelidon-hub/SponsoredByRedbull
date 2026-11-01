
public class Enemy {

    private final String name;
    private final int level;
    private int health;
    private final int maxHealth;
    private final int attack;
    private final int defense;
    private final int experienceReward;

    public Enemy(String name, int level) {
        this.name = name;
        this.level = Math.max(1, level);

        int baseHealth = 40;
        int baseAttack = 8;
        int baseDefense = 2;

        switch (name) {
            case "Wolf":
            case "Scorpion":
            case "Crab":
                baseHealth = 35;
                baseAttack = 10;
                baseDefense = 3;
                break;

            case "Forest Spider":
            case "Desert Serpent":
            case "Sea Serpent":
                baseHealth = 45;
                baseAttack = 11;
                baseDefense = 2;
                break;

            case "Sand Bandit":
            case "Drowned Sailor":
                baseHealth = 50;
                baseAttack = 9;
                baseDefense = 4;
                break;
        }

        maxHealth = baseHealth + 20 * this.level;
        health = maxHealth;
        attack = baseAttack + 4 * this.level;
        defense = baseDefense + this.level / 3;
        experienceReward = 25 + 25 * this.level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - Math.max(0, damage));
    }
}
