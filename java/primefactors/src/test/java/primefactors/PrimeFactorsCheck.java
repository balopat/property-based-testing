package primefactors;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.io.*;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.Collections.singletonList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by balopat on 8/4/16.
 */
@RunWith(JUnitQuickcheck.class)
public class PrimeFactorsCheck {

    public static class Primes extends Generator<Integer> {

        private List<Integer> primes;

        public Primes() {
            super(Integer.class);
            try {
                readPrimes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        protected Primes(Class<Integer> type) {
            super(type);

        }


        @Override
        public Integer generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
            return primes.get(sourceOfRandomness.nextInt(0, primes.size() - 1));
        }

        private void readPrimes() throws IOException {
            InputStream is = getClass().getResourceAsStream("/primes.txt");
            final Reader r = new InputStreamReader(is, UTF_8);
            final BufferedReader br = new BufferedReader(r);

            primes = br.lines()
                    .map(Integer::parseInt)
                    .collect(toList());
        }
    }


    @Property(trials = 100)
    public void primeFactorsOfPrimesIsThePrimeItself(@From(Primes.class)
                                                         Integer n) {
        System.out.println(n);
        assertThat(PrimeFactors.factorsOf(n),
                is(singletonList(n)));
    }
}
