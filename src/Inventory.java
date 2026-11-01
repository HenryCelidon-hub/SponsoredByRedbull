import java.util.ArrayList;

public class Inventory {

    private Weapon equippedWeapon;
    private Armor equippedArmor;

    private final ArrayList<Weapon> weapons;
    private final ArrayList<Armor> armor;
    private final ArrayList<Potion> potions;

    public Inventory() {
        weapons = new ArrayList<>();
        armor = new ArrayList<>();
        potions = new ArrayList<>();
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void addArmor(Armor piece) {
        armor.add(piece);
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public boolean equipWeapon(int index, Character player) {
        if (index < 0 || index >= weapons.size()) {
            return false;
        }

        Weapon weapon = weapons.get(index);
        WeaponType requiredType;

        if (player instanceof Warrior) {
            requiredType = WeaponType.SWORD;
        } else if (player instanceof Mage) {
            requiredType = WeaponType.STAFF;
        } else if (player instanceof Archer) {
            requiredType = WeaponType.BOW;
        } else {
            return false;
        }

        if (weapon.getType() != requiredType) {
            return false;
        }

        equippedWeapon = weapon;
        return true;
    }

    public boolean equipArmor(int index) {
        if (index < 0 || index >= armor.size()) {
            return false;
        }

        equippedArmor = armor.get(index);
        return true;
    }

    public boolean usePotion(int index, Character player) {
        if (index < 0 || index >= potions.size()) {
            return false;
        }

        Potion potion = potions.get(index);
        int amount = potion.getRestoreAmount();

        if (potion.getType() == PotionType.HEALTH) {
            if (player.getHealth() >= player.getMaxHealth()) {
                return false;
            }

            player.heal(amount);

        } else if (potion.getType() == PotionType.MANA) {
            if (!(player instanceof Mage)) {
                return false;
            }

            Mage mage = (Mage) player;

            if (mage.getMana() >= mage.getMaxMana()) {
                return false;
            }

            mage.restoreMana(amount);
        }

        potions.remove(index);
        return true;
    }

    public int getDamageBonus() {
        return equippedWeapon == null
                ? 0 : equippedWeapon.getDamageBonus();
    }

    public int getDefenseBonus() {
        return equippedArmor == null
                ? 0 : equippedArmor.getDefenseBonus();
    }

    public void displayInventory() {
        System.out.println("\n===== INVENTORY =====");

        System.out.println("Equipped Weapon: " +
                (equippedWeapon == null
                ? "None" : equippedWeapon.getName()));

        System.out.println("Equipped Armor: " +
                (equippedArmor == null
                ? "None" : equippedArmor.getName()));

        System.out.println("\n--- Weapons ---");
        for (int i = 0; i < weapons.size(); i++) {
            Weapon w = weapons.get(i);
            System.out.println((i + 1) + ". " + w.getName()
                    + " [" + w.getRarity() + "]"
                    + " +" + w.getDamageBonus() + " damage");
        }

        System.out.println("\n--- Armor ---");
        for (int i = 0; i < armor.size(); i++) {
            Armor a = armor.get(i);
            System.out.println((i + 1) + ". " + a.getName()
                    + " [" + a.getRarity() + "]"
                    + " +" + a.getDefenseBonus() + " defense");
        }

        System.out.println("\n--- Potions ---");
        for (int i = 0; i < potions.size(); i++) {
            Potion p = potions.get(i);
            System.out.println((i + 1) + ". " + p.getName()
                    + " (+" + p.getRestoreAmount() + " "
                    + p.getType() + ")");
        }
    }
}
