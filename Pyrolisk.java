public class Pyrolisk extends Creature {
    int magicLowDamage = 3;
    int magicHighDamage = 18;

    public Pyrolisk() {
    super("Pyrolisk", 12, 4, 15, 6, 0, 0, 0);
    }

    public boolean doMagicAttack(Creature victim) {
        int attackRoll = random.nextInt(20) + 1;
        if(attackRoll == 1 || attackRoll < hitPoints - victim.magicResistance) {
        int damage = random.nextInt(magicHighDamage-magicLowDamage + 1)
            + magicLowDamage;
        if(victim.isImmune(Element.FIRE))
            damage = 0;
        victim.takesDamage(damage); 
    }
        return false;
    }

    public boolean isImmune(Element af) {
	return af == Element.FIRE;
    }
}
