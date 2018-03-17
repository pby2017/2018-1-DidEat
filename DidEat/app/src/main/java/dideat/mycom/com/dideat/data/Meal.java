package dideat.mycom.com.dideat.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Meal extends RealmObject {

    @PrimaryKey
    @NonNull
    private String mId;

    @Nullable
    private String mDate;

    @Nullable
    private String mTime;

    @Nullable
    private String mPlace;

    @Nullable
    private String mFood;

    @Nullable
    private String mPrice;

    public Meal(){}

    public Meal(@Nullable String date, @Nullable String time,
                @Nullable String place, @Nullable String food, @Nullable String price) {
        this(date, time, place, food, price, UUID.randomUUID().toString());
    }

    public Meal(@Nullable String date, @Nullable String time,
                @Nullable String place, @Nullable String food, @Nullable String price,
                @NonNull String id) {
        mId = id;
        mDate = date;
        mTime = time;
        mPlace = place;
        mFood = food;
        mPrice = price;
    }

    public boolean isEmpty() {
        return !(mDate.length() != 0 && mTime.length() != 0 &&
                mPlace.length() != 0 && mFood.length() != 0 &&
                mPrice.length() != 0);
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @Nullable
    public String getDate() {
        return mDate;
    }

    @Nullable
    public String getTime() {
        return mTime;
    }

    @Nullable
    public String getPlace() {
        return mPlace;
    }

    @Nullable
    public String getFood() {
        return mFood;
    }

    @Nullable
    public String getPrice() {
        return mPrice;
    }
}
