package primefactors;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrimeFactorsTest {

    @Test
    public void oneShouldHaveNoPrimeFactors() {
        assertThat(PrimeFactors.factorsOf(1), is(new ArrayList<>()));
    }

 

}