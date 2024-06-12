package model.animals;

import model.enums.DogSize;

public class Dog extends Mammal {
    private DogSize dogSize;

    public Dog(DogSize dogSize) {
        this.dogSize = dogSize;
    }

    public DogSize getDogSize() {
        return dogSize;
    }

    public void setDogSize(DogSize dogSize) {
        this.dogSize = dogSize;
    }

    @Override
    public double getAdoptionCost() {
       return switch (dogSize){
           case SMALL -> 15;
           case MEDIUM -> 20;
           case BIG -> 25;
       };
    }


    @Override
    protected void setAdoptionCost(double adoptionCost) {

    }
}
