package dideat.mycom.com.dideat.addeditmeal;

import dideat.mycom.com.dideat.BasePresenter;
import dideat.mycom.com.dideat.BaseView;
import dideat.mycom.com.dideat.data.Meal;

public interface AddEditMealContract {

    interface View extends BaseView<Presenter> {

        void showEmptyMealError();
    }

    interface Presenter extends BasePresenter {

        boolean saveMeal(Meal meal);
    }
}
