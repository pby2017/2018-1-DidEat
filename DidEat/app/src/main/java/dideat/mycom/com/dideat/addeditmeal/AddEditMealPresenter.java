package dideat.mycom.com.dideat.addeditmeal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import dideat.mycom.com.dideat.data.Meal;
import dideat.mycom.com.dideat.data.MealsDataSource;
import dideat.mycom.com.dideat.data.MealsRepository;

class AddEditMealPresenter implements AddEditMealContract.Presenter {

    @NonNull
    private final AddEditMealContract.View mAddEditMealView;

    @NonNull
    private final MealsDataSource mMealsRepository;

    @Nullable
    private String mMealId;

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
    public boolean saveMeal(Meal newMeal) {
        if (isNewMeal()) {
            return (createMeal(newMeal));
        } else {
            return (updateMeal(newMeal));
        }
    }

    private boolean isNewMeal() {
        return mMealId == null;
    }

    private boolean createMeal(Meal newMeal) {
        if (newMeal.isEmpty()) {
            mAddEditMealView.showEmptyMealError();
            return false;
        } else {
            mMealsRepository.saveMeal(newMeal);
            mAddEditMealView.showMealsList();
            return true;
        }

    }

    private boolean updateMeal(Meal newMeal) {

        return true;
    }
}
