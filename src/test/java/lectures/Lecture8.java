package lectures;


import beans.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class Lecture8 {

  @Test
  public void simpleGrouping() throws Exception {
    Map<String, List<Car>> carsByMake = MockData.getCars()
        .stream()
        .collect(Collectors.groupingBy(Car::getMake));

    carsByMake.forEach((make, cars) -> {
      System.out.println(make);
      cars.forEach(System.out::println);
    });
  }

  @Test
  public void groupingAndCounting() throws Exception {
    ArrayList<String> names = Lists
        .newArrayList(
            "John",
            "John",
            "Mariam",
            "Alex",
            "Mohammado",
            "Mohammado",
            "Vincent",
            "Alex",
            "Alex"
        );
    Map<String, Long> namesCount = names.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    namesCount.forEach((name, count) -> System.out.printf("%s > %s\n", name, count));
  }
}