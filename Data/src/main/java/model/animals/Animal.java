package model.animals;

import model.AbstractEntity;
import model.Adoption;
import model.enums.Bloodness;

import java.util.UUID;

public abstract class Animal extends AbstractEntity {

    private Bloodness bloodness;
    private double adoptionCost;



    private Adoption currentAdoption;

    public Animal() {
        super(UUID.randomUUID());
    }

    protected abstract Bloodness getBloodness();
    protected abstract void setAdoptionCost(double adoptionCost);
    public double getBloodnessMultiplier(){
        return switch (getBloodness()){
            case WARM -> 1;
            case COLD -> 2;
        };
    }

    public abstract double getAdoptionCost();

    public void addAdoption(Adoption adoption){
        this.currentAdoption = adoption;
    }
    public void removeAdoption (){
        this.currentAdoption = null;
    }

    public Adoption getCurrentAdoption() {
        return currentAdoption;
    }

}
