import java.util.Random;

public class Creature {

    String name;
    int strength;
    int ac;
    int hitPoints;
    int magicResistance;
    int numAttacks;
    int lowDamage;
    int highDamage;
	int stunTurns;

    static Random random = new Random();

    public Creature(String name, int strength, int ac,
		    int hitPoints, int magicResistance,
		    int numAttacks, int lowDamage, int highDamage) {
	this.name = name;
	this.strength = strength;
	this.ac = ac;
	this.hitPoints = hitPoints;
	this.magicResistance = magicResistance;
	this.numAttacks = numAttacks;
	this.lowDamage = lowDamage;
	this.highDamage = highDamage;
	this.stunTurns = 0;
    }

    public String toString() { return name; }

    public static Creature pickCreature() {
	switch(random.nextInt(10)) {
	case 0: return new Dragon("red", Element.FIRE);
	case 1: return new Dragon("white", Element.COLD);
	case 2: return new Dragon("blue", Element.LIGHTNING);
	case 3: return new RustMonster();
	case 4: return new Pyrolisk();
	case 5: return new Lynx();
	case 6: return new Creature("lion", 18, 5, 25, 0, 3, 4, 14);
	case 7: return new Creature("tiger", 16, 4, 20, 0, 2, 2, 12);
	case 8: return new Creature("bear", 16, 3, 18, 0, 2, 2, 16);
	case 9: return new BlackDragonn();
	//case 10: return new Human(false);
	}
	return null;
    }

    public boolean isDead() { return hitPoints <= 0; }

    public void attacks(Creature victim) {
	if(stunTurns > 0) {
	    stunTurns--;
	    return;
	}
	boolean hits = false;
	for(int i=0; i<numAttacks; i++) {
	    int attackRoll = random.nextInt(20) + 1;
	    if(attackRoll == 1 || attackRoll < strength - victim.ac) {
		int damage = random.nextInt(highDamage - lowDamage + 1)
		    + lowDamage;
		victim.takesDamage(damage);
		System.out.println(this + " hits and does " + damage + " points of damage.");
		doAdditionalPhysicalAttack(victim);
		hits = true;
	    }
	}
	hits = hits || doMagicAttack(victim);
	if(!hits)
	    System.out.println(this + " misses.");
    }

    public void doAdditionalPhysicalAttack(Creature victim) {}

    protected boolean doMagicAttack(Creature victim) { return false; }

    public void takesDamage(int damage) { hitPoints -= damage; }

    public boolean isImmune(Element attackForm) { return false; }

    public int getAC() { return ac; }

    public void reduceAC() { ac--; }

    public void stunned(int n) { stunTurns = Math.max(stunTurns, n); }
    
}
