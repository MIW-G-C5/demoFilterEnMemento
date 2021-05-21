package designpatternvoorbeelden.extravoorbeeld;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        teacher.lesgeven();
        try {
            teacher.uitleggen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Teacher {
    int aantalLeerlingen = 0;

    void lesgeven() {
        if (aantalLeerlingen == 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("er is iets fout gegaan");;
            }
        }

    }

    void uitleggen() throws Exception {
        throw new LeraarDronkenException();
    }
}

class LeraarDronkenException extends Exception {

}
