package dideat.mycom.com.dideat.data;

import java.util.Map;

public interface MealsDataSource {

    Map<String, Meal> getCachedMeals();

    void saveMeal(Meal newMeal);
}
