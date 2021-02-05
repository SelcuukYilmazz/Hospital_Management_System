//package Assignmet3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Output {

//    We write all the client information in here

    public void clientwrite(Client client) throws IOException {
        FileWriter fileWriter = new FileWriter("patient.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(client.getpId()+"\t"+client.getpName()+" "+client.getpSurname()+"\t"+client.getpPhonenumber()+"\t"+"Address:"+client.getpAddress());
        printWriter.close();
    }

//    We write all the admission information in here

    public void admissionwrite(Admission admission) throws IOException {
        FileWriter fileWriter = new FileWriter("admission.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(admission.getAdmissionId()+"\t"+admission.getpId()+"\n");
        if(admission.getOperations() != null && !admission.getOperations().isEmpty()){
            for (int i = 0;i<admission.getOperations().size();i++){
                OperationInt operationInt = new Operation();
                if (admission.getOperations().get(i).get(0).equals("Inpatient")){
                    operationInt = new Inpatient(operationInt);
                }
                if (admission.getOperations().get(i).get(0).equals("Outpatient")){
                    operationInt = new Outpatient(operationInt);
                }
                for(int k =1;k<admission.getOperations().get(i).size();k++){
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
                printWriter.print(operationInt.getExamination()+"\t"+operationInt.getOperation()+"\n");
            }

                }
        printWriter.close();
    }

//  We are resetting client file in here

    public void clientreset() throws IOException {
        FileWriter fileWriter = new FileWriter("patient.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.close();

    }

//    We are resetting admission file in here

    public void admissionreset() throws IOException {
        FileWriter fileWriter = new FileWriter("admission.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.close();
    }

//    We are resetting our original output here

    public void hospitaloutputreset() throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.close();
    }

//    We are writing our original output here

    public void hospitaloutput(String out) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt", true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(out);
        printWriter.close();
    }
}

