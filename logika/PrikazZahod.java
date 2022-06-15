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
public class PrikazZahod implements IPrikaz {

    private static final String NAZEV = "zahod";
    private HerniPlan plan;

    /**
     *  Konstruktor třídy
     *
     *  @param plan herní plán, ve kterém se budou zahazovat věci
     */
    public PrikazZahod(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda pro spuštění příkazů zahod.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return vrací zprávu po proběhnutí logiky zahození předmětu
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Inventar inventar = plan.getInventar();
        Prostor prostor = plan.getAktualniProstor();
        if (parametry.length != 1) {
            return "Zadal jsi moc nebo málo parametrů. Příkaz se zadává například: zahod jídlo";
        }
        List<Predmet> seznamPredmetu = inventar.getObsah();
        for (Predmet predmet : seznamPredmetu) {
            if (predmet.getNazev().equals(parametry[0])) {
                System.out.println("Zahodil jsi: " + predmet.getNazev());
                inventar.odeberPredmet(predmet);
                plan.setInventar(inventar);
                prostor.pridejPredmet(predmet);
                return inventar.vypisInventar();
            }
        }
        return "Takový předmět nemám!";
    }

    /**
     * Metoda k získání názvu příkazu.
     *
     * @return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
