
import java.util.ArrayList;

public class Inventory {

    private Weapon equippedWeapon;
    private Armor equippedArmor;
    private ArrayList<Potion> potions;

    public Inventory() {
        equippedWeapon = null;
        equippedArmor = null;
        potions = new ArrayList<>();
    }

    public void displayInventory() {
        System.out.println("\n===== INVENTORY =====");

        System.out.println("Weapon: " +
            (equippedWeapon == null ? "None" : equippedWeapon.getName()));

        System.out.println("Armor: " +
            (equippedArmor == null ? "None" : equippedArmor.getName()));

        System.out.println("Potions: " + potions.size());
    }
}
