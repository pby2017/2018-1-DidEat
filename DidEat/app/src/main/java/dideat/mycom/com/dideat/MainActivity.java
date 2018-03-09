package dideat.mycom.com.dideat;

import android.os.Bundle;

public class MainActivity extends MainView {

    private Contract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new Presenter(MainActivity.this);
        mPresenter.setView(this);
    }
}
