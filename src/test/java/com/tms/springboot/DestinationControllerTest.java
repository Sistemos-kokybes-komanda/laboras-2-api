package com.tms.springboot;

import com.tms.springboot.controller.DestinationController;
import com.tms.springboot.model.Destination;
import com.tms.springboot.service.DestinationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DestinationControllerTest {

    @Mock
    private DestinationService destinationService;

    @InjectMocks
    private DestinationController destinationController;

    private Destination destination;

    @BeforeEach
    void setUp() {
        destination = new Destination(1, "Start", "End", LocalDate.now(), LocalDate.now().plusDays(1));
    }

    @Test
    void testFindAllDestinations() {
        when(destinationService.viewAllDestinations()).thenReturn(Arrays.asList(destination));

        Iterable<Destination> result = destinationController.findAllDestination();

        assertNotNull(result);
        verify(destinationService).viewAllDestinations();
    }

    @Test
    void testFindDestinationByIdFound() {
        when(destinationService.getDestinationById(1)).thenReturn(destination);

        Destination result = destinationController.findDestinationById(1);

        assertNotNull(result);
        assertEquals(destination, result);
    }

    @Test
    void testFindDestinationByIdNotFound() {
        when(destinationService.getDestinationById(anyInt())).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> destinationController.findDestinationById(1));
    }

    @Test
    void testCreateDestination() {
        when(destinationService.createDestination(any(Destination.class))).thenReturn(destination);

        Destination result = destinationController.createDestination(destination);

        assertNotNull(result);
        assertEquals(destination, result);
    }

    @Test
    void testUpdateDestinationFound() {
        when(destinationService.updateDestination(any(Destination.class))).thenReturn(destination);

        Destination result = destinationController.updateDestination(destination);

        assertNotNull(result);
        assertEquals(destination, result);
    }

    @Test
    void testUpdateDestinationNotFound() {
        when(destinationService.updateDestination(any(Destination.class))).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> destinationController.updateDestination(destination));
    }

    @Test
    void testDeleteDestinationFound() {
        when(destinationService.getDestinationById(1)).thenReturn(destination);
        doNothing().when(destinationService).deleteDestination(1);

        assertDoesNotThrow(() -> destinationController.deleteDestination(1));
        verify(destinationService).deleteDestination(1);
    }

    @Test
    void testDeleteDestinationNotFound() {
        when(destinationService.getDestinationById(1)).thenReturn(null);

        assertThrows(ResponseStatusException.class, () -> destinationController.deleteDestination(1));
    }
}
