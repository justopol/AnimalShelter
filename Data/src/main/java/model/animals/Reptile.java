package model.animals;

import model.enums.Bloodness;

public class Reptile extends Animal{
    @Override
    protected Bloodness getBloodness() {
        return Bloodness.COLD;
    }

    @Override
    protected void setAdoptionCost(double adoptionCost) {
        //to do
    }

    @Override
    public double getAdoptionCost() {
        //to do
        return 0;
    }
}
