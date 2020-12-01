public class GasSpore extends Creature 
{
    public GasSpore() {
    super("GasSpore", 10, 1, 4, 0, 0, 0, 0);
}
  protected void doDamage(int points, Element attackForm) {
 hitPoints -= points;
 System.out.println(this + " takes " + points + " points of " + attackForm + " damage.");
    }


    public void takesDamage(int damage, Creature victim)
    {
}
}