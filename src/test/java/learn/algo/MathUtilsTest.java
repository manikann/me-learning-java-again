package learn.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.LongStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

  @Test
  @DisplayName("isPrime: true")
  void testIsPrime() {
    LongStream.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
        .forEach(l -> assertTrue(MathUtils.isPrime(l)));
  }

  @Test
  @DisplayName("isPrime: false")
  void testIsNotPrime() {
    LongStream.of(4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28)
        .forEach(l -> assertFalse(MathUtils.isPrime(l)));
  }

  @Test
  @DisplayName("Great Common Divisor")
  void testGCD() {
    assertEquals(1, MathUtils.gcd(12, 13));
    assertEquals(6, MathUtils.gcd(12, 18));
  }

  @Test
  @DisplayName("Prime Factors")
  void testPrimeFactors() {
    assertIterableEquals(Arrays.asList(2,3,19), MathUtils.getPrimeFactors(228));
    assertIterableEquals(Arrays.asList(2,3,5), MathUtils.getPrimeFactors(300));
  }

}