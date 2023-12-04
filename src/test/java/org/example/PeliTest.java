package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PeliTest {

    private Peli peli;
    @BeforeEach
    void before(){
        peli = new Peli();
    }

    @Test
    void alustaPeli() {
        peli.alustaPeli();
        assertTrue(!peli.getPeliLoppui() &&
                peli.getTasapelit() == 0 && peli.getPelatutPelit() == 0
                && peli.getP1().getVoitot() == 0 && peli.getP2().getVoitot() == 0,
                "Peli ei alustu oikein");
    }

    @Test
    void pelaa(){
        peli.pelaa();
        assertTrue(peli.getP1().getVoitot() == 3 || peli.getP2().getVoitot() == 3,
                "Kummallakaan pelaajalla ei ole 3 voittoa");
    }

    @Test
    void valitseMerkki() {
        Pelaaja p = new Pelaaja();
        peli.valitseMerkki(p, 5);
        assertTrue(p.getMerkki().equals("kivi") || p.getMerkki().equals("sakset") || p.getMerkki().equals("paperi"),
                "Merkki ei ollut kivi, paperi tai sakset");
    }

    @ParameterizedTest
    @CsvSource({"kivi, sakset","sakset, paperi", "paperi, kivi"})
    void tarkistaVoittajaEnsimmäinenPelaajaVoittaa(String merkki1, String merkki2) {
        Pelaaja p1 = peli.getP1();
        Pelaaja p2 = peli.getP2();

        p1.setMerkki(merkki1);
        p2.setMerkki(merkki2);

        peli.tarkistaVoittaja();
        assertTrue(p1.getVoitot() == 1 && p2.getVoitot() == 0, "Pelaaja 1 ei voita");
    }

    @ParameterizedTest
    @CsvSource({"kivi, sakset","sakset, paperi", "paperi, kivi"})
    void tarkistaVoittajaToinenPelaajaVoittaa(String merkki1, String merkki2) {
        Pelaaja p1 = peli.getP1();
        Pelaaja p2 = peli.getP2();

        p1.setMerkki(merkki2);
        p2.setMerkki(merkki1);

        peli.tarkistaVoittaja();
        assertTrue(p2.getVoitot() == 1 && p1.getVoitot() == 0,"Pelaaja 2 ei voita");
    }

    @Test
    void tarkistaVoittajaTasapeli(){
        Pelaaja p1 = peli.getP1();
        Pelaaja p2 = peli.getP2();

        p1.setMerkki("sakset");
        p2.setMerkki("sakset");

        peli.tarkistaVoittaja();
        assertTrue(p2.getVoitot() == 0 && p1.getVoitot() == 0 && peli.getTasapelit() == 1, "ei tule tasapeliä");
    }
}