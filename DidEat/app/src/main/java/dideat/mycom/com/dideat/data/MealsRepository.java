package dideat.mycom.com.dideat.data;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

public class MealsRepository extends Application implements MealsDataSource {

    private static MealsRepository INSTANCE = null;

    private static Map<String, Meal> mCachedMeals;

    private static RealmResults<Meal> mMealsList;

    private static Realm mRealm;

    private MealsRepository() {

        mCachedMeals = new LinkedHashMap<>();
    }

    public static MealsRepository getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new MealsRepository();
            Realm.init(context);
            mRealm = Realm.getDefaultInstance();
            loadMealsList();
        }
        return INSTANCE;
    }

    @Override
    public void saveMeal(@NonNull Meal meal) {
        if (mCachedMeals == null) {
            mCachedMeals = new LinkedHashMap<>();
        }
        mCachedMeals.put(meal.getId(), meal);
        mRealm.beginTransaction();
        mRealm.copyToRealm(meal);
        mRealm.commitTransaction();
    }

    public static void loadMealsList() {
        mMealsList = mRealm.where(Meal.class)
                .findAll();
        Iterator<Meal> mealListCopy = mMealsList.iterator();
        while (mealListCopy.hasNext()) {
            Meal mealCopy = mealListCopy.next();
            mCachedMeals.put(mealCopy.getId(), mealCopy);
        }
    }

    @Override
    public Map<String, Meal> getCachedMeals() {
        return mCachedMeals;
    }
}
