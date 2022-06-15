package logika;


import java.util.ArrayList;
import java.util.List;

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
    private List<Prostor> seznamProstoru = new ArrayList<>();
    private Inventar inventar = new Inventar("inventář", this);
    
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

        //Přidání předmětů do místností
        Predmet mříže = new Predmet("mříže", false);
        Predmet postel = new Predmet("postel", false);
        Predmet mýdlo = new Predmet("mýdlo", true);
        Predmet ručník = new Predmet("ručník", true);
        Predmet hřeben = new Predmet("hřeben", true);
        Predmet tác = new Predmet("tác", true);
        Predmet kelímek = new Predmet("kelímek", true);
        Predmet stoly= new Predmet("stoly", false);
        Predmet knížky = new Predmet("knížky", true);
        Predmet vent = new Predmet("mříž_u_ventilace", false);
        Predmet pilka = new Predmet("pilka_na_železo", true);
        Predmet dřevo = new Predmet("dřevo", true);
        Predmet cíga = new Predmet("cíga", true);
        Predmet klíč_od_knihovny = new Predmet("klíč_od_knihovny", true);
        Predmet pivko = new Predmet("pivko", true);

        //Vytvoření postav
        Snejks snejks = new Snejks("Snejks", mýdlo, "More to jsem já co vypustil baziliška! Já jsem Hagrid a můžete mě s***.\nNemáš nějaký mejdlo pro mě?", "*udělá ze sebe pakárnu*\nTady máš, dík more!", hřeben, false);
        //Bachar bachar = new Bachar
        //Kuchar kuchar = new Kuchar

        // vytvářejí se jednotlivé prostory s popisem
        Prostor cela = new Prostor("cela","ve smutné studené vězeňské cele s malým výhledem na svobodu.", null);
        Prostor chodby = new Prostor("chodby", "v dlouhé chodbě plné cel, které vedou do ostatních částí vězení.", snejks);
        Prostor kuchyně = new Prostor("kuchyně","ve staré vězeňské kuchyni, ještě je tu cítit zápach z obědu.", null);
        Prostor dílna = new Prostor("dílna","v zamčené dílně, zbylo tu po stěhování nějaké nářadí.",null, true);
        Prostor koupelna = new Prostor("koupelna","ve staré koupelně, jsou tu sprchy a mýdlo.", null);
        Prostor hřiště = new Prostor("hřiště","na vyprahlém hřišti, kde vězni tráví volný čas.", null);
        Prostor ventilace = new Prostor("ventilace","v úzké, zaprášené větrací šachtě.",null, true, false);
        Prostor knihovna = new Prostor("knihovna","v nehlídané knihovně na druhém konci budovy.",null, true);

        // zasazení prostorů do seznamu
        seznamProstoru.add(cela);
        seznamProstoru.add(chodby);
        seznamProstoru.add(kuchyně);
        seznamProstoru.add(dílna);
        seznamProstoru.add(koupelna);
        seznamProstoru.add(hřiště);
        seznamProstoru.add(ventilace);
        seznamProstoru.add(knihovna);
        
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

        //Přiřazení předmětů do prostorů
        cela.pridejPredmet(mříže);
        cela.pridejPredmet(postel);
        koupelna.pridejPredmet(mýdlo);
        koupelna.pridejPredmet(ručník);
        kuchyně.pridejPredmet(tác);
        kuchyně.pridejPredmet(kelímek);
        kuchyně.pridejPredmet(stoly);
        knihovna.pridejPredmet(knížky);
        knihovna.pridejPredmet(vent);
        dílna.pridejPredmet(pilka);
        dílna.pridejPredmet(dřevo);
        dílna.pridejPredmet(stoly);

        aktualniProstor = cela;  // hra začíná v cele
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

    /**
     *  Metoda vrací objekt invenáře.
     *
     * @return      aktualní inventář
     */
    public Inventar getInventar() {
        return inventar;
    }


    public Prostor getProstorPodleJmena(String jmeno) {
        for (Prostor prostor : seznamProstoru ) {
            if (prostor.getNazev().equals(jmeno)) {
                return prostor;
            }
        }
        return null;
    }

    /**
     * Metoda nastavuje a mění inventář
     *
     * @param inventar inventář hráče
     */
    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }
}
