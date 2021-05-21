package designpatternvoorbeelden.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wessel van Dommelen <w.r.van.dommelen@st.hanze.nl>
 */
public class FilterPatternLauncher {
    public static void main(String[] args) {
        List<Huis> huizen = new ArrayList<>();

        huizen.add(new Huis(0, 120));
        huizen.add(new Huis(0, 130));
        huizen.add(new Huis(1, 140));
        huizen.add(new Huis(0, 80));
        huizen.add(new Huis(1, 70));

        Criteria beganeGrond = new CriteriaBeganeGrond();
        Criteria grootHuis = new CriteriaGroot();
        Criteria grootEnBeganeGrond = new AndCriteria(beganeGrond, grootHuis);
        Criteria grootOfBeganeGrond = new OrCriteria(beganeGrond, grootHuis);

        System.out.println("\ngrote huizen: ");
        printHuizen(grootHuis.meetCriteria(huizen));

        System.out.println("\ngrote huizen op begane grond: ");
        printHuizen(grootEnBeganeGrond.meetCriteria(huizen));

        System.out.println("\nof groot of begane grond: ");
        printHuizen(grootOfBeganeGrond.meetCriteria(huizen));

    }

    public static void printHuizen(List<Huis> huizen) {
        for (Huis huis : huizen) {
            System.out.println("Huis op verdieping " + huis.getVerdiepingNiveau() +
                    " van " + huis.getVierkanteMeters() + " vierkante meter");
        }
    }
}

class Huis {
    private int verdiepingNiveau;
    private double vierkanteMeters;

    public Huis(int verdiepingNiveau, double vierkanteMeters) {
        this.verdiepingNiveau = verdiepingNiveau;
        this.vierkanteMeters = vierkanteMeters;
    }

    public int getVerdiepingNiveau() {
        return verdiepingNiveau;
    }

    public double getVierkanteMeters() {
        return vierkanteMeters;
    }
}

interface Criteria {
    List<Huis> meetCriteria(List<Huis> huizen);
}

class CriteriaGroot implements Criteria {

    @Override
    public List<Huis> meetCriteria(List<Huis> huizen) {
        List<Huis> groteHuizen = new ArrayList<>();

        for (Huis huis : huizen) {
            if (huis.getVierkanteMeters() > 100) {
                groteHuizen.add(huis);
            }
        }
        return groteHuizen;
    }
}

class CriteriaBeganeGrond implements Criteria {

    @Override
    public List<Huis> meetCriteria(List<Huis> huizen) {
        List<Huis> beganeGrondHuizen = new ArrayList<>();
        for (Huis huis : huizen) {
            if (huis.getVerdiepingNiveau() == 0) {
                beganeGrondHuizen.add(huis);
            }
        }
        return beganeGrondHuizen;
    }
}

class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Huis> meetCriteria(List<Huis> huizen) {
        List<Huis> firstCriteriaHuizen = criteria.meetCriteria(huizen);
        return otherCriteria.meetCriteria(firstCriteriaHuizen);
    }
}

class OrCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Huis> meetCriteria(List<Huis> huizen) {
        List<Huis> firstCriteriaHuizen = criteria.meetCriteria(huizen);
        List<Huis> otherCriteriaHuizen = otherCriteria.meetCriteria(huizen);

        for (Huis huis : otherCriteriaHuizen) {
            if (!firstCriteriaHuizen.contains(huis)) {
                firstCriteriaHuizen.add(huis);
            }
        }
        return firstCriteriaHuizen;
    }
}
