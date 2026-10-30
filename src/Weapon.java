
public class Weapon extends Item {

    private Rarity rarity;
    private int damageBonus;

    public Weapon(String name, String description, Rarity rarity) {
        super(name, description);

        this.rarity = rarity;
        this.damageBonus = rarity.getBonus();
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();

        System.out.println("Rarity: " + rarity);
        System.out.println("Damage Bonus: +" + damageBonus);
    }
}
