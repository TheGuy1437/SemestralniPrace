package logika;

import java.util.*;

/**
 *  Třída PrikazSeber implementuje pro hru příkaz seber, pomocí kterého se dá vzít předmět z místnosti.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */
public class PrikazSeber implements IPrikaz {

    private static final String NAZEV = "seber";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se budou brát věci
     */
    public PrikazSeber(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda pro spuštění příkazů seber. Kontroluje nesebratelné předměty.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return vrací zprávu po proběhnutí logiky sebrání předmětu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Inventar inventar = plan.getInventar();
        Prostor prostor = plan.getAktualniProstor();
        if (parametry.length != 1) {
            return "Zadal jsi moc nebo málo parametrů. Příkaz se zadává například: seber jídlo";
        }
        List<Predmet> seznam = prostor.getSeznamPredmetu();
        for (Predmet predmet : seznam) {
            if (predmet.getNazev().equals(parametry[0])) {
                if (!predmet.getJdePremistit()) {
                    return "Tohle vzít nemůžu!!";
                }
                System.out.println("Sebral jsi: " + predmet.getNazev());
                inventar.pridejPredmet(predmet);
                plan.setInventar(inventar);
                prostor.odeberPredmet(predmet);
                return inventar.vypisInventar();
            }
        }
        return "Takový předmět tu není!";
    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
