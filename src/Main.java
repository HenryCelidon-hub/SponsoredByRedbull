public class Main {

    public static void main(String[] args) {

        Warrior player = new Warrior("Hero");

        System.out.println("Name: " + player.getName());
        System.out.println("Level: " + player.getLevel());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Strength: " + player.getStrength());
        System.out.println("Agility: " + player.getAgility());

        player.gainExperience(150);

        System.out.println("\nAfter gaining XP:");
        System.out.println("Level: " + player.getLevel());
        System.out.println("Remaining XP: " + player.getExperience());
        System.out.println("Available points: " + player.getAttributePoints());

    }
}