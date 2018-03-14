package dideat.mycom.com.dideat.data;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

import dideat.mycom.com.dideat.addeditmeal.AddEditMealContract;

public class MealsRepository implements MealsDataSource {

    private static MealsRepository INSTANCE = null;

    private MealDBHandler dbHandler;

    Map<String, Meal> mCachedMeals;

    private MealsRepository() {
        mCachedMeals = new LinkedHashMap<>();
        dbHandler = new MealDBHandler(null, null, null, 1);
    }

    public static MealsRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MealsRepository();
        }
        return INSTANCE;
    }

    @Override
    public void saveMeal(@NonNull Meal meal) {
        if (mCachedMeals == null) {
            mCachedMeals = new LinkedHashMap<>();
        }
        mCachedMeals.put(meal.getmId(), meal);

        dbHandler.addMeal(meal);
    }
}
