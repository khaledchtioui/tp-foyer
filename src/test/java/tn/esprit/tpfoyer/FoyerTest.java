package tn.esprit.tpfoyer.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoyerTest {

    @Test
    public void testFoyerConstructorAndGetters() {
        // Arrange
        Long idFoyer = 1L;
        String nomFoyer = "Foyer A";
        long capaciteFoyer = 100L;

        // Act
        Foyer foyer = new Foyer(idFoyer, nomFoyer, capaciteFoyer, null, null);

        // Assert
        assertEquals(idFoyer, foyer.getIdFoyer());
        assertEquals(nomFoyer, foyer.getNomFoyer());
        assertEquals(capaciteFoyer, foyer.getCapaciteFoyer());
    }

    @Test
    public void testSetters() {
        // Arrange
        Foyer foyer = new Foyer();
        Long idFoyer = 2L;
        String nomFoyer = "Foyer B";
        long capaciteFoyer = 200L;

        // Act
        foyer.setIdFoyer(idFoyer);
        foyer.setNomFoyer(nomFoyer);
        foyer.setCapaciteFoyer(capaciteFoyer);

        // Assert
        assertEquals(idFoyer, foyer.getIdFoyer());
        assertEquals(nomFoyer, foyer.getNomFoyer());
        assertEquals(capaciteFoyer, foyer.getCapaciteFoyer());
    }
}