package model.animals;

import model.enums.AdoptionStatus;
import model.enums.Bloodness;

public class Mammal extends Animal {

    private boolean castrated;

    public boolean isCastrated() {
        return castrated;
    }

    public void setCastrated(boolean castrated) {
        this.castrated = castrated;
    }

    @Override
    protected Bloodness getBloodness() {
        return Bloodness.WARM;
    }

    @Override
    public boolean isReadyForAdoption() {
        if (castrated && adoptionStatus.equals(AdoptionStatus.FOR_ADOPTION)) {
            return false;
        }
            return true;
    }


}
