package primefactors;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.singletonList;

public class PrimeFactors {


    public static List<Integer> factorsOf(int n) {
        if (n > 1) {
            return singletonList(n);
        }
        return new ArrayList<>();
    }
}
