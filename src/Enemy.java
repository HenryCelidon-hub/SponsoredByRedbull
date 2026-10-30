
public class Enemy {

    private String name;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int experienceReward;

    public Enemy(String name, int health, int attack,
                 int defense, int experienceReward) {

        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
        this.defense = defense;
        this.experienceReward = experienceReward;
    }

    public String getName() {
        return name;
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
