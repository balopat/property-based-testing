package primefactors;


import org.junit.Test;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeFactorsTest {

    @Test
    public void oneShouldHaveNoPrimeFactors() {
        assertThat(PrimeFactors.factorsOf(1), is(new ArrayList<>()));
    }

    @Test
    public void twoShouldHaveItselfAsPrimeFactor() {
        assertThat(PrimeFactors.factorsOf(2), is(singletonList(2)));
    }


}