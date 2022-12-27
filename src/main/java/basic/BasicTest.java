package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    if (i == null || n == null || i < 0 || n < 0) {
            return Option.none();
        }
        if (n == 0) {
            return Option.of(1);
        }
        int result = 1;
        for (int j = 0; j < n; j++) {
            // int can store max 2^32
            if (result < 0){
                return Option.none();
            }
            result *= i;
        }
        return Option.of(result);
  }
}
