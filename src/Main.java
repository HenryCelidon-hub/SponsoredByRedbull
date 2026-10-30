
public class Main {

    public static void main(String[] args) {

        Mage player = new Mage("Gandalf");

        player.useMana(60);

        System.out.println("Before leveling:");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Mana: " + player.getMana());
        System.out.println("Max Mana: " + player.getMaxMana());

        player.gainExperience(100);

        System.out.println("\nAfter leveling:");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Mana: " + player.getMana());
        System.out.println("Max Mana: " + player.getMaxMana());
        System.out.println("Max Health: " + player.getMaxHealth());
        System.out.println("Attribute Points: " + player.getAttributePoints());
    }
}