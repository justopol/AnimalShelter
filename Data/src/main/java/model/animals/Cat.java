package model.animals;

public class Cat extends Mammal{
    @Override
    public double getAdoptionCost() {
        return 10;
    }

    @Override
    protected void setAdoptionCost(double adoptionCost) {

    }
}
