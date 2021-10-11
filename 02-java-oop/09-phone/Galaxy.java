public class Galaxy extends Phone implements Ringable {
    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        return this.getRingTone();
    }
    @Override
    public String unlock() {
        return "Unlocking via fingerprint scanner";
    }
    @Override
    public void displayInfo() {
        System.out.println("Galaxy operating on version: " + this.getVersionNumber());
        System.out.println("Battery Percentage: " + this.getBatteryPercentage());
        System.out.println("Galaxy from " + this.getCarrier());
        System.out.println("Check out this ringtone: " + this.getRingTone());
    }
}

