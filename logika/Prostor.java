package logika;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova
 * @version pro školní rok 2016/2017
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
    private boolean zamceno = false;
    private boolean viditelnost = true;
    private Postava postavaVMistnosti;
    private List<Predmet> seznamPredmetu;

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     * Druhá metoda je použita kvůli overloadingu a zjednodušení zadávání konstruktoru.
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     * @param stav Stav přístupu a viditelnosti do místnosti.
     */
    public Prostor(String nazev, String popis, Postava postava, Boolean... stav) {
        this.nazev = nazev;
        this.popis = popis;
        this.postavaVMistnosti = postava;
        vychody = new HashSet<>();
        seznamPredmetu= new ArrayList<>();
        if (stav.length == 1){
            this.zamceno = stav[0];
        }
        if (stav.length == 2) {
            this.zamceno = stav[0];
            this.viditelnost = stav[1];
        }
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda pro zjištění stavu zamčení místnosti
     */
    public boolean jeZamceno() {
        return zamceno;
    }

    /**
     * Metoda pro nastavení stavu zamčení místnosti
     *
     * @param zamceno udává stav zamčení místnosti
     *
     */
    public void setZamceno(boolean zamceno) {
        this.zamceno = zamceno;
    }

    /**
     * Metoda pro zjištění stavu viditelnosti místnosti
     */
    public boolean jeViditelnost() {
        return viditelnost;
    }

    /**
     * Metoda pro nastavení stavu viditelnosti místnosti
     *
     * @param viditelnost udává stav zamčení místnosti
     *
     */
    public void setViditelnost(boolean viditelnost) {
        this.viditelnost = viditelnost;
    }

    /**
     * Metoda pro přidání předmětu do místnosti
     *
     * @param predmet udává předmět k přidání
     *
     */
    public void pridejPredmet(Predmet predmet) {
        this.seznamPredmetu.add(predmet);
    }

    /**
     * Metoda pro odebrání předmětu do místnosti
     *
     * @param predmet udává předmět k odebrání
     *
     */
    public void odeberPredmet(Predmet predmet){
        this.seznamPredmetu.remove(predmet);
    }

    /**
     * Metoda pro zjištění zda prostor obsahuje daný předmět
     *
     * @param predmet udává předmět ke zjištění
     *
     */
    public boolean obsahujePredmet(Predmet predmet) {
        if (this.seznamPredmetu.contains(predmet)) {
            return true;
        }
        return false;
    }

    public Boolean containsPredmetPodleJmena(String jmeno) {
        for (Predmet predmet : seznamPredmetu ) {
            if (predmet.getNazev().equals(jmeno)) {
                return true;
            }
        }
        return false;
    }

    public void removePredmetPodleJmena(String jmeno) {
        for (Predmet predmet : seznamPredmetu ) {
            if (predmet.getNazev().equals(jmeno)) {
                odeberPredmet(predmet);
                return;
            }
        }
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * Metoda slouží k vrácení postavy v místnosti
     *
     * @return
     */
    public Postava getPostavaVMistnosti() {
        return postavaVMistnosti;
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Nacházíš se " + popis + "\n"
                + popisVychodu();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hala ".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    public String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            if (sousedni.viditelnost == false) {
                continue;
            } else {
                if (sousedni.zamceno == true) {
                    vracenyText += " " + sousedni.getNazev() + "(nelze vstoupit)";
                }
                else {
                    vracenyText += " " + sousedni.getNazev();
                }
            }
        }
        return vracenyText;
    }

    public String popisVeci() {
        String vracenyText = "předměty v prostoru:";
        for (Predmet predmet : seznamPredmetu){
            vracenyText += " " + predmet.getNazev();
        }
        return vracenyText;
    }

    public String popisPostav() {
        String vracenyText = "postavy v prostoru:";
        if (postavaVMistnosti != null) {
            vracenyText += " " + postavaVMistnosti.getJmenoPostavy();
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        List<Prostor>hledaneProstory = 
            vychody.stream()
                   .filter(sousedni -> sousedni.getNazev().equals(nazevSouseda))
                   .collect(Collectors.toList());
        if(hledaneProstory.isEmpty()){
            return null;
        }
        else {
            return hledaneProstory.get(0);
        }
    }

    /**
     * Metoda vrací seznam předmětů v místnosti
     *
     * @return seznam předmětů
     */
    public List<Predmet> getSeznamPredmetu() {
        return seznamPredmetu;
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
}
