package model.animals;

import model.enums.Bloodness;

public abstract class Mammal extends Animal{

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


}
