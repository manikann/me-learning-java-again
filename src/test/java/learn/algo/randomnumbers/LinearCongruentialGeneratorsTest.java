package learn.algo.randomnumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import learn.algo.MathUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinearCongruentialGeneratorsTest {

  @Test
  @DisplayName("multiplier=5 increment=3 modulus=7 seed=0")
  void testRandom7FullPeriod() {
    final var lcg = new LinearCongruentialGenerators(5, 3, 7, 0);

    IntStream.of(0, 1).forEach(value -> {
      // 0 x 5 + 3 mod 7  = 3
      assertEquals(3, lcg.next());

      // 3 x 5 + 3 mod 7  = 4
      assertEquals(4, lcg.next());

      // 4 x 5 + 3 mod 7  = 2
      assertEquals(2, lcg.next());

      // 2 x 5 + 3 mod 7  = 6
      assertEquals(6, lcg.next());

      // 6 x 5 + 3 mod 7  = 5
      assertEquals(5, lcg.next());

      // 5 x 5 + 3 mod 7  = 0
      assertEquals(0, lcg.next());
    });
  }

}