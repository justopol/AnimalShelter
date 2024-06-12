package pl.shelter.managers;

import model.Adopter;
import model.Adoption;
import model.animals.Animal;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.exceptions.AdoptionException;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AdoptionManager {
    private final Repository<Adoption> adoptions;

    public AdoptionManager(Repository<Adoption> adoptions) {
        this.adoptions = adoptions;
    }

    public void createAdoption(Animal animal, Adopter adopter) throws AppException {
        if (adopter.getAdopterType().isBaned()) {
            throw new AdoptionException(AdopterException.BLACKLIST_ADOPTER);
        }
        if (isAnimalAdopted(animal)) {
            throw new AdoptionException(AdoptionException.ANIMAL_ADOPTED);
        }
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now(), adopter, animal);
        adoptions.add(adoption);
    }

    public Optional<Adopter> getAdopterForAnimal(final Animal animal) {

        List<Adoption> listOfAdoptions = findByAnimal(adoptions, animal);

        if (listOfAdoptions.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(listOfAdoptions.get(0).getAdopter());
    }

    private List<Adoption> findByAnimal(Repository<Adoption> repository, Animal animal) {
        List<Adoption> listOfAdoption = repository.findBy((adoption) -> adoption.getAnimal().equals(animal));
        return listOfAdoption;
    }


    private boolean isAnimalAdopted(Animal animal) {
        List<Adoption> listOfAdoption = findByAnimal(adoptions, animal);
        return !listOfAdoption.isEmpty();
    }
}
