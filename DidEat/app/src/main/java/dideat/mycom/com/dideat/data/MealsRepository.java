package dideat.mycom.com.dideat.data;

import android.support.annotation.NonNull;

public class MealsRepository implements  MealsDataSource{

    String date;
    String time;
    String restaurant;
    String foodName;
    String price;

    public MealsRepository() {

    }

    @Override
    public void saveTask(@NonNull Meal meal) {

    }
}
