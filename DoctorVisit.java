//package Assignmet3;

public class DoctorVisit extends TopDecorator {
    public DoctorVisit(OperationInt newOperation) {
        super(newOperation);
    }
    public String getOperation(){ return tempOperation.getOperation() + " doctorvisit"; }
    public int getCost(){
        return tempOperation.getCost()+15;
    }
}
