package dideat.mycom.com.dideat;

public interface Contract {

    interface View {
        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void setView(Contract.View view);
        boolean moveToWrite();
        boolean moveToShow();
    }
}
