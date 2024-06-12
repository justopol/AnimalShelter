package model.animals;

import model.AbstractEntity;
import model.Adoption;
import model.enums.AdoptionStatus;
import model.enums.Bloodness;

import java.util.UUID;

public abstract class Animal extends AbstractEntity {
    private boolean isAvailable;
    private double basicPrice = 20;


    private Adoption currentAdoption;

    public Animal() {
        super(UUID.randomUUID());
    }

    protected abstract Bloodness getBloodness();


    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public double getBloodnessMultiplier() {
        return switch (getBloodness()) {
            case WARM -> 1;
            case COLD -> 2;
        };
    }

    public double getAdoptionPrice() {
        return basicPrice * getBloodnessMultiplier();
    }


    public void addAdoption(Adoption adoption) {
        this.currentAdoption = adoption;
    }

    public void removeAdoption() {
        this.currentAdoption = null;
    }

    public Adoption getCurrentAdoption() {
        return currentAdoption;
    }

}
