//package Assignmet3;

public class Tests extends TopDecorator {
    public Tests(OperationInt newOperation) {
        super(newOperation);
    }
    public String getOperation(){
        return tempOperation.getOperation() + " tests";
    }
    public int getCost(){ return tempOperation.getCost()+7; }
}
