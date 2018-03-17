package dideat.mycom.com.dideat.data;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.LinkedHashMap;
import java.util.Map;

import dideat.mycom.com.dideat.addeditmeal.AddEditMealContract;
import io.realm.Realm;

public class MealsRepository implements MealsDataSource {

    private static MealsRepository INSTANCE = null;

    private static Map<String, Meal> mCachedMeals;

    private static Realm mRealm;

    private MealsRepository() {

        mCachedMeals = new LinkedHashMap<>();
    }

    public static MealsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MealsRepository();
            Realm.init(context);
            mRealm = Realm.getDefaultInstance();
        }
        return INSTANCE;
    }

    @Override
    public void saveMeal(@NonNull Meal meal) {
        if (mCachedMeals == null) {
            mCachedMeals = new LinkedHashMap<>();
        }
        mCachedMeals.put(meal.getmId(), meal);


    }
}
