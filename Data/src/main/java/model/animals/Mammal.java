package model.animals;

import model.enums.Bloodness;

public class Mammal extends Animal{

    private boolean castration;

    protected boolean isCastration() {
        return castration;
    }

    protected void setCastration(boolean castration) {
        this.castration = castration;
    }

    @Override
    protected Bloodness getBloodness() {
        return Bloodness.WARM;
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
