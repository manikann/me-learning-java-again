package learn.algo.randomnumbers;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class LinearCongruentialGenerators {

  final private long multiplier;
  final private long increment;
  final private long modulus;

  private long lastRandomNumber;

  LinearCongruentialGenerators(long multiplier, long increment, long modulus, long seed) {
    this.multiplier = multiplier;
    this.increment = increment;
    this.modulus = modulus;
    this.lastRandomNumber = seed;
  }

  long next() {
    final var nextRandomNumber = ((lastRandomNumber * multiplier) + increment) % modulus;
    log.info("(({} * {}) + {}) % {} = {}", lastRandomNumber, multiplier, increment, modulus,
        nextRandomNumber);
    lastRandomNumber = nextRandomNumber;
    return nextRandomNumber;
  }
}
