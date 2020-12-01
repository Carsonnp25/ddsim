public class Nethack {
    public static void main(String[] args) {
	Creature player = new Human(true);
	//Creature player = new Lynx();
	for(int i=0; i<3; i++) {
	    Creature opponent = Creature.pickCreature();
	    System.out.println("Round " + (i+1) + ": Facing a " + opponent);
	    while(true) {
		player.attacks(opponent);
		if(opponent.isDead()) {
		    System.out.println("You killed " + opponent + ".");
		    break;
		}
		opponent.attacks(player);
		if(player.isDead()) {
		    System.out.println("You lose.");
		    return;
		}
	    }
	}
	System.out.println("You win!");
    }
}
