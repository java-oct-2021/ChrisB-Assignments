public class PhoneTester {
    public static void main(String[] args) {
        Galaxy S9 = new Galaxy("S9", 78,"Verizon","24Karat");
        IPhone iphoneTen = new IPhone ("ios 10", 100, "AT&T", "Back in Black");

        S9.displayInfo();
        System.out.println(S9.ring());
        System.out.println(S9.unlock());

        iphoneTen.displayInfo();
        System.out.println(iphoneTen.ring());
        System.out.println(iphoneTen.unlock());
    }
}
