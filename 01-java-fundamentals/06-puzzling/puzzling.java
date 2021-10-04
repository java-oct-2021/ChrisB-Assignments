import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class puzzling {

    // rolls
    public ArrayList<Integer>getRolls(){
        ArrayList<Integer> rolls = new ArrayList<Integer>(); 
        Random r = new Random();

        for (int i = 1; i <=10; i++) {
            rolls.add(r.nextInt(20)+1);
        }
        return rolls;
        }
    
        // Alphabet
        public String RandomString () {
            String characters = "abcdefghijklmnopqrstuvwxyz";
            String randomString = " "; //Empty string, filled with characters
            int length = 1; //Length of string, can be set to any number or random

            Random rand = new Random ();
            char[] text = new char[length]; 

            for (int i = 0; i < length; i++) {
                text[i] = characters.charAt(rand.nextInt(characters.length()));
                randomString += text[i];
            }
            return randomString;
        }

        // Generate password
        public String randomPassword () {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String randomPass = " "; //Empty string, filled with characters
            int length = 8; //Length of string, can be set to any number or random

            Random rand = new Random (); 
            char[] text = new char[length]; 

            for (int i = 0; i < length; i++) {
                text[i] = characters.charAt(rand.nextInt(characters.length()));
                randomPass += text[i];
            }
            return randomPass;
        }

        // 8 random passwords
        public ArrayList<String> multiplePasswords (int length) {
            ArrayList<String> passwordChoices = new ArrayList<String> ();
            for (int i = 0; i < length; i++) {
                passwordChoices.add(randomPassword());
            }
            return passwordChoices;
        }
}




