package logika;

/**
 *  Třída Postava slouží k vytvoření a manipulaci s postavami.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */
public abstract class Postava {

    private String jmenoPostavy;
    private Predmet predmetCoChce;
    private String hlaskaPredVeci;
    private String hlaskaPoVeci;
    private Predmet predmetCoDa;
    private boolean dostalVec;

    public Postava(String jmenoPostavy, Predmet predmetCoChce, String hlaskaPredVeci, String hlaskaPoVeci, Predmet predmetCoDa, boolean dostalVec) {
        this.jmenoPostavy = jmenoPostavy;
        this.predmetCoChce = predmetCoChce;
        this.hlaskaPredVeci = hlaskaPredVeci;
        this.hlaskaPoVeci = hlaskaPoVeci;
        this.predmetCoDa = predmetCoDa;
        this.dostalVec = dostalVec;
    }

    /**
     * Metoda pro zjištění jména postavy.
     *
     * @return jméno postavy
     */
    public String getJmenoPostavy() {
        return jmenoPostavy;
    }

    /**
     * Metoda pro zjištění hlášky, která zazní před předáním předmětu.
     *
     * @return hláška
     */
    public String getHlaskaPredVeci() {
        return hlaskaPredVeci;
    }

    /**
     * Metoda pro zjištění hlášky, která zazní po předání předmětu
     *
     * @return hláška
     */
    public String getHlaskaPoVeci() {
        return hlaskaPoVeci;
    }

    /**
     * Metoda pro zjištění stavu splnění úkolu.
     *
     * @return
     */
    public boolean isDostalVec() {
        return dostalVec;
    }

    /**
     * Metoda pro změníní jména postavy.
     */
    public void setJmenoPostavy(String jmenoPostavy) {
        this.jmenoPostavy = jmenoPostavy;
    }

    /**
     * Metoda pro zjištění předmětu, který postava chce.
     *
     * @return název předmětu
     */
    public Predmet getPredmetCoChce() {
        return predmetCoChce;
    }

    /**
     * Metoda pro upravení předmětu, který postava chce.
     *
     * @param predmetCoChce předmět, který postava chce
     */
    public void setPredmetCoChce(Predmet predmetCoChce) {
        this.predmetCoChce = predmetCoChce;
    }

    /**
     * Metoda na vrácení předmětu, který hráč získá za splnění úkolu.
     *
     * @return předmět
     */
    public Predmet getPredmetCoDa() {
        return predmetCoDa;
    }

    /**
     * Abstraktní metoda pro mluvení postav.
     */
    public abstract void rekniHlaskuPred();

    /**
     * Abstraktní metoda pro mluvení postav.
     */
    public abstract void rekniHlaskuPoVeci();

}
