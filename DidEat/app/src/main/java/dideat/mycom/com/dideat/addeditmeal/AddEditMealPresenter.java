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

    @Nullable
    private String mMealId;

    private Realm mRealm;

    public AddEditMealPresenter(@Nullable String mealId,
                                @NonNull Context context,
                                @NonNull AddEditMealContract.View addEditListView) {
        mMealId = mealId;
        Realm.init(context);
        realm = Realm.getDefaultInstance();
        mAddEditMealView = addEditListView;

        mAddEditMealView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public boolean saveMeal(String date, String time, String place, String food, String price) {
        if (isNewMeal()) {
            if (createMeal(date, time, place, food, price)) {
                return true;
            } else {
                return false;
            }
        } else {
            updateMeal(date, time, place, food, price);
            return true;
        }
    }

    private boolean isNewMeal() {
        return mMealId == null;
    }

    private boolean createMeal(String date, String time, String place, String food, String price) {
        Meal newMeal = new Meal(date, time, place, food, price);
        if (newMeal.isEmpty()) {
            mAddEditMealView.showEmptyMealError();
            return false;
        } else {
            mMealsRepository.saveMeal(newMeal);
            mAddEditMealView.showMealsList();
            return true;
        }

    }

    private void updateMeal(String date, String time, String place, String food, String price) {
    }
}
