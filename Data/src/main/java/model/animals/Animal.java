package model.animals;

import model.AbstractEntity;
import model.Adoption;
import model.enums.AdoptionStatus;
import model.enums.Bloodness;

import java.util.UUID;

public abstract class Animal extends AbstractEntity {
    private boolean available;
    private double basicPrice = 20;


    protected AdoptionStatus adoptionStatus = AdoptionStatus.FOR_ADOPTION;


    private Adoption currentAdoption;

    public Animal() {
        super(UUID.randomUUID());
    }

    protected abstract Bloodness getBloodness();

    public abstract boolean isReadyForAdoption();
    public AdoptionStatus getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
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
