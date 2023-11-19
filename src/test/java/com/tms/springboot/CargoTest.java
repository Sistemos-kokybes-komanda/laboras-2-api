package com.tms.springboot;

import com.tms.springboot.model.Cargo;
import com.tms.springboot.repository.CargoRepository;
import com.tms.springboot.service.CargoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CargoTest {

    @Mock
    private CargoRepository cargoRepository;

    @InjectMocks
    private CargoService cargoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCargo() {
        Cargo cargo = new Cargo();
        when(cargoRepository.save(any(Cargo.class))).thenReturn(cargo);

        Cargo result = cargoService.createCargo(cargo);

        verify(cargoRepository, times(1)).save(cargo);
        assertNotNull(result);
        // Add more assertions based on your requirements
    }

    @Test
    void testViewAllCargo() {
        Cargo cargo1 = new Cargo();
        Cargo cargo2 = new Cargo();
        when(cargoRepository.findAll()).thenReturn(Arrays.asList(cargo1, cargo2));

        Iterable<Cargo> result = cargoService.viewAllCargo();

        assertNotNull(result);
        assertTrue(result.iterator().hasNext());
        // Add more assertions based on your requirements
    }

    @Test
    void testDeleteCargo() {
        int cargoId = 1;

        when(cargoRepository.findById(cargoId)).thenReturn(Optional.of(new Cargo()));

        cargoService.deleteCargo(cargoId);

        verify(cargoRepository, times(1)).deleteById(cargoId);
        // Add more assertions based on your requirements
    }

    @Test
    void testUpdateCargo() {
        Cargo cargo = new Cargo();
        when(cargoRepository.findById(anyInt())).thenReturn(Optional.of(cargo));
        when(cargoRepository.save(any(Cargo.class))).thenReturn(cargo);

        Cargo result = cargoService.updateCargo(cargo);

        verify(cargoRepository, times(1)).findById(anyInt());
        verify(cargoRepository, times(1)).save(cargo);
        assertNotNull(result);
        // Add more assertions based on your requirements
    }

    @Test
    void testUpdateNonexistentCargo() {
        Cargo cargo = new Cargo();

        when(cargoRepository.findById(anyInt())).thenReturn(Optional.empty());

        Cargo result = cargoService.updateCargo(cargo);

        assertNull(result);
        // Add more assertions based on your requirements
    }

    @Test
    void testGetCargoById() {
        int cargoId = 1;
        Cargo cargo = new Cargo();
        when(cargoRepository.findById(cargoId)).thenReturn(Optional.of(cargo));

        Cargo result = cargoService.getCargoById(cargoId);

        verify(cargoRepository, times(1)).findById(cargoId);
        assertNotNull(result);
        // Add more assertions based on your requirements
    }

    @Test
    void testGetNonexistentCargoById() {
        int cargoId = 1;

        when(cargoRepository.findById(cargoId)).thenReturn(Optional.empty());

        Cargo result = cargoService.getCargoById(cargoId);

        assertNull(result);
        // Add more assertions based on your requirements
    }
}