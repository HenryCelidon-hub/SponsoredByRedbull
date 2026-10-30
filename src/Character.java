
public abstract class Character {

    // Character information
    private String name;
    private int level;
    private int experience;

    // Health
    private int health;
    private int maxHealth;

    // Combat attributes
    private int strength;
    private int agility;

    // Available points for customization
    private int attributePoints;
    
    // Constructor
    public Character(String name, int startingHealth,
                     int strength, int agility) {

        this.name = name;
        this.level = 1;
        this.experience = 0;

        this.maxHealth = startingHealth;
        this.health = startingHealth;

        this.strength = strength;
        this.agility = agility;

        this.attributePoints = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getAttributePoints() {
        return attributePoints;
    }

    // Method to allocate attribute points to strength
    public boolean allocateStrength(int points) {
        if (points <= 0 || points > attributePoints) {
        return false;
        }

        strength += points;
        attributePoints -= points;

        return true;
    }

    // Method to allocate attribute points to agility
    public boolean allocateAgility(int points) {
        if (points <= 0 || points > attributePoints) {
        return false;
        }

        agility += points;
        attributePoints -= points;

        return true;
    }

        // method to keep track of experince and implment leveing up.
        public void gainExperience(int xp) {
        if (xp <= 0) {
            return;
        }

        experience += xp;

        while (experience >= level * 100) {
            experience -= level * 100;
            levelUp();
        }
    }

    // methond to level up, updating required variables.
    private void levelUp() {
        level++;
        attributePoints += 2;
        
        int healthIncrease = getHealthIncrease();
        maxHealth += healthIncrease;
        health = maxHealth;

        System.out.println(name + " reached level " + level + "!");
        System.out.println("You earned 2 attribute points!");
        System.out.println("Current attribute points: " + attributePoints);

        onLevelUp();
    }

    // Method to be overridden by subclasses for additional level-up behavior
    protected void onLevelUp() {
        // Default implementation does nothing
    }


    // Method to take damage and update health
    public void takeDamage(int damage) {
        if (damage <= 0) {
            return;
        }
        health -= damage;

        if (health < 0) {
            health = 0;
        }
    }


    // Method to heal and update health
    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    protected abstract int getHealthIncrease();
}



