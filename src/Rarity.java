public enum Rarity {

    COMMON(3),
    UNCOMMON(5),
    RARE(8),
    LEGENDARY(15);

    private final int bonus;

    Rarity(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }
}
