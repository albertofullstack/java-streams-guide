package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import org.junit.Test;

public class Lecture9 {

  @Test
  public void reduce() {
    Integer[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
    System.out.println(Arrays.stream(integers).reduce(0, Integer::sum));
  }
}

