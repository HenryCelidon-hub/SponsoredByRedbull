
public abstract class Character {

    // Character information
    private String name;
    private int level;
    private int experience;
    private Inventory inventory;

    // Health
    private int health;
    private int maxHealth;

    private int stamina;
    private int maxStamina;

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
        this.inventory = new Inventory();

        this.maxStamina = 50 + (agility * 2);
        this.stamina = maxStamina;
    }

    // Getters

    public int getStamina() {
        return stamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {
        return inventory;
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

        int newMaxStamina = 50 + (agility * 2);
        int staminaIncrease = newMaxStamina - maxStamina;

        maxStamina = newMaxStamina;
        stamina += staminaIncrease;

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

    // Method to display character stats
    public void displayStats() {
        System.out.println("\n===== CHARACTER STATS =====");
        System.out.println("Name: " + name);
        System.out.println("Class: " + getClass().getSimpleName());
        System.out.println("Level: " + level);
        System.out.println("Experience: " + experience + "/" + (level * 100));
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Stamina: " + stamina + "/" + maxStamina);
        System.out.println("Stamina Regen: " + getStaminaRegen() + " per turn");
        System.out.println("Strength: " + strength);
        System.out.println("Agility: " + agility);
        System.out.println("Attribute Points: " + attributePoints);
    }
    
    // Method to calculate stamina regeneration based on agility
    public int getStaminaRegen() {
        return 5 + (agility / 3);
    }


    // Method to use stamina and update stamina
    public boolean useStamina(int amount) {
        if (amount <= 0 || amount > stamina) {
            return false;
        }

        stamina -= amount;
        return true;
    }


    // Method to restore stamina and update stamina
    public void restoreStamina(int amount) {
        if (amount > 0) {
            stamina = Math.min(maxStamina, stamina + amount);
        }
    }

    public void resetStamina(){
        stamina = maxStamina;
    }

    // Abstract method for special ability, to be implemented by subclasses
    public abstract int useSpecialAbility();
}



