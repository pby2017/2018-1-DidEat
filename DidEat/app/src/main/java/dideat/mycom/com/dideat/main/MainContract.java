package dideat.mycom.com.dideat.main;

import android.support.v7.widget.RecyclerView;

import dideat.mycom.com.dideat.BasePresenter;
import dideat.mycom.com.dideat.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showSuccessfullySavedMessage();
    }

    interface Presenter extends BasePresenter {
        void result(int requestCode, int resultCode);
    }
}
