package model.adopter;

public class StandardAdopterType extends AdopterType{
    @Override
    public double getAdoptionDiscount() {
        return 0;
    }

    @Override
    public boolean isBaned() {
        return false;
    }
}
