public class Cockatrice extends Creature
{
    public Cockatrice(){
    super("Cockatrice", 12, 3, 16, 3, 1, 2, 8);
}
protected void  doAdditionalDamage(Creature victim) {
  
  int attackRoll = random.nextInt(20) + 1;
  if(attackRoll == 1 || attackRoll < hitPoints - victim.magicResistance) {
    System.out.println("You've have been petrified!");
    victim.hitPoints = 0; 
  }
}

public boolean isImmune(Element attackForm) {
    return attackForm == Element.PETRIFY;
}

}
