package logika;

/**
 *  Třída PrikazKoukej implementuje pro hru příkaz inventář, pomocí kterého se dá zjistit, co má hrdina u sebe.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */

public class PrikazInventar implements IPrikaz {

    private static final String NAZEV = "inventář";
    private HerniPlan plan;

    /**
     * Konstruktor k příkazu koukej
     *
     * @param plan vlkádá herní plán
     */
    public PrikazInventar(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda slouží pro provedení příkazu a kontrolu počtu argumentů.
     *
     * @param parametry počet parametrů závisí na konkrétním příkazu.
     * @return vrací buď chybovou hlášku nebo spouští prohledání inventáře
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Inventar inventar = plan.getInventar();
        if (parametry.length > 0) {
            return "Zadal jsi moc parametrů.";
        }
        return inventar.vypisInventar();
    }

    /**
     * Metoda vrací název příkazu
     *
     * @return  název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
