package pl.shelter.managers;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import model.Adopter;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.util.List;

@Dependent
public class AdopterManager {
    private final Repository<Adopter> adopterRepository;

    @Inject
    public AdopterManager(Repository<Adopter> adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public void addAdopter(Adopter adopter) throws AppException {
        List<Adopter> findBy = adopterRepository.findBy(c -> c.getUuid().equals(adopter.getUuid()));
        if (!findBy.isEmpty()) {
            throw new AdopterException(AdopterException.ADOPTER_EXISTS);
        }
        adopterRepository.add(adopter);
    }

    public List<Adopter> getAll() {
        return adopterRepository.getAll();
    }
}
