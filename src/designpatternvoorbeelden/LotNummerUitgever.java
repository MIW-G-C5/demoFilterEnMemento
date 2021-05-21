package designpatternvoorbeelden;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 *     voorbeeld Singleton
 */
public class LotNummerUitgever {
    private static LotNummerUitgever instance = new LotNummerUitgever();
    private int lotnummer = 10;

    private LotNummerUitgever() {
    } // private constructor

    public static LotNummerUitgever getInstance() {
        return instance;
    }

    void lotUitgeven() {
        System.out.println("Ik geef een lot uit: " + ++lotnummer);
    }
}
