package pl.shelter.list.repositories;

import model.Adoption;
import pl.shelter.exceptions.AppException;

import java.util.List;

public class ListAdoptionRepository extends ListRepository<Adoption> {
    @Override
    public void edit(Adoption adoption) throws AppException {
        List<Adoption> find = findBy((f) -> adoption.equals(f));
        getEntities().removeAll(find);
        add(adoption);

    }
}
