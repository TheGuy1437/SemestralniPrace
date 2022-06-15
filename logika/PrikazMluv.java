package logika;

import java.util.List;

/**
 *  Třída PrikazMluv implementuje pro hru příkaz mluv, pomocí kterého se dá mluvit s postavami a pokračovat v příběhu.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */
public class PrikazMluv implements IPrikaz{

    private static final String NAZEV = "mluv";
    private HerniPlan plan;

    public PrikazMluv(HerniPlan plan) {
        this.plan = plan;
    }

    @Override
    public String provedPrikaz(String... parametry) {
        Prostor prostor = plan.getAktualniProstor();
        if (parametry.length > 0) {
            return "Špatně zadaný příkaz, stačí napsat: mluv";
        }
        Postava postava = prostor.getPostavaVMistnosti();
        if (postava == (null)) {
            return "Nikdo tu není!";
        }
        Inventar inventar = plan.getInventar();
        List<Predmet> obsah = inventar.getObsah();
        if (postava.isDostalVec()) {
            postava.rekniHlaskuPoVeci();
            return "";
        }
        for (Predmet predmet : obsah ) {
            if ( predmet == postava.getPredmetCoChce()) {
                inventar.odeberPredmet(predmet);
                inventar.pridejPredmet(postava.getPredmetCoDa());
                postava.rekniHlaskuPoVeci();
                return "nový předmět v inventáři: " + postava.getPredmetCoDa().getNazev();
            }
        }
        postava.rekniHlaskuPred();
        return "";

    }

    @Override
    public String getNazev() {
        return NAZEV;
    }
}
