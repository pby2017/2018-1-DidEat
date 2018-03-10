package dideat.mycom.com.dideat.main;

import android.app.Activity;
import android.support.annotation.NonNull;

import dideat.mycom.com.dideat.addeditlist.AddEditListActivity;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;

    public MainPresenter(@NonNull MainContract.View mainView){
        mMainView = mainView; // do I nedd check not null?

        mMainView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditListActivity.REQUEST_ADD_LIST == requestCode && Activity.RESULT_OK == resultCode) {
            mMainView.showSuccessfullySavedMessage();
        }
    }
}
