import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Index {
    public static void main(String[] args) {
        ArrayList<String> worte = new ArrayList<>(Arrays.asList("hallo", "Welt1", "Java", "Programmierung", "Kurs", null));
        print(worte);

        System.out.println(hauptworte(worte));

        ArrayList<Double> zahlen = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        System.out.println(mult(zahlen, 2));

        System.out.println(func(zahlen, x -> x * 2));

        System.out.println(numerisch("12", "Wappler", "8", "-5", "8", "Hugo", "-9", "-10", "Hugo", "-10","7"));

    }
    static void print(Collection<?> collection) {
        collection.forEach(x -> System.out.println(x));
    }

    static Collection<String> hauptworte (Collection<String> worte) {
        worte.removeIf(wort -> wort == null || wort == "" || Character.isLowerCase(wort.charAt(0)) || wort.matches(".+\\d.*"));
        return worte;
    }

    static List<Double> mult (List<Double> zahlen, double faktor) {
        zahlen.replaceAll(x -> x * faktor);
        return zahlen;
    }

    static List<Double> func (List<Double> zahlen, UnaryOperator<Double> operator) {
        zahlen.replaceAll(operator);
        return zahlen;
    }

    static List<String> numerisch (String ... elements) {
        List<String> list = new ArrayList<>(Arrays.asList(elements));
        Collections.sort(list, (x, y) -> {
            if (x.matches("-?\\d+") && y.matches("-?\\d+")) {
                return Integer.compare(Integer.parseInt(x), Integer.parseInt(y));
            } else if (x.matches("-?\\d+")) {
                return -1;
            } else if (y.matches("-?\\d+")) {
                return 1;
            } else {
                return x.compareTo(y);
            }
        });
        return list;
    }
}
