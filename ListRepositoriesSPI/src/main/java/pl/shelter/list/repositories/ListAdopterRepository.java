package pl.shelter.list.repositories;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import model.Adopter;
import pl.shelter.exceptions.AppException;

@ApplicationScoped
@Alternative
@Priority(10)
public class ListAdopterRepository extends ListRepository<Adopter>{
    @Override
    public void edit(Adopter entity) throws AppException {
        getEntities().removeIf((c)->c.equals(entity));
        add(entity);
    }
}
