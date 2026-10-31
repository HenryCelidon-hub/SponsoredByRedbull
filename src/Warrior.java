public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 150, 15, 7);
    }

    @Override 
    protected int getHealthIncrease() {
        return 20;
    }

    @Override
    public int useSpecialAbility() {
        return (int) Math.round(
        getStrength() * 2.5 + getAgility() * 0.5
        );
    }
}