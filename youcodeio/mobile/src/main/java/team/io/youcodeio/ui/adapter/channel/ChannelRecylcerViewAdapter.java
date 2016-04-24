package team.io.youcodeio.ui.adapter.channel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import team.io.youcodeio.R;
import team.io.youcodeio.model.about.About;
import team.io.youcodeio.model.channel.Channel;
import team.io.youcodeio.ui.activity.channels.ChannelLatestVideosActivity;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class ChannelRecylcerViewAdapter extends RecyclerView.Adapter<ChannelRecylcerViewAdapter.ViewHolder> {


    /*****************************************************************
     * DATA
     ****************************************************************/
    private List<Channel> mItems;
    private int mItemLayout = R.layout.recyclerview_item_channel;
    public Context mContext;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ChannelRecylcerViewAdapter(@NonNull final List<Channel> items, @NonNull Context context) {
        this.mItems = items;
        mContext = context;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public ChannelRecylcerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Channel item = mItems.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView description;
        public Context mContext;
        private Channel mItem;
        // TODO public ImageView logoChannel;

        public ViewHolder(@NonNull final View itemView, @NonNull final Context context) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            mContext = context;
            title = (TextView) itemView.findViewById(R.id.channel_title);
            description = (TextView) itemView.findViewById(R.id.channel_description);
            // TODO logoChannel = (ImageView) itemView.findViewById(R.id.logo_channel);
        }

        public void setItem(Channel item) {
            mItem = item;
            itemView.setTag(item);
            title.setText(item.title);
            description.setText(item.youtubeId);
            // TODO public ImageView logoChannel;
        }

        @Override
        public void onClick(View view) {
            ChannelLatestVideosActivity.start(mContext, mItem.youtubeId);
        }
    }
}
