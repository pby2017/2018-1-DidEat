package dideat.mycom.com.dideat.addeditlist;

import android.support.annotation.NonNull;

class AddEditListPresenter implements AddEditListContract.Presenter {

    private AddEditListContract.View mAddEditListView;

    public AddEditListPresenter(@NonNull AddEditListContract.View addEditListView) {
        mAddEditListView = addEditListView;

        mAddEditListView.setPresenter(this);
    }

    @Override
    public void start() {

    }
}
