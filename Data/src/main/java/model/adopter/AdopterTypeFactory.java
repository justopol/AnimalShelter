package model.adopter;

public class AdopterTypeFactory {
    private AdopterTypeFactory() {
    }

    private static final AdopterType standardAdopterType = new StandardAdopterType();
    private static final AdopterType prevouslyAdopterType = new PreviouslyAdopterType();
    private static final AdopterType blacklistOfAdoptersType = new BlacklistOfAdoptersType();
    public static AdopterType getStandardAdopterType(){return standardAdopterType;}
    public static AdopterType getPrevouslyAdopterType(){return prevouslyAdopterType;}
    public static AdopterType getBlacklistOfAdoptersType(){return blacklistOfAdoptersType;}
}
