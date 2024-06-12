import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import model.Adopter;
import model.enums.AdopterType;
import org.junit.jupiter.api.Test;
import pl.shelter.exceptions.AdopterException;
import pl.shelter.managers.AdopterManager;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class AdopterManagerIntegrationTest {
    @Inject
    AdopterManager adopterManager;

    @Test
    public void addAdopter() throws AdopterException {
        //given adopter does not exist
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jake", "Lane",
                null, AdopterType.STANDARD);
        //when and then
        assertDoesNotThrow(() -> adopterManager.addAdopter(adopter));
    }

    @Test
    public void addAdopterExits() throws AdopterException {
        //given adopter does not exist
        UUID uuid = UUID.randomUUID();
        Adopter adopter1 = new Adopter(uuid, "Jake", "Lane",
                null, AdopterType.STANDARD);
        Adopter adopter2 = new Adopter(uuid, "Jake", "Lane",
                null, AdopterType.STANDARD);

        assertDoesNotThrow(() -> adopterManager.addAdopter(adopter1));
        //when
        AdopterException adopterException = assertThrows(AdopterException.class, () -> adopterManager.addAdopter(adopter2));

        //then
        assertEquals(AdopterException.ADOPTER_EXISTS,adopterException.getMessage());
    }
}
