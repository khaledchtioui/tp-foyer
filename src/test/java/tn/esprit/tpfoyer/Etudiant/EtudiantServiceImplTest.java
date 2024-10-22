package tn.esprit.tpfoyer.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.service.EtudiantServiceImpl;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EtudiantServiceImplTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        etudiant = new Etudiant();
        etudiant.setNomEtudiant("Dupont");
        etudiant.setPrenomEtudiant("Jean");
        etudiant.setCinEtudiant(12345678L);
        etudiant.setDateNaissance(new Date());
    }

    @Test
    public void testAddEtudiant() {
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        Etudiant createdEtudiant = etudiantService.addEtudiant(etudiant);

        assertNotNull(createdEtudiant);
        assertEquals(etudiant.getNomEtudiant(), createdEtudiant.getNomEtudiant());
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    public void testRetrieveEtudiant() {
        when(etudiantRepository.findById(anyLong())).thenReturn(Optional.of(etudiant));

        Etudiant foundEtudiant = etudiantService.retrieveEtudiant(1L);

        assertNotNull(foundEtudiant);
        assertEquals(etudiant.getNomEtudiant(), foundEtudiant.getNomEtudiant());
        verify(etudiantRepository, times(1)).findById(1L);
    }

    @Test
    public void testModifyEtudiant() {
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        etudiant.setNomEtudiant("Martin");
        Etudiant updatedEtudiant = etudiantService.modifyEtudiant(etudiant);

        assertEquals("Martin", updatedEtudiant.getNomEtudiant());
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    public void testRemoveEtudiant() {
        doNothing().when(etudiantRepository).deleteById(anyLong());

        etudiantService.removeEtudiant(1L);

        verify(etudiantRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testRecupererEtudiantParCin() {
        when(etudiantRepository.findEtudiantByCinEtudiant(anyLong())).thenReturn(etudiant);

        Etudiant foundEtudiant = etudiantService.recupererEtudiantParCin(12345678L);

        assertNotNull(foundEtudiant);
        assertEquals(etudiant.getCinEtudiant(), foundEtudiant.getCinEtudiant());
        verify(etudiantRepository, times(1)).findEtudiantByCinEtudiant(12345678L);
    }
}
