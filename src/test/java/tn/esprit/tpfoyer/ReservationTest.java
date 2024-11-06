package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationTest {

    @Test
    public void testReservationConstructorAndGetters() {
        // Arrange
        String idReservation = "res123";
        Date anneeUniversitaire = new Date();
        boolean estValide = true;
        Set<Etudiant> etudiants = new HashSet<>();

        // Act
        Reservation reservation = new Reservation(idReservation, anneeUniversitaire, estValide, etudiants);

        // Assert
        assertEquals(idReservation, reservation.getIdReservation());
        assertEquals(anneeUniversitaire, reservation.getAnneeUniversitaire());
        assertEquals(estValide, reservation.isEstValide());
        assertEquals(etudiants, reservation.getEtudiants());
    }

    @Test
    public void testSetters() {
        // Arrange
        Reservation reservation = new Reservation();
        String idReservation = "res456";
        Date anneeUniversitaire = new Date();
        boolean estValide = false;
        Set<Etudiant> etudiants = new HashSet<>();

        // Act
        reservation.setIdReservation(idReservation);
        reservation.setAnneeUniversitaire(anneeUniversitaire);
        reservation.setEstValide(estValide);
        reservation.setEtudiants(etudiants
        // Assert

        assertEquals(idReservation, reservation.getIdReservation());
        assertEquals(anneeUniversitaire, reservation.getAnneeUniversitaire());
        assertEquals(estValide, reservation.isEstValide());
        assertEquals(etudiants, reservation.getEtudiants());
    }


}
