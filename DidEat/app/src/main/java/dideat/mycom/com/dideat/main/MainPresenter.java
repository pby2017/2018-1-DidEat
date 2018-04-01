package dideat.mycom.com.dideat.main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.Map;

import dideat.mycom.com.dideat.addeditmeal.AddEditMealActivity;
import dideat.mycom.com.dideat.data.Meal;
import dideat.mycom.com.dideat.data.MealsDataSource;
import dideat.mycom.com.dideat.data.MealsRepository;
import dideat.mycom.com.dideat.data.RecyclerAdapter;

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
