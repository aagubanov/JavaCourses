import com.sun.tools.javac.Main;

import java.util.List;

public class TravelEvaluator
{
  public static final int SUCCESS = -1;
  public static int getGrasshopperTravelResult(InputData inputData)
  {
    Point frogLocation = inputData.frogLocation();
    int frogTongueLanguage = inputData.frogTongueLength();
    List<Point> travelPlan = inputData.grasshopperLocations();

    long numberOfSuccessJumps = travelPlan
      .stream()
      .takeWhile(grasshopperLocation -> grasshopperLocation.distanceTo(frogLocation) > frogTongueLanguage)
      .count();

    // The unfortunate jump should also be added to the result
    return numberOfSuccessJumps == travelPlan.size() ? SUCCESS : (int)numberOfSuccessJumps + 1;
  }
}