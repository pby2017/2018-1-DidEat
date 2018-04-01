package dideat.mycom.com.dideat.main;

import android.app.Activity;
import android.support.annotation.NonNull;

import dideat.mycom.com.dideat.addeditmeal.AddEditMealActivity;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;

    public MainPresenter(@NonNull MainContract.View mainView){
        mMainView = mainView;
        mMainView.setPresenter(this);
        mMealsRepository = MealsRepository.getInstance(context);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditMealActivity.REQUEST_ADD_MEAL == requestCode && Activity.RESULT_OK == resultCode) {
            mCachedMeals = mMealsRepository.getCachedMeals();
            mMainView.refreshRecyclerView();
            mMainView.showSuccessfullySavedMessage();
        }
    }
}
