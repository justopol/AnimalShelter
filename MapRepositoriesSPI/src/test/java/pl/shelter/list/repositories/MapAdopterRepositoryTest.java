package pl.shelter.list.repositories;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import model.Adopter;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class MapAdopterRepositoryTest {
    @Inject
    Repository<Adopter> repository;

    @Inject
    Logger logger;

    @Test
    public void add() throws AdopterException {
        //to do null dla address
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jake", "Lane",
                null, AdopterTypeFactory.getStandardAdopterType());
        assertDoesNotThrow(() -> repository.add(adopter));
        logger.info("Liczba elementów repozytorium " + repository.getAll().size());
    }

    @Test
    @DisplayName("adopter exists in repository")
    public void addAlreadyExists() throws AdopterException {
        //to do null dla address
        UUID uuid = UUID.randomUUID();
        Adopter adopter = new Adopter(uuid, "Jake", "Lane",
                null, AdopterTypeFactory.getStandardAdopterType());
        assertDoesNotThrow(() -> repository.add(adopter));
        AppException appException = assertThrows(AppException.class, () -> repository.add(adopter));
        assertEquals(AppException.ENTITY_EXISTS, appException.getMessage());
        logger.info("Liczba elementów repozytorium " + repository.getAll().size());
    }

    @Test
    @DisplayName("different instance already exists in repository")
    public void addAlreadyExistsDifferentInstance() throws AdopterException {
        //to do null dla address
        UUID uuid = UUID.randomUUID();
        Adopter adopter1 = new Adopter(uuid, "Jake", "Lane",
                null, AdopterTypeFactory.getStandardAdopterType());
        Adopter adopter2 = new Adopter(uuid, "Jake", "Lane",
                null, AdopterTypeFactory.getStandardAdopterType());
        assertDoesNotThrow(() -> repository.add(adopter1));
        AppException appException = assertThrows(AppException.class, () -> repository.add(adopter2));
        assertEquals(AppException.ENTITY_EXISTS, appException.getMessage());
        logger.info("Liczba elementów repozytorium " + repository.getAll().size());
    }
}