package dideat.mycom.com.dideat.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MealDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "mealDB.db";
    public static final String TABLE_MEALS = "meals";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_PLACE = "place";
    public static final String COLUMN_FOOD = "food";
    public static final String COLUMN_PRICE = "price";

    public MealDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_MEALS_TABLE = "CREATE TABLE "+
                TABLE_MEALS + "("+
                COLUMN_ID + " INTEGER PRIMARY KEY,"+
                COLUMN_DATE + " TEXT,"+
                COLUMN_TIME + " TEXT,"+
                COLUMN_PLACE + " TEXT,"+
                COLUMN_FOOD + " TEXT,"+
                COLUMN_PRICE + " TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_MEALS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);
        onCreate(sqLiteDatabase);
    }

    public void addMeal(Meal meal){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, meal.getmDate());
        values.put(COLUMN_TIME, meal.getmTime());
        values.put(COLUMN_PLACE, meal.getmPlace());
        values.put(COLUMN_FOOD, meal.getmFood());
        values.put(COLUMN_PRICE, meal.getmPrice());

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.insert(TABLE_MEALS, null, values);
        sqLiteDatabase.close();
    }
}
