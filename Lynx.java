public class Lynx extends Creature {
    int magicLowDamage = 3;
    int magicHighDamage = 12;
    public Lynx() {

	super("lynx", 12, 5, 20, 3, 2, 1, 4);
    }

    public boolean doMagicAttack(Creature victim) {
        int attackRoll = random.nextInt(20) + 1;
        if(attackRoll == 1 || attackRoll < hitPoints - victim.magicResistance) {
        int damage = random.nextInt(magicHighDamage-magicLowDamage + 1)
            + magicLowDamage;
        if(victim.isImmune(Element.COLD))
            damage = 0;
        victim.takesDamage(damage);
        return true;
        }
        return false;
    }

    public boolean isImmune(Element af) {
        return af == Element.COLD;
    }
}
