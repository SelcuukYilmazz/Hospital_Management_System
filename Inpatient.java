//package Assignmet3;

public class Inpatient extends TopDecorator2 {
    public Inpatient(OperationInt newOperation) {
        super(newOperation);
    }
    public String getExamination(){
        return tempOperation.getExamination() + "Inpatient";
    }
    public int getCost(){
        return tempOperation.getCost()+10;
    }
}
