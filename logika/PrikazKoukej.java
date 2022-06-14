package logika;

/**
 *  Třída PrikazKoukej implementuje pro hru příkaz koukej, pomocí které se dá zjistit, co a kdo je v prostoru, kde se hrdina nachází.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */

public class PrikazKoukej implements IPrikaz {

    private static final String NAZEV = "koukej";
    private HerniPlan plan;

    /**
     * Konstruktor k příkazu koukej
     *
     * @param plan
     */
    public PrikazKoukej(HerniPlan plan) {
        this.plan = plan;
    }

    /**
     * Metoda k vypsání věcí a postav v prostoru.
     *
     * @param parametry
     */
    @Override
    public String provedPrikaz(String... parametry) {
        Prostor prostor = plan.getAktualniProstor();
        if (parametry.length > 0) {
            return "Koukej kam? zadal jsi moc parametrů.";
        }
        System.out.println(prostor.popisVeci());
        System.out.print(prostor.popisPostav());
        return "";
    }

    /**
     * Metoda k získání názvu příkazu.
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}
