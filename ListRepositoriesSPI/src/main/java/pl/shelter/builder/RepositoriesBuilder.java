package pl.shelter.builder;

import model.Adopter;
import model.Adoption;
import model.animals.Animal;
import pl.shelter.list.repositories.ListAdopterRepository;
import pl.shelter.list.repositories.ListAdoptionRepository;
import pl.shelter.list.repositories.ListAnimalRepository;
import pl.shelter.repositories.Repository;

public class RepositoriesBuilder {
    private static class SingletonHolder {

        private static final RepositoriesBuilder INSTANCE = new RepositoriesBuilder();
    }

    private RepositoriesBuilder() {
    }

    public static RepositoriesBuilder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Repository<Adopter> buildAdopterRepository() {
        return new ListAdopterRepository();
    }

    public Repository<Adoption> buildAdoptionRepository() {
        return new ListAdoptionRepository();
    }

    public Repository<Animal> buildAnimalRepository() {
        return new ListAnimalRepository();
    }
}
