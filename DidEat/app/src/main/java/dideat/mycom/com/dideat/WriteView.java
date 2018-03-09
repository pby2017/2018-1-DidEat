package dideat.mycom.com.dideat;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WriteView extends AppCompatActivity implements Contract.View {

    private Contract.Presenter presenter;

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
        bindViewInit();
    }

    void bindViewInit() {}
}
