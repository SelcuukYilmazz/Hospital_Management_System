//package Assignmet3;

public abstract class TopDecorator2 implements OperationInt {
    protected OperationInt tempOperation;
    public TopDecorator2 (OperationInt newOperation) {tempOperation = newOperation;}
    public String getOperation(){
        return tempOperation.getOperation();
    }
    public int getCost(){
        return tempOperation.getCost();
    }
    public String getExamination(){ return tempOperation.getExamination(); }
}
