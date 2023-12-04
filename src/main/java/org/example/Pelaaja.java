package org.example;

/**
 * Kivi, paperi, sakset -pelin pelaaja
 *
 * @author Ira Dook
 */
public class Pelaaja {
    /** Pelaajan voitot*/
    private int voitot;

    /** Pelaajan käsimerkki pelissä*/
    private String merkki;

    public Pelaaja(){
        voitot = 0;
    }

    /**
     * Arpoo pelaajan käsimerkin kolmesta vaihtoehdosta (kivi, paperi, sakset)
     */
    public void arvoMerkki() {
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                this.merkki = "kivi";
                break;
            case 1:
                this.merkki = "paperi";
                break;
            case 2:
                this.merkki = "sakset";
                break;
        }
    }
    public void setVoitot(int voitot) {
        this.voitot = voitot;
    }
    public int getVoitot() {
        return voitot;
    }
    public String getMerkki(){
        return merkki;
    }
    public void setMerkki(String merkki) {
        this.merkki = merkki;
    }
}
