//package Assignmet3;

public class Imaging extends TopDecorator {
    public Imaging(OperationInt newOperation) {
        super(newOperation);
    }
    public String getOperation(){
        return tempOperation.getOperation() + " imaging";
    }
    public int getCost(){
        return tempOperation.getCost()+10;
    }
}
