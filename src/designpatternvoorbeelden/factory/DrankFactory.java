package designpatternvoorbeelden.factory;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
public class DrankFactory {

    public Drank getDrank(String drankType) {
        if (drankType == null) {
            return null;
        }
        if (drankType.equals("WIJN")) {
            return new Wijn();
        } else if (drankType.equals("BIER")) {
            return new Bier();
        } else if (drankType.equals("COLA")) {
            return new Cola();
        }
        return null;
    }
}
