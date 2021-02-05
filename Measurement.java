//package Assignmet3;

public class Measurement extends TopDecorator {
    public Measurement(OperationInt newOperation) {
        super(newOperation);
    }
    public String getOperation(){
        return tempOperation.getOperation() + " measurements";
    }
    public int getCost(){
        return tempOperation.getCost()+5;
    }
}
