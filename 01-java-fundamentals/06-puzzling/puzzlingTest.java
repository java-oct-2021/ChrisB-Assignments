import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class puzzlingTest {
    public static void main(String[] args) {
        //Get Ten Rolls
        puzzling t = new puzzling();
        ArrayList<Integer> randRolls = t.getRolls();
        System.out.println(randRolls);
        // Alphabet
        // ArrayList<Object> getLetter = t.getAlphabet();
        System.out.println(t.getAlphabet());
        // random letter

    }
}


