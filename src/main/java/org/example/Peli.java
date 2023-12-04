package org.example;

/**
 * Kivi, sakset, paperi -peli
 * @author Ira Dook
 */
public class Peli {

    /**
     * Tasapelien lukumäärä
     */
    private int tasapelit;

    /**
     * Pelattujen pelien lukumäärä
     */
    private int pelatutPelit;

    /**
     * Onko peli loppunut
     */
    private boolean peliLoppui;

    /**
    * Pelin ensimmäinen pelaaja
    */
    private Pelaaja p1;

    /**
     * Pelin toinen pelaaja
     */
    private Pelaaja p2;

    /**
     * Pelin konstruktori, jossa luodaan uudet pelaajat
     */
    public Peli(){
       p1 = new Pelaaja();
       p2 = new Pelaaja();
    }

    /**
     * Pelin alustaminen alkuasetuksiin
     */
    public void alustaPeli(){
        tasapelit = 0;
        pelatutPelit = 0;
        peliLoppui = false;
        p1.setVoitot(0);
        p2.setVoitot(0);
    }

    /**
     * Kivi, paperi, sakset -pelin pelaaminen
     */
    public void pelaa() {
       alustaPeli();
        do {
            System.out.println("Erä: "
                    + (pelatutPelit+1)+ " =====================\n");
            System.out.println("Tasapelien lukumäärä: "
                    + tasapelit + "\n");
            valitseMerkki(p1, 1);
            valitseMerkki(p2, 2);
            tarkistaVoittaja();

            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Pelaajan merkki valitaa ja tulostetaan
     *
     * @param pelaaja   annettu pelaaja, jolle valitaan merkki
     * @param numero    pelaajan pelaajanumero
     */
    public void valitseMerkki(Pelaaja pelaaja, int numero){
        pelaaja.arvoMerkki();
        System.out.println("Pelaaja"+numero+" : " + pelaaja.getMerkki()
                + "\n\t Pelaaja "+numero+":lla yhteensä " + pelaaja.getVoitot() + " voittoa.");

    }

    /**
     * Tarkistetaan, kumpi pelaajista voitti pelin vai tuliko tasapeli
     */
    public void tarkistaVoittaja(){
        if (p1.getMerkki().equals(p2.getMerkki())) {
            tasapelit++;
            System.out.println("\n\t\t\t Tasapeli \n");
        }
        else if ((p1.getMerkki().equals("sakset") && p2.getMerkki().equals("paperi")) ||
                (p1.getMerkki().equals("paperi") && p2.getMerkki().equals("kivi")) ||
                (p1.getMerkki().equals("kivi") && p2.getMerkki().equals("sakset"))) {
            p1.setVoitot(p1.getVoitot()+1);
            System.out.println("Pelaaja 1 voittaa");
        } else {
            p2.setVoitot(p2.getVoitot()+1);
            System.out.println("Pelaaja 2 voittaa");
        }

        pelatutPelit++;
        if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
            peliLoppui = true;
            System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
        }
    }

    public boolean getPeliLoppui() {
        return peliLoppui;
    }
    public int getTasapelit() {
        return tasapelit;
    }
    public int getPelatutPelit() {
        return pelatutPelit;
    }
    public Pelaaja getP1() {
        return p1;
    }
    public Pelaaja getP2() {
        return p2;
    }

}
