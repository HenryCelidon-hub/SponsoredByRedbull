public class Potion extends Item {

    private final PotionType type;
    private final int restoreAmount;

    public Potion(String name, String description,
                  PotionType type, int restoreAmount) {
        super(name, description);

        if (restoreAmount <= 0) {
            throw new IllegalArgumentException(
                "Potion restoration must be positive."
            );
        }

        this.type = type;
        this.restoreAmount = restoreAmount;
    }

    public PotionType getType() {
        return type;
    }

    public int getRestoreAmount() {
        return restoreAmount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
        System.out.println("Restores: " + restoreAmount);
    }
}
