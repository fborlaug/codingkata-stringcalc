package kata;

import java.util.List;

public class Util {

  public static String negativesAsString(List<Integer> negatives) {
    String numbers = "";
    String comma = ",";
    int i = 0;
    for(Integer number : negatives) {
      numbers = numbers + number + comma;
      i++;
      if(numbers.length()==i+1) comma = "";
    }
    return numbers;
  }
}
