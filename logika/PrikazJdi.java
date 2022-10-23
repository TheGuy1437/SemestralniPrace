package logika;

/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Jarmila Pavlickova, Luboš Pavlíček
 *@version    pro školní rok 2016/2017
 */
class PrikazJdi implements IPrikaz {
    private static final String NAZEV = "jdi";
    private HerniPlan plan;
    private boolean unlockedVent = false;
    private Hra hra;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(HerniPlan plan, Hra hra) {
        this.plan = plan;
        this.hra = hra;
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít? Musíš zadat jméno východu";
        }

        String smer = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);

        if (sousedniProstor == null || sousedniProstor.jeViditelnost() == false) {
            return "Tam se odsud jít nedá!";
        }
        else {
            if (sousedniProstor.jeZamceno() == true) {
                return "Tam se teď nedostanu!";
            }
            Prostor kontrola = plan.getAktualniProstor();
            Inventar inventar = plan.getInventar();
            // výměna předmětů
            if (plan.getAktualniProstor() == plan.getProstorPodleJmena("cela211") && kontrola.containsPredmetPodleJmena("cíga")) {
                kontrola.removePredmetPodleJmena("cíga");
                kontrola.pridejPredmet(new Predmet("pivko", true));
                System.out.println("Někdo se rychle mihl do a z tvé cely když si odcházel!");
            }
            plan.setAktualniProstor(sousedniProstor);
            // odemknutí ventilace a dílny
            if (plan.getAktualniProstor() == plan.getProstorPodleJmena("knihovna") && inventar.getPredmetPodleJmena("šroubovák") && !unlockedVent) {
                plan.getProstorPodleJmena("ventilace").setZamceno(false);
                plan.getProstorPodleJmena("dílna").setZamceno(false);
                plan.getProstorPodleJmena("ventilace").setViditelnost(true);
                unlockedVent = true;
                return sousedniProstor.dlouhyPopis() + "\nPodařilo se ti otevřít průchod do ventilace.";
            }
            if (plan.getAktualniProstor() == plan.getProstorPodleJmena("cela211") && inventar.getPredmetPodleJmena("pilka_na_železo")) {
                hra.setKonecHry(true);
                return "";
            }
            if (plan.getAktualniProstor() == plan.getProstorPodleJmena("hřiště") && inventar.getPredmetPodleJmena("pilka_na_železo")) {
                hra.setVitezstvi(true);
                hra.setKonecHry(true);
                return "Bachař:\nTak to ne! Kde si vzal tu pilku?!?! STŮJ!!!!\n\nKonec hry. Načapal tě bachař!!!";
            }
            return (sousedniProstor.dlouhyPopis() + "\n" + sousedniProstor.popisPostav());
        }
    }
    
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

}
