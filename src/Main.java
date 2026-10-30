public class Main {

    public static void main(String[] args) {

        Warrior player = new Warrior("Hero");

        System.out.println("Before leveling:");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Max Health: " + player.getMaxHealth());

        player.gainExperience(100);

        System.out.println("\nAfter leveling:");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Max Health: " + player.getMaxHealth());
        System.out.println("Attribute Points: " + player.getAttributePoints());
    }
}