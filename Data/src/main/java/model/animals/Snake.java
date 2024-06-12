package model.animals;

public class Snake extends Reptile{
    @Override
    public double getAdoptionCost() {
        return 20;
    }

    @Override
    protected void setAdoptionCost(double adoptionCost) {

    }
}
