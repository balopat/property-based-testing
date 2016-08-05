package primefactors;

import net.java.quickcheck.QuickCheck;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.*;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static net.java.quickcheck.generator.PrimitiveGenerators.fixedValues;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by balopat on 8/4/16.
 */
public class PrimeFactorsCheck {

    private List<Integer> primes;

    @Before
    public void readPrimes() throws IOException {
        InputStream is = getClass().getResourceAsStream("/primes.txt");
        final Reader r = new InputStreamReader(is, UTF_8);
        final BufferedReader br = new BufferedReader(r);

        primes = br.lines()
                .map(Integer::parseInt)
                .collect(toList());
    }

    @Test
    public void primeFactorsOfPrimesIsThePrimeItself() {
        for (int i = 0; i < 1000; i++) {
            Integer n = fixedValues(primes).next();
            assertThat(PrimeFactors.factorsOf(n),
                    is(singletonList(n)));

        }
    }
}
