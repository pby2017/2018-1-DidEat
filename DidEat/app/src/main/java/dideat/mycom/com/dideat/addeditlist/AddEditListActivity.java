package dideat.mycom.com.dideat.addeditlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dideat.mycom.com.dideat.R;

public class AddEditListActivity extends AppCompatActivity implements AddEditListContract.View {

    public static final int REQUEST_ADD_LIST = 1;

    private AddEditListPresenter mAddEditListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_list);
    }

    @Override
    public void setPresenter(AddEditListContract.Presenter presenter) {

    }
}
