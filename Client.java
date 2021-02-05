//package Assignmet3;



//We keep all patients informations in here

public class Client {
    int pId;
    String pSurname;
    String pName;
    String pAddress;
    String pPhonenumber;

    public Client(int pId, String pSurname, String pName, String pAddress, String pPhonenumber) {
        this.pId = pId;
        this.pSurname = pSurname;
        this.pName = pName;
        this.pAddress = pAddress;
        this.pPhonenumber = pPhonenumber;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpSurname() {
        return pSurname;
    }

    public void setpSurname(String pSurname) {
        this.pSurname = pSurname;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public String getpPhonenumber() {
        return pPhonenumber;
    }

    public void setpPhonenumber(String pPhonenumber) {
        this.pPhonenumber = pPhonenumber;
    }
}
