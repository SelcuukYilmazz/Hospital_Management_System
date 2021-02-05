//package Assignmet3;

public class Outpatient extends TopDecorator2 {
    public Outpatient(OperationInt newOperation) {
        super(newOperation);
    }
    public String getExamination(){
        return tempOperation.getExamination() + "Outpatient";
    }
    public int getCost(){
        return tempOperation.getCost()+15;
    }
}