package dideat.mycom.com.dideat.addeditmeal;

import dideat.mycom.com.dideat.BasePresenter;
import dideat.mycom.com.dideat.BaseView;

public interface AddEditMealContract {

    interface View extends BaseView<Presenter> {

        void showEmptyMealError();

        void showMealsList();
    }

    interface Presenter extends BasePresenter {

        boolean saveMeal(String date, String time, String place, String food, String price);
    }
}
