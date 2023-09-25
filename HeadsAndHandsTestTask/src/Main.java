public class Main {
    public static void main(String[] args) {
        Player player = new Player("Игрок", 20, 10, 100, 10, 20);
        Monster monster = new Monster("Монстр", 15, 8, 80, 8, 16);

        player.printStatus();
        monster.printStatus();

        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (!monster.isAlive()) {
                System.out.println("Монстр погиб.");
                break;
            }
            monster.attack(player);
            if (!player.isAlive()) {
                System.out.println("Игрок погиб.");
                break;
            }
            player.heal();
            player.printStatus();
            System.out.println("\n");
            monster.printStatus();
        }

        System.out.println("Игра завершена.");
    }
}