
public class Main {

    public static void main(String[] args) {

        Mage player = new Mage("Gandalf");

        System.out.println("Name: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Mana: " + player.getMana());

        // Test mana consumption
        player.useMana(30);

        System.out.println("Mana after spell: " + player.getMana());

        // Test mana restoration
        player.restoreMana(20);

        System.out.println("Mana after restoration: " + player.getMana());

        // Test leveling
        player.gainExperience(100);

        System.out.println("Level: " + player.getLevel());
        System.out.println("Max Health: " + player.getMaxHealth());
        System.out.println("Available Points: " + player.getAttributePoints());
    }
}
