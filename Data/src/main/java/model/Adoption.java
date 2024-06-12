package model;

import model.animals.Animal;
import model.enums.AdoptionStatus;
import pl.shelter.exceptions.AdoptionException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.PrimitiveIterator;
import java.util.UUID;

public class Adoption extends AbstractEntity{
    private UUID uuid;
    private LocalDate startAdoptionTime;
    private LocalDate endAdoptionTime;

    private AdoptionStatus adoptionStatus;
    private Adopter adopter;
    private Animal animal;
    private double finalAdoptionCost;

    public Adoption() {
        super(UUID.randomUUID());
        this.adoptionStatus = AdoptionStatus.FOR_ADOPTION;
    }

    public void createAdoption(LocalDate startAdoptionTime, Adopter adopter, Animal animal) throws AdoptionException {
        this.startAdoptionTime = startAdoptionTime;
        this.adopter = adopter;
        if (animal.getCurrentAdoption() != null) {
            throw new AdoptionException(AdoptionException.ANIMAL_ADOPTED);
        }
        this.animal = animal;
        animal.addAdoption(this);
        this.adoptionStatus = AdoptionStatus.UNDER_ADOPTION;
        this.finalAdoptionCost = animal.getAdoptionCost() * (1 - adopter.getDiscount()) * animal.getBloodnessMultiplier();
    }
    public void finishAdoption(LocalDate endAdoptionTime) throws AdoptionException {
        this.adoptionStatus = AdoptionStatus.ADOPTED;
        if (animal ==null){
            throw new AdoptionException(AdoptionException.ANIMAL_NOT_EXISTS);
        }
        animal.removeAdoption();
        if (endAdoptionTime.isBefore(startAdoptionTime)){
            throw new AdoptionException(AdoptionException.TIME_EXCEPTION);
        }
        this.endAdoptionTime = endAdoptionTime;
    }
    public long calculateDays() throws AdoptionException {
        if (endAdoptionTime.isBefore(startAdoptionTime)){
            throw new AdoptionException(AdoptionException.TIME_EXCEPTION);
        }
        return ChronoUnit.DAYS.between(startAdoptionTime,endAdoptionTime);
    }

    public Adopter getAdopter() {
        return adopter;
    }

    public Animal getAnimal() {
        return animal;
    }

    public double getFinalAdoptionCost() {
        return finalAdoptionCost;
    }

}
