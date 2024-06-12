package model.adopter;

public abstract class AdopterType{
    private boolean isBaned;
    private double adoptionDiscount;

    public abstract double getAdoptionDiscount();

    public abstract boolean isBaned();

}
