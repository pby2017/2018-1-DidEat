package dideat.mycom.com.dideat.addeditmeal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import dideat.mycom.com.dideat.data.Meal;
import dideat.mycom.com.dideat.data.MealsDataSource;

class AddEditMealPresenter implements AddEditMealContract.Presenter {

    @NonNull
    private final MealsDataSource mMealsRepository=null; // update need not null

    @NonNull
    private AddEditMealContract.View mAddEditMealView;

    @Nullable
    private String mMealId;

    public AddEditMealPresenter(@NonNull AddEditMealContract.View addEditListView) {
        mAddEditMealView = addEditListView;

        mAddEditMealView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void saveMeal(String date, String time, String place, String food, String price) {
        if (isNewMeal()) {
            createMeal(date, time, place, food, price);
        } else {
            updateMeal(date, time, place, food, price);
        }
    }

    private boolean isNewMeal() {
        return mMealId == null;
    }

    private void createMeal(String date, String time, String place, String food, String price) {
        Meal newMeal = new Meal(date, time, place, food, price);
        if (newMeal.isEmpty()) {
            mAddEditMealView.showEmptyMealError();
        } else {
            mMealsRepository.saveTask(newMeal);
            mAddEditMealView.showMealsList();
        }

    }

    private void updateMeal(String date, String time, String place, String food, String price) {
    }
}
