package week1;


/**
 * Simulate rolling two six-sided die, keep statistics
 * Modified for tracking 4 12 sided die.
 * 
 * @author Duke Software Team
 * @version 1.1
 */
import java.util.Random;

public class DiceRolling
{
    
    private class Dice {
        private int sides = 6;
        Random rand = new Random();
        Dice() {}
        Dice(int sides) {this.sides = sides;}
        
        int roll() {
            return rand.nextInt(sides)+1;
        }
    }
    
    public void simulate(int rolls){
        
        int [] counts = new int [49];
        Dice dice = new Dice(12);

        for(int k=0; k < rolls; k++){
            int d1 = dice.roll();
            int d2 = dice.roll();
            int d3 = dice.roll();
            int d4 = dice.roll();
            
            counts[d1+d2+d3+d4]++;
        }
        
        for (int k=4; k <=48; k++) {
            System.out.println(k + "'s=\t" + counts[k] + "\t" + 100.0 * counts[k]/rolls);
        }
        
}

    
    public void simpleSimulate(int rolls){
        Random rand = new Random();
        int twos = 0;
        int twelves = 0;

        for(int k=0; k < rolls; k++){
            int d1 = rand.nextInt(6) + 1;
            int d2 = rand.nextInt(6) + 1;
            if (d1 + d2 == 2){
                twos += 1;
            }
            else if (d1 + d2 == 12){
                twelves += 1;    
            }
        }
        
        System.out.println("2's=\t" + twos + "\t" + 100.0 * twos/rolls);
        System.out.println("12's=\t"+twelves+"\t"+100.0*twelves/rolls);
    }

}
