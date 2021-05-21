package designpatternvoorbeelden.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**

 * Britt van Mourik

 */

public class ObserverPattern {


    public static void main(String[] args) {

        Band band = new Band();
        new Fanclub(band);
        new Radio(band);
        new Fanclub(band);
        new Radio(band);

        band.setDatumOptreden("morgen");
        band.setDatumOptreden("Dinsdag");
    }
}


class Band{

    private List<Observeerder> observeerders = new ArrayList<>();
    private String datumOptreden;

    public String getDatumOptreden() {
        return datumOptreden;
    }

    public void setDatumOptreden(String datumOptreden) {
        this.datumOptreden = datumOptreden;
        notifyAllObserveerders();
    }

    public void observeerderToevoegen(Observeerder observeerder){
        observeerders.add(observeerder);
    }


    public void notifyAllObserveerders(){
        for (Observeerder observeerder : observeerders) {
            observeerder.update();
        }
    }
}

abstract class Observeerder{
    protected Band band;
    public abstract void update();
}

class Fanclub extends Observeerder{

    public Fanclub(Band band){
        this.band = band;
        this.band.observeerderToevoegen(this);
    }

    @Override
    public void update(){
        System.out.println("Fanclub mailt alle fans over het optreden " + band.getDatumOptreden());
    }
}

class Radio extends Observeerder{
    public Radio(Band band){
        this.band = band;
        this.band.observeerderToevoegen(this);
    }

    @Override
    public void update(){
        System.out.println("Radio vertelt iedereen over het nieuwe optreden: " + band.getDatumOptreden());
    }
}