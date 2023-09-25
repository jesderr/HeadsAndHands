import java.util.Random;

public class Player extends Entity{
    private int healingCount = 4;
    private double maxHealingPercentage = 0.3;

    public Player(String name, int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        super(name, attack, defense, maxHealth, minDamage, maxDamage);
    }

    public void heal() {
        if (healingCount > 0) {
            int maxHealing = (int) (getMaxHealth() * maxHealingPercentage);
            int healingAmount = new Random().nextInt(maxHealing) + 1;
            setCurrentHealth(Math.min(getMaxHealth(), getCurrentHealth() + healingAmount));
            healingCount--;
            System.out.println(getName() + " исцеляется на " + healingAmount + " единиц здоровья.");
        } else {
            System.out.println(getName() + " не может больше исцеляться.");
        }
    }
}
