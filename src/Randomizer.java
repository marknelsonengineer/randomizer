/**
 * This class defines methods for computing pseudo-random numbers.
 * It maintains the state variable that needs to be maintained for use by those methods.
 *
 * The three constants are carefully from the book "Numerical Recipes in C".
 *
 * @author Mark Nelson
 * @since 5.0
 * @see "Java in a Nutshell"
 * @see "Numerical Recipes in C".
 */

// This example is from _Java Examples in a Nutshell_. (http://www.oreilly.com)
// Copyright (c) 1997 by David Flanagan
// This example is provided WITHOUT ANY WARRANTY either expressed or implied.
// You may study, use, modify, and distribute it for non-commercial purposes.
// For any commercial use, see http://www.davidflanagan.com/javaexamples

/**
 * Demonstrate methods for computing pseudo-random numbers.
 */
public class Randomizer {
  // Carefully chosen constants from the book "Numerical Recipes in C".
  static final int MODULUS = 233280;   // The "modulus".
  static final int MULTIPLIER = 9301;  // The "multiplier".
  static final int INCREMENT = 49297;  // The "increment".

  /**
   * The state variable maintained by each Randomizer instance.
   */
  long seed = 1;

  /**
   * The constructor for the Randomizer() class.  It must be passed some
   * arbitrary initial value or "seed" for its pseudo-randomness.
   *
   * @param seed Arbitrary initial value for the RNG.
   */
  public Randomizer(long seed) {
    this.seed = seed;
  }

  /**
   * Compute a pseudo-random float between 0 and 1.
   *
   * @return A random floating point number based on MULTIPLIER, INCREMENT, MODULUS and seed.
   */
  // Math.random() and java.util.Random are actually a lot better at computing randomness.
  public float randomFloat() {
    seed = (seed * MULTIPLIER + INCREMENT) % MODULUS;
    return (float) seed / (float) MODULUS;
  }

  /**
   * Compute a pseudo-random integer between 0 and max.
   *
   * @param max Maximum random number.
   *
   * @return A random integer between 0 and max (inclusive).
   */
  public int randomInt(int max) {
    return Math.round(max * randomFloat());
  }

  /**
   * A simple test program: It prints 10 random integers.
   */
  // Note how the Randomizer object is seeded using the current time.
  public static class Test {
    /**
     * Test class:  Print 10 random integers.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
      Randomizer r = new Randomizer(new java.util.Date().getTime());
      for (int i = 0; i < 10; i++) {
        System.out.println(r.randomInt(100));
      }
    }
  }
}