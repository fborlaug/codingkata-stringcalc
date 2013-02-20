package kata;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
  public int add(String input) {
    String[] values = parseInput(input);
    Integer sum = 0;
    List<Integer> negatives = new ArrayList<>();
    for (String value : values) {
      Integer number = Integer.parseInt(value);
      if (number < 0) {
        negatives.add(number);
      }
      if (number >= 1000) continue;
      sum += number;
    }
    if (!negatives.isEmpty()) {
      throw new IllegalArgumentException("negatives not allowed: " + Util.negativesAsString(negatives));
    }
    return sum;
  }

  private String[] parseInput(String input) {
    if (input.trim().isEmpty()) return new String[0];
    String regexp = "[,\\n]";
    String s = input;
    if (input.startsWith("//")) {
      if (input.charAt(2) == '[') {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(s);
        m.find();
        regexp = "\\Q" + m.group(1) + "\\E";
        s = input.substring(m.end(0) + 2);
      } else {
        regexp = s.substring(2, 3);
        s = input.substring(4);
      }
    }
    return s.split(regexp);
  }
}
