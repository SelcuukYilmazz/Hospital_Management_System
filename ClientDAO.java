//package Assignmet3;

import java.io.IOException;
import java.util.ArrayList;

// We made a interface for DAO

public interface ClientDAO {
    public void create(int pId,String pSurname,String pName,String pAddress,String pPhonenumber) throws IOException;
    public void delete(String pId) throws IOException;
    public void patientlist() throws IOException;
    public void createAdmission(int AdmissionId,String pId) throws IOException;
    public void addExamination(String AdmissionId,String examinationtype,ArrayList<String> operations,OperationInt operationInt) throws IOException;
    public void totalcost(String AdmissionId) throws IOException;
    public void readadmission(int AdmissionId,String pId) throws IOException;
    public void readexamination(String AdmissionId,String examinationtype,ArrayList<String> operations,OperationInt operationInt);
    public void readclient(int pId,String pSurname,String Name,String pAddress,String Phonenumber) throws IOException;
    public void printadmission() throws IOException;
    public void printclient() throws IOException;
}
