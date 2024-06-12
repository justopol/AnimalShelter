package pl.shelter.managers;

import model.Address;
import model.Adopter;
import model.adopter.AdopterTypeFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.shelter.exceptions.AppException;
import pl.shelter.repositories.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
class AdopterManagerTest {


    @InjectMocks
    private AdopterManager adopterManager;

    @Mock
    private Repository<Adopter> adopterRepository;
    @Captor
    ArgumentCaptor<Adopter> adopterCaptor;

    @Test
    void testAddAdopter_BDD() throws AppException {
        //given
        Address address = new Address("Lane", "123", "Lodz");
        Adopter adopter = new Adopter(UUID.randomUUID(), "Jack", "Lake", address, AdopterTypeFactory.getStandardAdopterType());
        given(adopterRepository.findBy((Predicate<Adopter>) any())).willReturn(Collections.emptyList());
        given(adopterRepository.getAll()).willReturn(List.of(adopter));
        //when
        assertDoesNotThrow(() -> adopterManager.addAdopter(adopter));
        List<Adopter> allAdopters = adopterManager.getAll();
        //then
        then(adopterRepository).should(times(1)).add(any());
        then(adopterRepository).should(times(1)).findBy((Predicate<Adopter>) any());
        then(adopterRepository).should(times(1)).getAll();
        then(adopterRepository).shouldHaveNoMoreInteractions();
        assertThat(allAdopters.size(), is(1));
        assertThat(allAdopters, hasSize(1));
    }

}