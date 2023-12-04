package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {

    @RepeatedTest(5)
    void arvoMerkki() {
        Pelaaja p = new Pelaaja();
        p.arvoMerkki();
        String merkki = p.getMerkki();
        System.out.print(merkki);
        assertTrue(merkki.equals("kivi") || merkki.equals("sakset") || merkki.equals("paperi"),
                "merkin pitäisi olla kivi, paperi tai sakset");
    }
}