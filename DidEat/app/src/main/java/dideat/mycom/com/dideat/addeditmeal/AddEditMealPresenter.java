package dideat.mycom.com.dideat.addeditmeal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import dideat.mycom.com.dideat.data.Meal;
import dideat.mycom.com.dideat.data.MealsDataSource;
import dideat.mycom.com.dideat.data.MealsRepository;
import io.realm.Realm;

class AddEditMealPresenter implements AddEditMealContract.Presenter {

    @NonNull
    private final AddEditMealContract.View mAddEditMealView;

    @NonNull
    private final MealsDataSource mMealsRepository;

    @Nullable
    private String mMealId;

    private Realm mRealm;

    public AddEditMealPresenter(@Nullable String mealId,
                                @NonNull Context context,
                                @NonNull AddEditMealContract.View addEditListView) {
        mMealId = mealId;
        mMealsRepository = MealsRepository.getInstance(context);
        mAddEditMealView = addEditListView;

        mAddEditMealView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public boolean saveMeal(Meal meal) {
        if (isNewMeal()) {
            if (createMeal(meal)) {
                return true;
            } else {
                return false;
            }
        } else {
            updateMeal(meal);
            return true;
        }
    }

    private boolean isNewMeal() {
        return mMealId == null;
    }

    private boolean createMeal(Meal meal) {
        if (meal.isEmpty()) {
            mAddEditMealView.showEmptyMealError();
            return false;
        } else {
            mMealsRepository.saveMeal(meal);
            mAddEditMealView.showMealsList();
            return true;
        }

    }

    private boolean updateMeal(Meal newMeal) {

        return true;
    }
}
