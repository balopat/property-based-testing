package primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {


    public static List<Integer> factorsOf(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n > 1) {
            int m = n;
            int divisor = 2;
            while (m >= 2) {
                if (m % divisor == 0) {
                    factors.add(divisor);
                    m /= divisor;
                } else {
                    divisor++;
                }
            }
        }
        return factors;
    }


}
