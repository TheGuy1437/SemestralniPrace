package logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 *@version    pro školní rok 2016/2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();

    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory s popisem
        Prostor cela = new Prostor("cela","ve smutné studené vězeňské cele s malým výhledem na svobodu.");
        Prostor chodby = new Prostor("chodby", "v dlouhé chodbě plné cel, které vedou do ostatních částí vězení.");
        Prostor kuchyně = new Prostor("kuchyně","ve staré vězeňské kuchyni, ještě je tu cítit zápach z obědu.");
        Prostor dílna = new Prostor("dílna","v zamčené dílně, zbylo tu po stěhování nějaké nářadí.", true);
        Prostor koupelna = new Prostor("koupelna","ve staré koupelně, jsou tu sprchy a mýdlo.");
        Prostor hřiště = new Prostor("hřiště","na vyprahlém hřišti, kde vězni tráví volný čas.");
        Prostor ventilace = new Prostor("ventilace","v úzké, zaprášené větrací šachtě.", true, false);
        Prostor knihovna = new Prostor("knihovna","v nehlídané knihovně na druhém konci budovy.");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        cela.setVychod(chodby);
        chodby.setVychod(cela);
        chodby.setVychod(kuchyně);
        chodby.setVychod(dílna);
        chodby.setVychod(koupelna);
        chodby.setVychod(hřiště);
        kuchyně.setVychod(chodby);
        dílna.setVychod(chodby);
        dílna.setVychod(ventilace);
        koupelna.setVychod(chodby);
        hřiště.setVychod(chodby);
        hřiště.setVychod(knihovna);
        ventilace.setVychod(dílna);
        ventilace.setVychod(knihovna);
        knihovna.setVychod(hřiště);
        knihovna.setVychod(ventilace);

        //Přidání předmětů do místností
        Predmet mříže = new Predmet("mříže", false);
        Predmet postel = new Predmet("postel", false);
        cela.pridejPredmet(mříže);
        cela.pridejPredmet(postel);
        Predmet mýdlo = new Predmet("mýdlo", true);
        Predmet ručník = new Predmet("ručník", true);
        koupelna.pridejPredmet(mýdlo);
        koupelna.pridejPredmet(ručník);
        Predmet tác = new Predmet("tác", true);
        Predmet kelímek = new Predmet("kelímek", true);
        Predmet stoly= new Predmet("stoly", false);
        kuchyně.pridejPredmet(tác);
        kuchyně.pridejPredmet(kelímek);
        kuchyně.pridejPredmet(stoly);
        Predmet knížky = new Predmet("knížky", true);
        Predmet vent = new Predmet("mříž_u_ventilace", false);
        knihovna.pridejPredmet(knížky);
        knihovna.pridejPredmet(vent);
        Predmet pilka = new Predmet("pilka_na_železo", true);
        Predmet dřevo = new Predmet("dřevo", true);
        dílna.pridejPredmet(pilka);
        dílna.pridejPredmet(dřevo);
        dílna.pridejPredmet(stoly);

        //Přidání předmětů pro postavy
        Predmet cíga = new Predmet("cíga", true);
        Predmet pivko = new Predmet("pivko", true);

        //Založení inventáře
        Inventar inventar = new Inventar("inventář");

        aktualniProstor = cela;  // hra začíná v domečku
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

}
