package model;

import model.enums.AdopterType;
import pl.shelter.exceptions.AdopterException;

import java.util.UUID;

public class Adopter extends User {

    private AdopterType adopterType;


    public Adopter(UUID uuid, String firstName, String lastName, Address address, AdopterType adopterType) throws AdopterException {
        super(uuid,firstName,lastName,address);
        if (AdopterType.BLACKLISTED.equals(adopterType)) {
            throw new AdopterException(AdopterException.BLACKLIST_ADOPTER);
        }
        this.adopterType = adopterType;
    }

    public AdopterType getAdopterType() {
        return adopterType;
    }

    public double getDiscount() {
        return switch (adopterType) {
            case STANDARD, BLACKLISTED -> 0.0;
            case PREVIOUS_ADOPTER -> 0.5;
        };

    }

}
