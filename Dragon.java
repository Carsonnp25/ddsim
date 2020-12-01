public class Dragon extends Creature {

    Element attackForm;

    public Dragon(String color, Element attackForm) {
	super(color + " dragon", 20, 6, 20, 3, 2, 1, 8);
	this.attackForm = attackForm;
    }

    public boolean doMagicAttack(Creature victim) {
	int attackRoll = random.nextInt(20) + 1;
	if(attackRoll == 1 || attackRoll < strength - victim.magicResistance) {
	    int damage = random.nextInt(8) + 1;
	    if(victim.isImmune(attackForm))
		damage = 0;
	    System.out.println(this + " hits and does " + damage + " points of " + attackForm + " damage.");
	    victim.takesDamage(damage);
	    return true;
	}
	return false;
    }

    public boolean isImmune(Element af) {
	return af == attackForm;
    }
}
