package dideat.mycom.com.dideat;

import android.app.Activity;
import android.content.Intent;

public class Presenter implements Contract.Presenter {

    private Activity activity;
    private Model model;
    private Contract.View mView;

    public Presenter(Activity activity) {
        this.activity = activity;
        this.model = new Model();
    }

    @Override
    public void setView(Contract.View view) {
        this.mView = view;
    }

    @Override
    public boolean moveToWrite() {
        Intent intent = new Intent(activity ,WriteActivity.class);
        return true;
    }

    @Override
    public boolean moveToShow() {
        Intent intent = new Intent(activity ,WriteActivity.class);
        return true;
    }
}
