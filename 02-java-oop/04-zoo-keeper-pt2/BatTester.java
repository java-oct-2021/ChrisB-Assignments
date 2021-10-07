public class BatTester{ 
    
public static void main(String[] args) {
    Bat bat = new Bat(300);

    bat.attackTown();
    bat.eatHuman();
    bat.fly();
    bat.attackTown();
    bat.fly();
    bat.attackTown();
    bat.eatHuman();

    bat.displayEnergy();
    }
}
