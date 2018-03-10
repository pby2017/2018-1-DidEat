package dideat.mycom.com.dideat.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import dideat.mycom.com.dideat.R;
import dideat.mycom.com.dideat.addeditlist.AddEditListActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter mMainPresenter;

    private Button mAddButton;
    private Button mListButton;

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
        mListButton = (Button) findViewById(R.id.mListButton);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddList();
            }
        });

        mListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showList();
            }
        });
    }

    private void showAddList() {
        Intent intent = new Intent(MainActivity.this, AddEditListActivity.class);
        startActivityForResult(intent, AddEditListActivity.REQUEST_ADD_LIST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mMainPresenter.result(requestCode, resultCode);
    }

    private void showList() {

    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.successfully_saved_list_message));
    }

    private void showMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

}
