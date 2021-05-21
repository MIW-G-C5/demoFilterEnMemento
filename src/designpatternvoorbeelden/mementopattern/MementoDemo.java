package designpatternvoorbeelden.mementopattern;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**

 * @author Kimberley Hommes

 */

public class MementoDemo {

    private static final String BESTANDSNAAM = "src/designpatternvoorbeelden/mementopattern/tekstvoorbeeld.txt";
    private static File bestand = new File(BESTANDSNAAM);

    public static void main(String[] args) {
        TekstVerwerker word = new TekstVerwerker();
        SaveMeFromMyself saveMeFromMyself = new SaveMeFromMyself();
        clearDocument();


        schrijfInDocument("Dit is een test met het schrijven met printwriter");
        word.setStatusDocument(neemTekstUitDocument());
        saveMeFromMyself.voegToe(word.slaStatusOpInMemento());

        schrijfInDocument("Dit is een bijlage in het tekstbestand.");
        word.setStatusDocument(neemTekstUitDocument());
        saveMeFromMyself.voegToe(word.slaStatusOpInMemento());

        System.out.println("Current: " + word.getStatusDocument());

        word.getStatusFromMemento(saveMeFromMyself.doCTRLZ(1));
        System.out.println(word.getStatusDocument());
    }

    public static void schrijfInDocument(String tekst) {
        String formerTekst = neemTekstUitDocument();
        try (PrintWriter printWriter = new PrintWriter(bestand)) {
            printWriter.println(formerTekst + tekst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String neemTekstUitDocument() {
        String tekst = "";
        try (Scanner scanner = new Scanner(bestand)) {
            while (scanner.hasNext()) {
                tekst += scanner.nextLine();
                tekst += "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return tekst;
    }

    public static void clearDocument() {
        try (PrintWriter printWriter = new PrintWriter(bestand)) {
            printWriter.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class Memento {

    private String statusDocument;

    public Memento(String statusDocument) {
        this.statusDocument = statusDocument;
    }

    public String getStatusDocument() {
        return statusDocument;
    }
}

class TekstVerwerker {

    private String statusDocument;

    public String getStatusDocument() {
        return statusDocument;
    }

    public void setStatusDocument(String statusDocument) {
        this.statusDocument = statusDocument;
    }

    public Memento slaStatusOpInMemento() {
        return new Memento(statusDocument);
    }

    public void getStatusFromMemento (Memento memento) {
        statusDocument = memento.getStatusDocument();
    }
}

class SaveMeFromMyself {

    private List<Memento> mementoList = new ArrayList<>();

    public void voegToe(Memento status) {
        mementoList.add(status);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

    public Memento doCTRLZ(int indexCurrentState) {
        if (indexCurrentState > 0) {
            return mementoList.get(indexCurrentState - 1);
        } else {
            return null;
        }
    }

    public Memento doCTRLSHIFTZ(int indexCurrentState) {
        if (indexCurrentState < mementoList.size() - 1) {
            return mementoList.get(indexCurrentState + 1);
        } else {
            return null;
        }
    }
}
