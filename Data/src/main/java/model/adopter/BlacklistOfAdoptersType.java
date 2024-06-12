package model.adopter;

public class BlacklistOfAdoptersType extends AdopterType {

    @Override
    public double getAdoptionDiscount() {
        return 0;
    }

    @Override
    public boolean isBaned() {
        return true;
    }
}
