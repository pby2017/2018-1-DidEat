package dideat.mycom.com.dideat.data;

public interface MealsDataSource {

    Map<String, Meal> getCachedMeals();

    void saveMeal(Meal newMeal);
}
