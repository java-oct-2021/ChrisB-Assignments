public class Bat extends Mammal {

    public Bat(int energyLevel){
        super(energyLevel);
    }
    public void fly(){
        System.out.println("'The bat flys' FLAP");
        energyLevel -= 50;
    }

    public void eatHuman(){
        System.out.println("'The bat gobbles up a human' AGH MY LEG!");
        energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("'The bat attacks an unsuspecting town' screams");
        energyLevel -= 100;
    }
}