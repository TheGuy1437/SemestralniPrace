package logika;

/**
 *  Třída Snejs vytváří jednoduchou postavu, která chce předmět.
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Adam Houška
 *@version    pro školní rok 2021/2022
 *
 */
public class Bachar extends Postava {

    /**
     * Konstruktor třídy
     *
     * @param jmenoPostavy jméno postavy
     * @param predmetCoChce předmět co potřebuje
     * @param hlaskaPredVeci hláška před předáním
     * @param hlaskaPoVeci hláška po předání
     * @param predmetCoDa předmět který hráč dostane
     * @param dostalVec stav splnění výměny
     */
    public Bachar(String jmenoPostavy, Predmet predmetCoChce, String hlaskaPredVeci, String hlaskaPoVeci, Predmet predmetCoDa, boolean dostalVec) {
        super(jmenoPostavy, predmetCoChce, hlaskaPredVeci, hlaskaPoVeci, predmetCoDa, dostalVec);
    }

    @Override
    public void rekniHlaskuPred() {
        System.out.println(this.getJmenoPostavy()+ ":");
        System.out.println(this.getHlaskaPredVeci());
    }

    @Override
    public void rekniHlaskuPoVeci() {
        System.out.println(this.getJmenoPostavy()+ ":");
        System.out.println(this.getHlaskaPoVeci());
    }

}
