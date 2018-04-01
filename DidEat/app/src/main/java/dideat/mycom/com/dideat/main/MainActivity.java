package dideat.mycom.com.dideat.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dideat.mycom.com.dideat.R;
import dideat.mycom.com.dideat.addeditmeal.AddEditMealActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mMainPresenter;

    private Button mAddButton;
    private Button mMealButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainPresenter = new MainPresenter(MainActivity.this);

        setupViewContent();
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    void setupViewContent() {
        mAddButton = (Button) findViewById(R.id.mAddButton);
        mMealButton = (Button) findViewById(R.id.mMealButton);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddMeal();
            }
        });

        mMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMeal();
            }
        });
    }

    private void showAddMeal() {
        Intent intent = new Intent(MainActivity.this, AddEditMealActivity.class);
        startActivityForResult(intent, AddEditMealActivity.REQUEST_ADD_MEAL);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mMainPresenter.result(requestCode, resultCode);
    }

    private void showMeal() {

    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.successfully_saved_meal_message));
    }

    private void showMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
