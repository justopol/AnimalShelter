package model.animals;

import model.enums.Bloodness;

public abstract class Reptile extends Animal{
    @Override
    protected Bloodness getBloodness() {
        return Bloodness.COLD;
    }
}
