package model.animals;

import model.enums.Bloodness;

public class Reptile extends Animal{
    @Override
    protected Bloodness getBloodness() {
        return Bloodness.COLD;
    }

}
