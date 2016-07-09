package pl.chrupala.confitura2016.primetables;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieveTest {

    private final static Integer[] FIRST_PRIMES = {2, 3, 5, 7};

    @Test
    public void testFirstPrimes() {
        int sampleLimit = FIRST_PRIMES[FIRST_PRIMES.length - 1];
        EratosthenesSieve es = new EratosthenesSieve(sampleLimit);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= sampleLimit; i++) {
            if (es.isPrime(i)) {
                result.add(i);
            }
        }

        Assert.assertArrayEquals(FIRST_PRIMES, result.toArray(new Integer[0]));
    }

}
