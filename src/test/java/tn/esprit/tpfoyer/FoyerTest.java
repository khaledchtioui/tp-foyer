package tn.esprit.tpfoyer.control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ReservationRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private IReservationService reservationService;

    @InjectMocks
    private ReservationRestController reservationRestController;

    private Reservation reservation;
    private List<Reservation> listReservations;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reservationRestController).build();

        // Initialiser des objets Reservation
        reservation = new Reservation("1", new Date(), true);
        listReservations = new ArrayList<>() {{
            add(new Reservation("2", new Date(), true));
            add(new Reservation("3", new Date(), false));
        }};
    }

    @Test
    public void testGetReservations() throws Exception {
        when(reservationService.retrieveAllReservations()).thenReturn(listReservations);

        mockMvc.perform(get("/reservation/retrieve-all-reservations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists());
    }

    @Test
    public void testRetrieveReservation() throws Exception {
        String reservationId = "1";
        when(reservationService.retrieveReservation(reservationId)).thenReturn(reservation);

        mockMvc.perform(get("/reservation/retrieve-reservation/{reservation-id}", reservationId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    public void testAddReservation() throws Exception {
        when(reservationService.addReservation(any(Reservation.class))).thenReturn(reservation);

        mockMvc.perform(post("/reservation/add-reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"4\", \"date\": \"2024-01-01\", \"status\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    public void testRemoveReservation() throws Exception {
        String reservationId = "1";
        doNothing().when(reservationService).removeReservation(reservationId);

        mockMvc.perform(delete("/reservation/remove-reservation/{reservation-id}", reservationId))
                .andExpect(status().isOk());
    }

    @Test
    public void testModifyReservation() throws Exception {
        when(reservationService.modifyReservation(any(Reservation.class))).thenReturn(reservation);

        mockMvc.perform(put("/reservation/modify-reservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1\", \"date\": \"2024-01-01\", \"status\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"));
    }
}
