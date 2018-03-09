package dideat.mycom.com.dideat;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainView extends AppCompatActivity implements Contract.View {

    private Contract.Presenter presenter;

    private Button mMoveToWriteButton;
    private Button mMoveToShowButton;

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
        bindViewInit();
    }

    void bindViewInit() {
        mMoveToWriteButton = (Button) findViewById(R.id.mMoveToWriteButton);
        mMoveToShowButton = (Button) findViewById(R.id.mMoveToShowButton);

        mMoveToWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(presenter.moveToWrite()){
                    // 인텐트 전달 여기서 할지?
                }
            }
        });

        mMoveToShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.moveToShow();
            }
        });
    }
}
