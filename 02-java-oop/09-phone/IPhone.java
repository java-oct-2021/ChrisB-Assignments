public class IPhone extends Phone implements Ringable {
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getRingTone();

    }
    @Override
    public String unlock() {
        return "Unlocking via facial recognition";
    }
    @Override
    public void displayInfo() {
        System.out.println("IPhone operating on: " + this.getVersionNumber());
        System.out.println("Battery Percentage: " + this.getBatteryPercentage());
        System.out.println("Iphone from " + this.getCarrier());
        System.out.println("Check out this ringtone: " + this.getRingTone());        
    }
}


