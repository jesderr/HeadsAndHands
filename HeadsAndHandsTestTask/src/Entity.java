import java.util.Random;

class Entity {
    private String name;
    private int attack;
    private int defense;
    private int maxHealth;
    private int currentHealth;
    private int minDamage;
    private int maxDamage;


    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }


    public Entity(String name, int attack, int defense, int maxHealth, int minDamage, int maxDamage) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public void attack(Entity target) {
        int attackModifier = this.attack - target.defense + 1;
        int diceCount = Math.max(attackModifier, 1);
        int successfulHits = rollDice(diceCount);

        if (successfulHits > 0) {
            int damage = calculateDamage();
            target.takeDamage(damage);
            System.out.println(this.name + " атакует " + target.name + "а и наносит " + damage + " урона.");
        } else {
            System.out.println(this.name + " атакует " + target.name + "а, но не попадает.");
        }
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }

    private int rollDice(int diceCount) {
        Random random = new Random();
        int successfulHits = 0;
        for (int i = 0; i < diceCount; i++) {
            int roll = random.nextInt(6) + 1;
            if (roll >= 5) {
                successfulHits++;
            }
        }
        return successfulHits;
    }

    private int calculateDamage() {
        return new Random().nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void takeDamage(int damage) {
        currentHealth = Math.max(0, currentHealth - damage);
    }

    public void printStatus() {
        System.out.println(name + " (Здоровье: " + currentHealth + "/" + maxHealth +
                ", Атака: " + attack + ", Защита: " + defense + ")");
    }
}


