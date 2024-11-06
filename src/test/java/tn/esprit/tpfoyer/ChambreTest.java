package tn.esprit.tpfoyer;

import org.junit.jupiter.api.Test;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChambreTest {

    @Test
    public void testChambreConstructorAndGetters() {
        // Arrange
        long idChambre = 1L;
        long numeroChambre = 101;
        TypeChambre typeC = TypeChambre.SIMPLE;
        Set<Reservation> reservations = new HashSet<>();
        Bloc bloc = new Bloc();

        // Act
        Chambre chambre = new Chambre(idChambre, numeroChambre, typeC, reservations, bloc);

        // Assert
        assertEquals(idChambre, chambre.getIdChambre());
        assertEquals(numeroChambre, chambre.getNumeroChambre());
        assertEquals(typeC, chambre.getTypeC());
        assertEquals(reservations, chambre.getReservations());
        assertEquals(bloc, chambre.getBloc());
    }

    @Test
    public void testSetters() {
        // Arrange
        Chambre chambre = new Chambre();
        long idChambre = 2L;
        long numeroChambre = 102;
        TypeChambre typeC = TypeChambre.DOUBLE;
        Set<Reservation> reservations = new HashSet<>();
        Bloc bloc = new Bloc();

        // Act
        chambre.setIdChambre(idChambre);
        chambre.setNumeroChambre(numeroChambre);
        chambre.setTypeC(typeC);
        chambre.setReservations(reservations);
        chambre.setBloc(bloc);

        // Assert
        assertEquals(idChambre, chambre.getIdChambre());
        assertEquals(numeroChambre, chambre.getNumeroChambre());
        assertEquals(typeC, chambre.getTypeC());
        assertEquals(reservations, chambre.getReservations());
        assertEquals(bloc, chambre.getBloc());
    }
}