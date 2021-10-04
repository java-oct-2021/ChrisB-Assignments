import java.util.ArrayList;


public class puzzlingTest {
    private static char[] randomString;

	public static void main(String[] args) {
        //Get Ten Rolls
        puzzling t = new puzzling();
        ArrayList<Integer> randRolls = t.getRolls();
        System.out.println(randRolls);

        // Alphabet / random letter
        puzzling b = new puzzling();
        String randNum = b.RandomString();
        System.out.println(randNum);

        //Generate Password
        puzzling p = new puzzling();
        String randPassword = p.randomPassword();
        System.out.println(randPassword);

        //Generate 8 Passwords
        puzzling c = new puzzling();
        ArrayList<String> randPasswords = c.multiplePasswords(8);
        System.out.println(randPasswords);
    }
}


