package dideat.mycom.com.dideat.addeditlist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dideat.mycom.com.dideat.R;
import dideat.mycom.com.dideat.main.MainActivity;
import dideat.mycom.com.dideat.main.MainPresenter;

public class AddEditListActivity extends AppCompatActivity implements AddEditListContract.View {

    public static final int REQUEST_ADD_LIST = 1;

    private AddEditListPresenter mAddEditListPresenter;

    private EditText mDateEditText;
    private EditText mTimeEditText;
    private EditText mPlaceEditText;
    private EditText mFoodEditText;
    private EditText mPriceEditText;
    private Button mSaveButton;
    private Button mCancelButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_list);

        mAddEditListPresenter = new AddEditListPresenter(AddEditListActivity.this);

        setupViewContent();
    }

    @Override
    public void setPresenter(AddEditListContract.Presenter presenter) {

    }

    private void setupViewContent() {
        mDateEditText = (EditText) findViewById(R.id.mDateEditText);
        mTimeEditText = (EditText) findViewById(R.id.mTimeEditText);
        mPlaceEditText = (EditText) findViewById(R.id.mPlaceEditText);
        mFoodEditText = (EditText) findViewById(R.id.mFoodEditText);
        mPriceEditText = (EditText) findViewById(R.id.mPriceEditText);
        mSaveButton = (Button) findViewById(R.id.mSaveButton);
        mCancelButton = (Button) findViewById(R.id.mCancelButton);

        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!contentIsEmpty()) {
                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Fill in the blank.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private boolean contentIsEmpty() {
        if (mDateEditText.getText().length() == 0 ||
                mTimeEditText.getText().length() == 0 ||
                mPlaceEditText.getText().length() == 0 ||
                mFoodEditText.getText().length() == 0 ||
                mPriceEditText.getText().length() == 0) {
            return false;
        }
        return true;
    }
}
