package team.io.youcodeio.ui.adapter.conferences;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import team.io.youcodeio.R;
import team.io.youcodeio.model.conferences.Conference;
import team.io.youcodeio.model.conferences.ConferenceSessions;

/**
 * Created by stevenwatremez on 11/01/16.
 *
 */
public class ConferencesRecyclerViewAdapter extends RecyclerView.Adapter<ConferencesRecyclerViewAdapter.ViewHolder> {

    /*****************************************************************
     * DATA
     ****************************************************************/
    private List<Conference> mItems;
    private int mItemLayout = R.layout.recyclerview_item_conferences;
    private Context mContext;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ConferencesRecyclerViewAdapter(@NonNull final List<Conference> items, @NonNull final Context context) {
        this.mItems = items;
        mContext = context;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public ConferencesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Conference item = mItems.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView subtitle;
        private Conference mItem;
        private Context mContext;

        public ViewHolder(@NonNull final View itemView, @NonNull final Context context) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            mContext = context;
            title = (TextView) itemView.findViewById(R.id.conference_title);
            subtitle = (TextView) itemView.findViewById(R.id.conference_description);
        }

        public void setItem(Conference item) {
            mItem = item;
            itemView.setTag(item);
            title.setText(item.name);
            subtitle.setText(item.description);
        }

        @Override
        public void onClick(View view) {
            //ChannelLatestVideosActivity.start(mContext, mItem);
            Toast.makeText(mContext, "implement click", Toast.LENGTH_SHORT).show();
        }
    }
}