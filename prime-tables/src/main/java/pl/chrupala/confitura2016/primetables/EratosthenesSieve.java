package pl.chrupala.confitura2016.primetables;

public class EratosthenesSieve {

    private final boolean[] sieve; // not prime numbers are marked as 'true'

    /**
     * Builds Eratosthenes sieve up to n (inclusive)
     */
    public EratosthenesSieve(int n) {
        sieve = new boolean[n + 1];
        sieve[0] = true; // 0 is not prime
        sieve[1] = true; // 1 is not prime
        int limit = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= limit; i++) {
            if (!sieve[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    sieve[j] = true;
                }
            }
        }
    }

    public boolean isPrime(int n) {
        return !sieve[n];
    }
}
