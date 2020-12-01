public class RustMonster extends Creature {

    public RustMonster() { 
        super("Rust monster", 10, 3, 25, 2, 3, 0, 0);
}


    public void doAdditionalPhysicalAttack(Creature victim) {
        System.out.println(victim + " loses 1 in armor class.");
        victim.reduceAC();
           }
       }
	