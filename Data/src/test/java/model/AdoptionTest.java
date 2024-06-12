package model;

import model.adopter.AdopterTypeFactory;
import model.animals.Animal;
import model.animals.Dog;
import model.animals.Snake;
import model.enums.AdoptionStatus;
import model.enums.DogSize;
import pl.shelter.exceptions.AdopterException;
import org.junit.jupiter.api.Test;
import pl.shelter.exceptions.AdoptionException;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class AdoptionTest {
    @Test
    public void adoptionTestWhenAdopterTypeIsStandard() throws AdopterException, AdoptionException {
        Animal animal = new Dog(DogSize.BIG);
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getStandardAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal);
        System.out.println(adoption.getFinalAdoptionCost());
        assertEquals(25, adoption.getFinalAdoptionCost());
    }

    @Test
    public void adoptionTestWhenAdopterTypeIsPrevously() throws AdopterException, AdoptionException {
        Animal animal = new Dog(DogSize.BIG);
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getPrevouslyAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal);
        System.out.println(adoption.getFinalAdoptionCost());
        assertEquals(12.5, adoption.getFinalAdoptionCost());
    }

    @Test
    public void adoptionTestWhenAdopterIsBlacklisted() throws AdopterException {
        Animal animal = new Dog(DogSize.BIG);
        Address address = new Address("Lane", "123", "Lodz");
        assertThrows(AdopterException.class, () -> new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getBlacklistOfAdoptersType()));

    }

    @Test
    public void adoptionTestWhenAdopterTypeIsStandardWithReptile() throws AdopterException, AdoptionException {
        Animal animal = new Snake();
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getStandardAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal);
        assertEquals(40, adoption.getFinalAdoptionCost());
    }

    @Test
    public void adoptionTestWhenAnimalIsAlreadyAdopted() throws AdopterException, AdoptionException {
        Animal animal = new Dog(DogSize.BIG);
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getPrevouslyAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal);
        assertThrows(AdoptionException.class, () -> adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal));

    }

    @Test
    public void finishAdoptionWhenAnimalNotNull() throws AdopterException, AdoptionException {
        Animal animal = new Snake();
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getStandardAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().minusDays(10), adopter, animal);
        adoption.finishAdoption(LocalDate.now().plusDays(7));
        assertNull(animal.getCurrentAdoption());
        assertEquals(17, adoption.calculateDays());

    }

    @Test
    public void finishAdoptionWhenAnimalIsNull() throws AdopterException, AdoptionException {
        Animal animal = new Snake();
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getStandardAdopterType());
        Adoption adoption = new Adoption();
        assertThrows(AdoptionException.class, () -> adoption.finishAdoption(LocalDate.now().plusDays(7)));
    }
    @Test
    public void endDAteBeforeStartDate() throws AdopterException, AdoptionException {
        Animal animal = new Snake();
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jason", "Clark", address, AdopterTypeFactory.getStandardAdopterType());
        Adoption adoption = new Adoption();
        adoption.createAdoption(LocalDate.now().plusDays(1), adopter, animal);
        assertThrows(AdoptionException.class, () -> adoption.finishAdoption(LocalDate.now().minusDays(6)));
    }
    @Test
    public void test(){
        Locale.setDefault(Locale.of("en"));
        System.out.println(AdopterException.BLACKLIST_ADOPTER);
    }


}