package collection;
import java.util.*;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    ArrayList<Double> liste;
    liste = new ArrayList<Double>();
    for (Integer element : input) {
      liste.add(Math.pow(((element*2)+3),5));
    }
    return liste;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
     ArrayList<String> l;
    l = new ArrayList<String>();
    for (String element : input) {
      String e = capitalize(element);
      l.add(e+e);
    }
    return l;
  }
   public static String capitalize(String str){
      if(str == null || str.isEmpty()) {
          return str;  
      }
      return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}

