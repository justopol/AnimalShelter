package pl.shelter.list.repositories;

import model.animals.Animal;
import pl.shelter.exceptions.AppException;

public class ListAnimalRepository extends ListRepository<Animal>{
    @Override
    public void edit(Animal ani) throws AppException {
        getEntities().removeIf((a)->a.equals(ani));
        add(ani);

    }
}
