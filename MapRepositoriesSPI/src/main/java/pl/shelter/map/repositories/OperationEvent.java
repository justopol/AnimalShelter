package pl.shelter.map.repositories;

public class OperationEvent {
    private String operation;
    public OperationEvent(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
