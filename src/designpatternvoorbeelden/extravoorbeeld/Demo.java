package designpatternvoorbeelden.extravoorbeeld;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */



public class Demo{
    public static void main(String[] args) {
        Dier dier = new Dier();
        Dier h = new Dier();
        Dier h2 = new Hond();
        // ref type Dier       Object type hond
//        h2 Dier instantieerd
//
        Dier h3;    // Gedeclareert

        int a;            // Declareren
        a = 3;            // initialiseren
        new Hond();        // instantieren
        DierenAmbulance da = new DierenAmbulance();
        da.ophalen(new Hond());
        da.ophalen(new Cavia());
        da.ophalen(new Dier());
//        da.ophalen(new TV());








        new Leraar().gaKoffieHalen().opdrinken();
        Leraar piet = new Leraar();
        Koffie lekkerbakjekoffie =   piet.gaKoffieHalen();
        lekkerbakjekoffie.opdrinken();
        piet.gaKoffieHalen().roeren();
    }
}



class Leraar{
    void rondRennen(){
        System.out.println("blokje rond");
    }
    //abstract int zegonsjeleeftijd();
    ArabischeKoffie gaKoffieHalen(){
        return new ArabischeKoffie();
    }
}

class WiskundeLeraar extends Leraar{
    Koffie gaKoffieHalen(int a){    // override   1sig 2co retu 3 accem 4 exp
        return new ArabischeKoffie();
    }
    int zegonsjeleeftijd() {
        return 55;
    }
}



class Koffie{
    void opdrinken() {
        System.out.println("Opdrinken van Koffie");
    }
}
class ArabischeKoffie extends Koffie{
    void roeren() {
        System.out.println("roeren in koffie");
    }
}











class DierenAmbulance{
    void ophalen(Dier h) {
//        h.blaffen();
        System.out.println("ophalen");
    }


}
class TV{}

class Dier{

}
class Hond extends Dier{
    void blaffen() {
        System.out.println("blaffen");
    }
}
class Cavia extends Dier{}







