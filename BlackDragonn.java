public class BlackDragonn extends Creature {
  
    Element af;
    
    public BlackDragonn(){
      super("Black Dragon", 20, 6, 20, 3, 2, 1, 8);
      this.af = Element.DEATH;
    }
    
    protected boolean doMagicAttack(Creature victim) {
   
      
      
      
   
       while(victim.hitPoints > 0) {
       for(int turnn=0; turnn <= 3; turnn++){
       
       if(turnn % 3 == 0){
       int attackRoll = random.nextInt(20) + 1;
       if(attackRoll == 1 || attackRoll < hitPoints - victim.magicResistance) {
       return victim.isDead();
       }
       return true;
       }}}
       return false;
      
      
    }
    
    public boolean isImmune(Element af) {
        return this.af == af;
    }}