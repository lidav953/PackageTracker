public class Package {

    String tracking='';
    String carrier='';

    public Package(String trackingNumber) {
        tracking = trackingNumber;
        carrier = assignCarrier();
    }

    public String getTrackingNumber() {
        return tracking;
    }

    private String assignCarrier() {
        // assign carrier based on rules
        return '';
    }

    public String getCarrier() {
        return carrier;
    }
}
