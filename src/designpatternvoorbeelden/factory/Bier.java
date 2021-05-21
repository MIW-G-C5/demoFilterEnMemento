package designpatternvoorbeelden.factory;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
public class Bier implements Drank {

    @Override
    public void takeSip() {
        System.out.println("Een slokje bier");
    }
}
