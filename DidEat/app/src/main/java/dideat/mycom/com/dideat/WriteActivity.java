package dideat.mycom.com.dideat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WriteActivity extends WriteView {

    Contract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mPresenter = new Presenter(WriteActivity.this);
        mPresenter.setView(this);
    }
}
