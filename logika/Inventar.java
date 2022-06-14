package logika;

import java.util.List;

public class Inventar {

    private String nazev;
    private List<Predmet> obsah;
    private static final int POCET_MIST_V_INVETARI = 3;

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
            System.out.println("Tolik věcí neunesu, musím něco odhodit.");
            return;
        }
        obsah.add(predmet);
    }

    /**
     * Metoda vrací všechny předměty v inventáři.
     *
     * @return vrací sepsané všechny předměty v inventáři
     */
    public String vypisInventar() {
        String vracenyText = "předměty v inventáři:";
        for (Predmet predmet : obsah) {
            vracenyText += " " + predmet.getNazev();
        }
        return vracenyText;
    }

}
