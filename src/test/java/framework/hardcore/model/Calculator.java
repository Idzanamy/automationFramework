package framework.hardcore.model;

public class Calculator {

    private String number;
    private String region;
    private String classVM;
    private String totalPrice;
    private String emailTotalPrice;
    private String timeUsage;
    private String typeIns;
    private String localSSD;

    public Calculator(String number, String region, String classVM, String totalPrice, String emailTotalPrice, String timeUsage, String typeIns, String localSSD) {
        this.number = number;
        this.region = region;
        this.classVM = classVM;
        this.totalPrice = totalPrice;
        this.emailTotalPrice = emailTotalPrice;
        this.timeUsage = timeUsage;
        this.typeIns = typeIns;
        this.localSSD = localSSD;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getClassVM() {
        return classVM;
    }

    public void setClassVM(String classVM) {
        this.classVM = classVM;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getEmailTotalPrice() {
        return emailTotalPrice;
    }

    public void setEmailTotalPrice(String emailTotalPrice) {
        this.emailTotalPrice = emailTotalPrice;
    }

    public String getTimeUsage() {
        return timeUsage;
    }

    public void setTimeUsage(String timeUsage) {
        this.timeUsage = timeUsage;
    }

    public String getTypeIns() {
        return typeIns;
    }

    public void setTypeIns(String typeIns) {
        this.typeIns = typeIns;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }
}
