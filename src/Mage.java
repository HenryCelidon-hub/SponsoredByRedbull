public class Mage extends Character {

    private int mana;
    private int maxMana;
    
    // Constructor
    public Mage(String name) {
        super(name, 80, 5, 8);
        this.maxMana = 100;
        this.mana = maxMana;
    }

    @Override
    protected int getHealthIncrease() {
        return 10;  
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    // Method to use mana
    public boolean useMana(int amount) {
        if (amount <= 0 || amount > mana) {
            return false;
        }

        mana -= amount;
        return true;
    }

    public void restoreMana(int amount) {
        if (amount > 0) {
            mana = Math.min(maxMana, mana + amount);
        }
    }
}