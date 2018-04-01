package dideat.mycom.com.dideat.addeditmeal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dideat.mycom.com.dideat.R;
import dideat.mycom.com.dideat.data.Meal;
import dideat.mycom.com.dideat.data.MealsRepository;

public class AddEditMealActivity extends AppCompatActivity implements AddEditMealContract.View {

    public static final int REQUEST_ADD_MEAL = 1;
    private static final String ARGUMENT_EDIT_MEAL_ID = "EDIT_TASK_ID";

    private AddEditMealContract.Presenter mAddEditMealPresenter;

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
        setContentView(R.layout.activity_add_edit_meal);

        String mealId = getIntent().getStringExtra(AddEditMealActivity.ARGUMENT_EDIT_MEAL_ID);

        new AddEditMealPresenter(mealId,
                getApplicationContext(),
                AddEditMealActivity.this);

        setupViewContent();
    }

    @Override
    public void setPresenter(AddEditMealContract.Presenter presenter) {
        mAddEditMealPresenter = presenter;
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
                if (isSaveMeal()) {
                    Intent returnIntent = new Intent();
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
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

    public boolean isSaveMeal() {
        return (mAddEditMealPresenter.saveMeal(newMeal()));
    }

    public Meal newMeal() {
        String date = mDateEditText.getText().toString();
        String time = mTimeEditText.getText().toString();
        String place = mPlaceEditText.getText().toString();
        String food = mFoodEditText.getText().toString();
        String price = mPriceEditText.getText().toString();

        return new Meal(date,time,place,food,price);
    }

    @Override
    public void showEmptyMealError() {
        Toast.makeText(getApplicationContext(), getString(R.string.empty_meal_message), Toast.LENGTH_SHORT).show();
    }
}
