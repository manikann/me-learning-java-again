package learn.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtils {

  public static boolean isPrime(long n) {
    // 2 is a prime number
    if (n == 2) {
      log.info("{} isPrime ? true", n);
      return true;
    }

    // even numbers other than 2 are not prime
    if (n % 2 == 0) {
      log.info("{} isPrime ? false", n);
      return false;
    }

    // check for prime upto square root of given number
    final var max = Math.sqrt(n);
    final var isPrime = LongStream
        .iterate(3, l -> l <= max, l -> l + 2)
        .allMatch(l -> (n % l) > 0);

    log.info("{} isPrime ? {}", n, isPrime);

    return isPrime;
  }

  public static List<Integer> getPrimeFactors(long pn) {
    final var ret = new ArrayList<Integer>();

    long n = pn;
    // Add 2 as factor for all even numbers
    while (n % 2 == 0) {
      ret.add(2);
      n /= 2;
    }

    final var max = Math.sqrt(n);
    for (int f = 3; f <= max; f = f + 2) {
      // Add f as factor if the reminder is 0
      while (n % f == 0) {
        ret.add(f);
        n /= f;
      }
    }

    if (n > 2) {
      ret.add((int) n);
    }

    final var d = ret.stream().distinct().collect(Collectors.toList());

    log.info("Factors of {} are {}, distinct values are {}", pn, ret, d);

    return d;
  }

  public static long gcd(long a, long b) {
    if (a > b) {
      return _gcd(a, b);
    } else {
      return _gcd(b, a);
    }
  }

  private static long _gcd(long a, long b) {
    // If a = 0 then GCD(a,b)=b, since the GCD(0,b)=b, and we can stop
    if (a == 0) {
      log.info("gcd b: {}", b);
      return b;
    }

    // If b = 0 then GCD(a,b)=a, since the GCD(a,0)=a, and we can stop
    if (b == 0) {
      log.info("gcd a: {}", a);
      return a;
    }

    log.info("a: {}, b: {}", a, b);

    // Write A in quotient remainder form (A = B⋅Q + R)
    // Find GCD(B,R) using the Euclidean Algorithm since GCD(A,B) = GCD(B,R)
    return _gcd(b, a % b);
  }
}
