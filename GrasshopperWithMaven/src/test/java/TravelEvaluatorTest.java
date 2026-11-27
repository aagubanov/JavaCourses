import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TravelEvaluatorTest
{
  record TestCase(Point frogLocation, int frogTongueLength, List<Point> grasshopperLocations, int expected)
  {
  }

  @ParameterizedTest
  @MethodSource("getTestCases")
  void evaluateGrasshopperTravel(TestCase tc) {
    InputData inputData = new InputData(tc.frogLocation, tc.frogTongueLength, tc.grasshopperLocations);
    Assertions.assertEquals(tc.expected, TravelEvaluator.getGrasshopperTravelResult(inputData));
  }

  private static Stream<TestCase> getTestCases() {
    return Stream.of(
      new TestCase(
        new Point(0, 0),
        1,
        List.of(new Point(2, 0), new Point(1, 1), new Point(0, 1)),
        3
      ),

      new TestCase(
        new Point(0, 0),
        100,
        List.of(new Point(1, 1), new Point(2, 2)),
        1
      ),

      new TestCase(
        new Point(0, 0),
        1,
        List.of(new Point(1, 1), new Point(2, 2), new Point(3, 3)),
        -1
      )
    );
  }
}