package designpatternvoorbeelden;

import designpatternvoorbeelden.factory.Drank;
import designpatternvoorbeelden.factory.DrankFactory;

import java.util.Arrays;
import java.util.List;


/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
public class Launcher {

    public static void main(String[] args) {
        DrankFactory drankFactory = new DrankFactory();

        Drank[] bestelling = new Drank[]{
                drankFactory.getDrank("WIJN"),
                drankFactory.getDrank("BIER"),
                drankFactory.getDrank("COLA")};

        List<Drank> bestellingVariabel = Arrays.asList(drankFactory.getDrank("WIJN"),
                drankFactory.getDrank("BIER"),
                drankFactory.getDrank("COLA"));

        for (Drank drank : bestelling) {
            drank.takeSip();
        }

        for (Drank drank : bestellingVariabel) {
            drank.takeSip();
        }
    }
}
