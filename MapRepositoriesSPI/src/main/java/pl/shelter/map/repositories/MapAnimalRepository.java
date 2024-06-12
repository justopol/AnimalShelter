package pl.shelter.map.repositories;

import model.animals.Animal;
import pl.shelter.exceptions.AppException;

public class MapAnimalRepository extends MapRepository<Animal> {
    @Override
    public void edit(Animal ani) throws AppException {
        getEntities().removeIf((a)->a.equals(ani));
        add(ani);

    }
}
