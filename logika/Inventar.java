package logika;

import java.util.ArrayList;
import java.util.List;

public class Inventar {

    private String nazev;
    private List<Predmet> obsah = new ArrayList<>();
    private static final int POCET_MIST_V_INVETARI = 3;
    private HerniPlan plan;

    /**
     * Konstruktor pro class Inventář, který zakládá inventář.
     *
     * @param nazev
     */
    public Inventar(String nazev) {
        this.nazev = nazev;
    }

    /**
     * Metoda která přidává předmět do inventáře a kontroluje jeho naplnění.
     *
     * @param predmet udává jaký předmět do inventáře vkládáme
     */
    public void pridejPredmet(Predmet predmet) {
        if (obsah.size() == POCET_MIST_V_INVETARI){
            System.out.println("Tolik věcí neunesu, musím něco odhodit.\n");
            return;
        }
        obsah.add(predmet);
        return;
    }

    public void odeberPredmet(Predmet predmet) {
        if (obsah.contains(predmet)) {
            obsah.remove(predmet);
        }
        System.out.println("");
        return;
    }
    /**
     * Metoda vrací všechny předměty v inventáři, pokud u sebe nic hráč nemá, napíše to.
     *
     * @return vrací sepsané všechny předměty v inventáři
     */
    public String vypisInventar() {
        if (obsah.size() == 0) {
            return "nic u sebe nemám!";
        }
        String vracenyText = "předměty v inventáři:";
        for (Predmet predmet : obsah) {
            vracenyText += " " + predmet.getNazev();
        }
        return vracenyText;
    }

}
