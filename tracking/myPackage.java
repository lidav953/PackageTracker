package tracking;

public class myPackage {

    String trackingNo;
    String carrier;
    String[] FedExFormats = new String[]{"^[0-9]{20}$","^[0-9]{15}$","^[0-9]{12}$","^[0-9]{22}$"};
    String[] UPSFormats = new String[]{"^(1Z)[0-9A-Z]{16}$","^(T)+[0-9A-Z]{10}$","^[0-9]{9}$","^[0-9]{26}$"};
    String[] USPSFormats = new String[]{"^(94|93|92|94|95)[0-9]{20}$","^(94|93|92|94|95)[0-9]{22}$","^(70|14|23|03)[0-9]{14}$",
                                        "^(M0|82)[0-9]{8}$","^([A-Z]{2})[0-9]{9}([A-Z]{2})$"};

    public myPackage(String trackingNumber) {
        trackingNo = trackingNumber;
        carrier = assignCarrier();
    }

    public String getTrackingNumber() {
        return trackingNo;
    }

    private String assignCarrier() {
        // assign carrier based on rules
        if(_isUSPS()) {
            return "USPS";
        } else if(_isUPS()) {
            return "UPS";
        } else if(_isFedEx()) {
            return "FedEx";
        }
        return "N/A";
    }

    private boolean _isFedEx() {
        // check if package is from FedEx
        for(String format:FedExFormats) {
            if(trackingNo.matches(format)) {
                return true;
            }
        }
        return false;
    }

    private boolean _isUPS() {
        // check if package is from UPS
        for(String format:UPSFormats) {
            if(trackingNo.matches(format)) {
                return true;
            }
        }
        return false;
    }

    private boolean _isUSPS() {
        // check if package is from USPS
        for(String format:USPSFormats) {
            if(trackingNo.matches(format)) {
                return true;
            }
        }
        return false;
    }

    public String getCarrier() {
        return carrier;
    }
}
