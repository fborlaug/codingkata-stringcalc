package kata;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static junit.framework.Assert.assertEquals;

public class StringCalculatorTest {

  private StringCalculator sc;

  @Rule
  public ExpectedException expectedEx = ExpectedException.none();

  @Before
  public void setup() {
    sc = new StringCalculator();
  }

  @Test
  public void empty_string() {

    assertEquals(0, sc.add(""));
  }

  @Test
  public void one_parameter_1() {
    assertEquals(1, sc.add("1"));
  }

  @Test
  public void two_parameters_1_and_2() {
    assertEquals(3, sc.add("1,2"));
  }

  @Test
  public void many_parameters() {
    assertEquals(15, sc.add("1,2,3,4,5"));
  }

  @Test
  public void parameters_delimited_with_newline_and_commas() {
    assertEquals(6, sc.add("1\n2,3"));
  }
  @Test
  public void parameters_with_custom_delimiter() {
    assertEquals(3, sc.add("//;\n1;2"));
  }

  @Test
  public void parameters_with_negative_parameter_throw_exception() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("negatives not allowed: -3");
    sc.add("1,2,-3,4,5");
  }

  @Test
  public void parameters_with_two_negative_parameters_throw_exception() {
    expectedEx.expect(IllegalArgumentException.class);
    expectedEx.expectMessage("negatives not allowed: -3,-4");
    sc.add("1,2,-3,-4,5");
  }

  @Test
  public void numbers_bigger_than_1000_should_be_ignored() {
    assertEquals(3, sc.add("1000,1,2"));
  }

  @Test
  public void delimiter_of_any_length() {
    assertEquals(6, sc.add("//[***]\\n1***2***3"));
  }

}
