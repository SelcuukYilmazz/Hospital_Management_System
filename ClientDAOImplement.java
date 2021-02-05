//package Assignmet3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//  We fill all the methods from the interface in here


public class ClientDAOImplement implements ClientDAO {
    ArrayList<Client> clients = new ArrayList<Client>();
    ArrayList<Admission> admissions = new ArrayList<Admission>();
    Output output = new Output();
    public static String[] words;

//    We add patient informations from inputs in here
    @Override
    public void create(int pId, String pSurname, String pName, String pAddress, String pPhonenumber) throws IOException {
        clients.add(new Client(pId,pSurname,pName,pAddress,pPhonenumber));
        output.hospitaloutput("Patient "+ pId +" "+pName+" added");
    }
//    We delete patient informations in here

    @Override
    public void delete(String pId) throws IOException {
        int delclient=-1;
        int deladmission=-1;
        for(Client client: clients){
            if(String.valueOf(client.getpId()).equals(pId)){
               output.hospitaloutput("Patient "+pId+" "+client.getpName()+" removed");
                delclient = clients.indexOf(client);
                break;
            }
        }
        for(Admission admission: admissions){
            if(admission.getpId().equals(pId)){
                deladmission = admissions.indexOf(admission);
            }
        }
        if(delclient!=-1){
            clients.remove(delclient);
        }
        if(deladmission!=-1){
            admissions.remove(deladmission);
        }
    }

//    We print patientlist in here

    @Override
    public void patientlist() throws IOException {
       output.hospitaloutput("Patient List:");
        Collections.sort(clients, Comparator.comparing(Client::getpName));
        for(Client client: clients){
            output.hospitaloutput(client.getpId()+" "+client.getpName()+" "+
                    client.getpSurname()+" "+client.getpPhonenumber()+" Address: "+client.getpAddress());
        }
    }

//    We create admissions for patients in here

    @Override
    public void createAdmission(int AdmissionId, String pId) throws IOException {
        admissions.add(new Admission(AdmissionId,pId,0));
        output.hospitaloutput("Admission "+AdmissionId+" created");
    }

//    We add examinations for the admissions in here

    @Override
    public void addExamination(String AdmissionId,String examinationtype,ArrayList<String> operations,OperationInt operationInt) throws IOException {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for(Admission admission: admissions){
            if(String.valueOf(admission.getAdmissionId()).equals(AdmissionId)){
                if(admission.getOperations() != null && !admission.getOperations().isEmpty()){
                    for(int i = 0;i<admission.getOperations().size();i++){
                        list.add(admission.getOperations().get(i));
                    }
                }
                list.add(operations);
                admission.setOperations(list);

                output.hospitaloutput(examinationtype+" examination added to admission "+AdmissionId);
            }
        }
    }

    //    We calculate all the costs in here with Decorator Pattern

    @Override
    public void totalcost(String AdmissionId) throws IOException {
        for(Admission admission: admissions){
            if(String.valueOf(admission.getAdmissionId()).equals(AdmissionId)){
                output.hospitaloutput("TotalCost for admission "+admission.getAdmissionId());
                for(int i = 0 ;i<admission.getOperations().size();i++){
                    OperationInt operationInt = new Operation();
                    if(admission.getOperations().get(i).get(0).equals("Inpatient")){
                    operationInt = new Inpatient(operationInt);
                    }
                    if(admission.getOperations().get(i).get(0).equals("Outpatient")){
                    operationInt = new Outpatient(operationInt);
                    }
                    for(int k=1;k<admission.getOperations().get(i).size();k++){
                        if (admission.getOperations().get(i).get(k).equals("measurements")){
                            operationInt = new Measurement(operationInt);
                        }
                        if (admission.getOperations().get(i).get(k).equals("doctorvisit")){
                            operationInt = new DoctorVisit(operationInt);
                        }
                        if (admission.getOperations().get(i).get(k).equals("imaging")){
                            operationInt = new Imaging(operationInt);
                        }
                        if ( admission.getOperations().get(i).get(k).equals("tests")) {
                            operationInt = new Tests(operationInt);
                        }
                    }
                    output.hospitaloutput("\t"+operationInt.getExamination()+operationInt.getOperation()+" "+operationInt.getCost()+"$");
                    admission.setTotalcost(admission.getTotalcost()+operationInt.getCost());
                }
                output.hospitaloutput("\tTotal: "+admission.getTotalcost()+"$");
                admission.setTotalcost(0);
            }
        }
    }


//    We read and save all the admission informations in here

    @Override
    public void readadmission(int AdmissionId,String pId)  {
        admissions.add(new Admission(AdmissionId,pId,0));
    }

//    We read and save all the examination informations for the admissions in here

    @Override
    public void readexamination(String AdmissionId, String examinationtype, ArrayList<String> operations, OperationInt operationInt) {
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for(Admission admission: admissions){
            if(String.valueOf(admission.getAdmissionId()).equals(AdmissionId)){
                if(admission.getOperations() != null && !admission.getOperations().isEmpty()){
                    for(int i = 0;i<admission.getOperations().size();i++){
                        list.add(admission.getOperations().get(i));
                    }
                }
                list.add(operations);
                admission.setOperations(list);
            }
        }
    }

//  We read and save all the client information in here

    @Override
    public void readclient(int pId, String pSurname, String pName, String pAddress, String pPhonenumber) throws IOException {
        clients.add(new Client(pId,pSurname,pName,pAddress,pPhonenumber));

    }

//    We make a admission output file in here

    @Override
    public void printadmission() throws IOException {
        Collections.sort(admissions, Comparator.comparing(Admission::getAdmissionId));
        for(Admission admission: admissions){
            output.admissionwrite(admission);
        }

    }

//    We make client output file in here

    @Override
    public void printclient() throws IOException {
        Collections.sort(clients, Comparator.comparing(Client:: getpId));
        for(Client client: clients){
            output.clientwrite(client);
        }
    }
}

