package model.adopter;

public class PreviouslyAdopterType extends AdopterType{
    @Override
    public double getAdoptionDiscount() {
        return 0.5;
    }

    @Override
    public boolean isBaned() {
        return false;
    }
}
