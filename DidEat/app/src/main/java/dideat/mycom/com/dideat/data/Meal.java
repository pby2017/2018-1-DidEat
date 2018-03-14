package dideat.mycom.com.dideat.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.UUID;

public final class Meal {

//    @PrimaryKey
    @NonNull
//    @ColumnInfo(name = "entryid")
    private final String mId;

    @Nullable
//    @ColumnInfo(name = "date")
    private final String mDate;

    @Nullable
//    @ColumnInfo(name = "time")
    private final String mTime;

    @Nullable
//    @ColumnInfo(name = "place")
    private final String mPlace;

    @Nullable
//    @ColumnInfo(name = "food")
    private final String mFood;

    @Nullable
//    @ColumnInfo(name = "price")
    private final String mPrice;

//    @ColumnInfo(name = "completed")
    private final boolean mCompleted = false;

    public Meal(@Nullable String date, @Nullable String time,
                @Nullable String place,@Nullable String food, @Nullable String price) {
        this(date, time, place, food, price, UUID.randomUUID().toString(), false);
    }

    public Meal(@Nullable String date, @Nullable String time,
                @Nullable String place,@Nullable String food, @Nullable String price,
                @NonNull String id, boolean completed) {
        mId = id;
        mDate = date;
        mTime = time;
        mPlace = place;
        mFood = food;
        mPrice = price;
    }

    public boolean isEmpty() {
        return !(mDate.length()!=0 && mTime.length()!=0 &&
                mPlace.length()!=0 && mFood.length()!=0 &&
                mPrice.length()!=0);
    }

    @NonNull
    public String getmId() {
        return mId;
    }

    @Nullable
    public String getmDate() {
        return mDate;
    }

    @Nullable
    public String getmTime() {
        return mTime;
    }

    @Nullable
    public String getmPlace() {
        return mPlace;
    }

    @Nullable
    public String getmFood() {
        return mFood;
    }

    @Nullable
    public String getmPrice() {
        return mPrice;
    }
}
