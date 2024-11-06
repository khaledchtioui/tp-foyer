package tn.esprit.tpfoyer.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationRestController.class)
public class ReservationRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IReservationService reservationService;

    @Test
    public void testGetReservations() throws Exception {
        // Arrange
        Reservation reservation = new Reservation();
        List<Reservation> reservations = Collections.singletonList(reservation);
        when(reservationService.retrieveAllReservations()).thenReturn(reservations);

        // Act & Assert
        mockMvc.perform(get("/reservation/retrieve-all-reservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    public void testRetrieveReservation() throws Exception {
        // Arrange
        String reservationId = "8";
        Reservation reservation = new Reservation();
        when(reservationService.retrieveReservation(reservationId)).thenReturn(reservation);

        // Act & Assert
        mockMvc.perform(get("/reservation/retrieve-reservation/{reservation-id}", reservationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testRetrieveReservationParDateEtStatus() throws Exception {
        // Arrange
        Date date = new Date();
        boolean status = true;
        List<Reservation> reservations = Collections.singletonList(new Reservation());
        when(reservationService.trouverResSelonDateEtStatus(date, status)).thenReturn(reservations);

        // Act & Assert
        mockMvc.perform(get("/reservation/retrieve-reservation-date-status/{d}/{v}", date, status))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    public void testAddReservation() throws Exception {
        // Arrange
        Reservation reservation = new Reservation();
        when(reservationService.addReservation(any(Reservation.class))).thenReturn(reservation);

        // Act & Assert
        mockMvc.perform(post("/reservation/add-reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"attribute\": \"value\"}")) // JSON example, update as needed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    public void testRemoveReservation() throws Exception {
        // Arrange
        String reservationId = "8";
        doNothing().when(reservationService).removeReservation(reservationId);

        // Act & Assert
        mockMvc.perform(delete("/reservation/remove-reservation/{reservation-id}", reservationId))
                .andExpect(status().isOk());
    }

    @Test
    public void testModifyReservation() throws Exception {
        // Arrange
        Reservation reservation = new Reservation();
        when(reservationService.modifyReservation(any(Reservation.class))).thenReturn(reservation);

        // Act & Assert
        mockMvc.perform(put("/reservation/modify-reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"attribute\": \"value\"}")) // JSON example, update as needed
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
}
