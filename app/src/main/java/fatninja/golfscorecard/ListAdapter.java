package fatninja.golfscorecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Juan on 19/05/2016.
 */
public class ListAdapter extends BaseAdapter {

    private final Context mContext;
    private final Hole[] mHoles;

    public ListAdapter(Context context, Hole[] holes){
        mContext = context;
        mHoles = holes;
    }


    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;  // No lo implementaremos
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.holeLabel = (TextView) convertView.findViewById(R.id.holeLabel);
            holder.strokesCount = (TextView) convertView.findViewById(R.id.strokeCount);
            holder.removeStrokesButton = (Button) convertView.findViewById(R.id.removeStrokeButton);
            holder.addStrokesButton = (Button) convertView.findViewById(R.id.addStrokeButton);

            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.holeLabel.setText(mHoles[position].getmLabel());
        holder.strokesCount.setText(mHoles[position].getmStrokeCount() + "" );

        holder.removeStrokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getmStrokeCount() - 1;
                if (updatedStrokeCount < 0) updatedStrokeCount = 0;

                mHoles[position].setmStrokeCount(updatedStrokeCount);
                holder.strokesCount.setText(updatedStrokeCount + "");

            }
        });

        holder.addStrokesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int updatedStrokeCount = mHoles[position].getmStrokeCount() + 1;
                mHoles[position].setmStrokeCount(updatedStrokeCount);
                holder.strokesCount.setText(updatedStrokeCount + "");

            }
        });


        return convertView;
    }


    private static class ViewHolder {
        TextView holeLabel;
        TextView strokesCount;
        Button removeStrokesButton;
        Button addStrokesButton;
    }
}
