import java.util.Scanner;
import java.util.Random;

public class Human extends Creature {

    private static Scanner sc = new Scanner(System.in);
    private static Random random = new Random();

    Element attackForm;

    public Human(boolean b) {
	super(b ? "player" : "human", 18, 6, 25, 4, 1, 1, 6);
	int n;
	if (b)
	    do {
		System.out.print("Choose your weapon: 1) Firebrand, 2) FrostBrand, 3) Mjollnir > ");
		n = sc.nextInt(); }
	    while(n < 1 || n > 3);
	else
	    n = random.nextInt(3) + 1;
	attackForm = (n == 1 ? Element.FIRE : (n == 2 ? Element.COLD : Element.LIGHTNING));
    }

	public void doAdditionalPhysicalAttack(Creature victim) {
	int damage = random.nextInt(8) + 1;
	if(victim.isImmune(attackForm))
	    damage = 0;
	victim.takesDamage(damage);
	System.out.println(this + " hits and does " + damage + " points of " + attackForm + " damage.");
	}
	
	public boolean isImmune(Element attackForm) {
		return this.attackForm == attackForm;
	}
}
