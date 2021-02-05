//package Assignmet3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Input {
    public static String[] words;
    ClientDAOImplement clientdaoimplement = new ClientDAOImplement();

//    We read all files in here

    public String[] readFile(String path) {
        try {
            int i = 0;
            int length = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[length];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    We read input file in here

    public void reader(String file) throws IOException {
        String[] lines = readFile(file);
        for (String line : lines) {
            words = line.split(" ");
            Pattern pattern = Pattern.compile(" ");
            words = pattern.split(line);
            OperationInt operationInt = new Operation();
            if(words.length>0){
            switch (words[0]){
                case "AddPatient":
                    ArrayList<String> address = new ArrayList<>();
                    for(int i = 5;i<words.length;i++){
                        address.add(words[i]);
                     }
                    clientdaoimplement.create(Integer.parseInt(words[1]),words[3],words[2],String.join(" ", address),words[4]);

                    break;
                case "RemovePatient":
                    clientdaoimplement.delete(words[1]);
                    break;
                case "CreateAdmission":
                    clientdaoimplement.createAdmission(Integer.parseInt(words[1]),words[2]);
                    break;
                case "AddExamination":
                    if(words[2].equals("Inpatient")){
                        operationInt = new Inpatient(operationInt);
                    }
                    if(words[2].equals("Outpatient")){
                        operationInt = new Outpatient(operationInt);
                    }

                    ArrayList<String> operations = new ArrayList<>();
                    for(int i=3;i<words.length;i++){
                        if (words[i].equals("measurements")){
                           operationInt = new Measurement(operationInt);
                        }
                        if (words[i].equals("doctorvisit")){
                            operationInt = new DoctorVisit(operationInt);
                        }
                        if (words[i].equals("imaging")){
                            operationInt = new Imaging(operationInt);
                        }
                        if ( words[i].equals("tests")){
                            operationInt = new Tests(operationInt);
                        }
                    }
                    for(int i=2;i<words.length;i++){
                        operations.add(words[i]);
                    }
                    clientdaoimplement.addExamination(words[1],words[2],operations,operationInt);
                    break;
                case "TotalCost":
                        clientdaoimplement.totalcost(words[1]);
                        break;
                case "ListPatients":
                    clientdaoimplement.patientlist();
                    break;
            }
            }
        }
        clientdaoimplement.printadmission();
        clientdaoimplement.printclient();

    }

//    We read client file in here

    public void  clientreader(String clientfile) throws IOException {
        String[] lines 	= readFile(clientfile);
        for (String line : lines) {
            words = line.split("\t");
            Pattern pattern = Pattern.compile("\t");
            words = pattern.split(line);
            if(words.length>0){
            clientdaoimplement.readclient(Integer.parseInt(words[0]),words[1].split(" ")[1],words[1].split(" ")[0],words[3].split(":")[1],words[2]);
            }
        }
    }

//  We read admission file in here

    public void admissionreader(String admissionfile) throws IOException {
        String[] lines 	= readFile(admissionfile);
        int admissionnumber = 0;
        for (String line : lines) {
            words = line.split("\t");
            Pattern pattern = Pattern.compile("\t");
            words = pattern.split(line);
            if(words.length>0){
            if(!words[0].equals("Inpatient") && !words[0].equals("Outpatient")){
                 admissionnumber = 0;
                 admissionnumber = admissionnumber + Integer.parseInt(words[0]);
                clientdaoimplement.readadmission(Integer.parseInt(words[0]),words[1]);}

            if(words[0].equals("Inpatient")||words[0].equals("Outpatient")){
                ArrayList<String> operations = new ArrayList<>();
                OperationInt operationInt = new Operation();
                if(words[0].equals("Inpatient")){
                    operationInt = new Inpatient(operationInt);
                }
                if(words[0].equals("Outpatient")){
                    operationInt = new Outpatient(operationInt);
                }
                for(int i=0;i<words[1].split(" ").length;i++){
                    if (words[1].split(" ")[i].equals("measurements")){
                        operationInt = new Measurement(operationInt);
                    }
                    if (words[1].split(" ")[i].equals("doctorvisit")){
                        operationInt = new DoctorVisit(operationInt);
                    }
                    if (words[1].split(" ")[i].equals("imaging")){
                        operationInt = new Imaging(operationInt);
                    }
                    if ( words[1].split(" ")[i].equals("tests")){
                        operationInt = new Tests(operationInt);
                    }
                }
                if(words[0].equals("Inpatient") || words[0].equals("Outpatient")){
                    operations.add(words[0]);
                    for(int i=0;i<words[1].split(" ").length;i++){
                        operations.add(words[1].split(" ")[i]);
                    }
                }
                clientdaoimplement.readexamination(String.valueOf(admissionnumber),words[0],operations,operationInt);
            }
            }
        }
    }
}
