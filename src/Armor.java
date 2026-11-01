public class Armor extends Item {

    private final Rarity rarity;

    public Armor(String name, String description, Rarity rarity) {
        super(name, description);
        this.rarity = rarity;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getDefenseBonus() {
        return rarity.getBonus();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Rarity: " + rarity);
        System.out.println("Defense Bonus: +" + getDefenseBonus());
    }
}
