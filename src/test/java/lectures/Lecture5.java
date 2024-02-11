package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    Predicate<Car> carPredicate = car -> car.getPrice() < 20000;
    List<Car> carsFiltered = cars.stream()
        .filter(carPredicate)
        .collect(Collectors.toList());
    carsFiltered.forEach(System.out::println);
    System.out.println(carsFiltered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> personDTOList = people.stream()
        .map(PersonDTO::map)
        .collect(Collectors.toList());
    personDTOList.forEach(System.out::println);
    assertThat(personDTOList).hasSize(people.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    // transform from one data type to another
    List<Car> cars = MockData.getCars();
    cars.stream()
        .mapToDouble(Car::getPrice)
        .average().ifPresent(System.out::println);
  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}