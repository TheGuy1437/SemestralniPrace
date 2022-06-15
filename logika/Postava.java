package logika;

/**
 *  Třída Postava slouží k vytvoření a manipulaci s postavami.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */
public class Postava {

    private String jmenoPostavy;
    private Predmet predmetCoChce;
    private String hlaskaPredVeci;
    private String hlaskaPoVeci;
    private Predmet predmetCoDa;
    private boolean dostalVec;

    /**
     * Konstruktor pro postavy třídy Postava
     *
     * @param jmenoPostavy jméno dané postavy
     * @param predmetCoChce předmět který za něco vymění
     * @param hlaskaPredVeci hláška kterou řekne před tím než mu dáme věc
     * @param hlaskaPoVeci hláška kterou řekne po tom co mu dáme věc
     * @param predmetCoDa předmět který nám dá za ten co chce
     */
    public Postava(String jmenoPostavy, Predmet predmetCoChce, String hlaskaPredVeci, String hlaskaPoVeci, Predmet predmetCoDa) {
        this.jmenoPostavy = jmenoPostavy;
        this.predmetCoChce = predmetCoChce;
        this.hlaskaPredVeci = hlaskaPredVeci;
        this.hlaskaPoVeci = hlaskaPoVeci;
        this.predmetCoDa = predmetCoDa;
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


}
