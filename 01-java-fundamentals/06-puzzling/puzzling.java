import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class puzzling {

    public ArrayList<Integer>getRolls(){
        ArrayList<Integer> rolls = new ArrayList<Integer>(); 
        Random r = new Random();

        for (int i = 1; i <=10; i++) {
            rolls.add(r.nextInt(20)+1);
        }
        return rolls;
        }
    
    // Alphabet
    public ArrayList<Object> getAlphabet(){
        ArrayList<Object> alphabet = new ArrayList<Object>();{
            Random r = new Random();
            int randomNum = r.nextInt(27);  
            for (char ch = 'a'; ch <= 'z'; ++ch) {
                alphabet.add(ch);
            }
            return alphabet;
        }
    }
}




