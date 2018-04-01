package dideat.mycom.com.dideat.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import dideat.mycom.com.dideat.R;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Map<String, Meal> mCachedMeals;
    private ArrayList<String> mDateArrayList;
    private ArrayList<String> mFoodArrayList;

    public RecyclerAdapter(Map<String, Meal> mCachedMeals) {
        this.mCachedMeals = mCachedMeals;
        if (mDateArrayList == null) mDateArrayList = new ArrayList<>();
        if (mFoodArrayList == null) mFoodArrayList = new ArrayList<>();
        loadMealToArrayList();

        testPutData();
    }

    public void testPutData() {
        mDateArrayList.add("testDate1");
        mFoodArrayList.add("testFood1");
    }

    public void loadMealToArrayList() {
        Iterator<Meal> mealListCopy = mCachedMeals.values().iterator();
        while (mealListCopy.hasNext()) {
            Meal mealCopy = mealListCopy.next();
            mDateArrayList.add(mealCopy.getDate());
            mFoodArrayList.add(mealCopy.getFood());
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout_meallist, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.mDate.setText(mDateArrayList.get(position));
        holder.mFood.setText(mFoodArrayList.get(position));
        holder.mImage.setImageResource(0);
    }

    @Override
    public int getItemCount() {
        return mDateArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImage;
        public TextView mDate;
        public TextView mFood;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.mImage);
            mDate = (TextView) itemView.findViewById(R.id.mDate);
            mFood = (TextView) itemView.findViewById(R.id.mFood);
        }
    }
}
