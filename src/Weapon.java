public class Weapon extends Item {

    private final WeaponType type;
    private final Rarity rarity;

    public Weapon(String name, String description,
                  WeaponType type, Rarity rarity) {
        super(name, description);
        this.type = type;
        this.rarity = rarity;
    }

    public WeaponType getType() {
        return type;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getDamageBonus() {
        return rarity.getBonus();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
        System.out.println("Rarity: " + rarity);
        System.out.println("Damage Bonus: +" + getDamageBonus());
    }
}
