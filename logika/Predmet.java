package logika;

import java.util.List;

/**
 *  Třída Predmet slouží k vytvoření jednotlivých předmětů v místnostech
 *  a jejich manipulaci
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */

public class Predmet {

    private String nazev;
    private Boolean jdePremistit;

    /**
     *  Vytváří jednotlivé předměty.
     */
    public Predmet(String nazev, Boolean jdePremistit) {
        this.nazev = nazev;
        this.jdePremistit = jdePremistit;
    }

    /**
     *  Vrací název předmětu.
     */
    public String getNazev() {
        return nazev;
    }

    /**
     *  Nastavuje název předmětu.
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     *  Vrací, jestli se dá předmět vzít.
     */
    public Boolean getJdePremistit() {
        return jdePremistit;
    }

    /**
     *  Nastavuje jestli se dá předmět vzít.
     */
    public void setJdePremistit(Boolean jdePremistit) {
        this.jdePremistit = jdePremistit;
    }
}
