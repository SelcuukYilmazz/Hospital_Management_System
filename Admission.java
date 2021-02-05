//package Assignmet3;

import java.util.ArrayList;

//We keep each patients admission information in this class

public class Admission {
   int AdmissionId;
    String pId;
    ArrayList<ArrayList<String>> operations;
    int totalcost;

    public Admission(int admissionId, String pId, int totalcost) {
        AdmissionId = admissionId;
        this.pId = pId;
        this.totalcost = totalcost;
    }

    public ArrayList<ArrayList<String>> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<ArrayList<String>> operations) {
        this.operations = operations;
    }

    public int getAdmissionId() {
        return AdmissionId;
    }

    public void setAdmissionId(int admissionId) {
        AdmissionId = admissionId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public int getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(int totalcost) {
        this.totalcost = totalcost;
    }
}