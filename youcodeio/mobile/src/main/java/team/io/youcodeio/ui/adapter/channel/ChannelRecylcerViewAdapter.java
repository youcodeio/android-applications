package team.io.youcodeio.ui.adapter.channel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import team.io.youcodeio.R;
import team.io.youcodeio.model.channel.ChannelModel;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class ChannelRecylcerViewAdapter extends RecyclerView.Adapter<ChannelRecylcerViewAdapter.ViewHolder> {


    /*****************************************************************
     * DATA
     ****************************************************************/
    private int mPosition;
    private List<ChannelModel> mItems;
    private int mItemLayout = R.layout.recyclerview_item_channel;


    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ChannelRecylcerViewAdapter(List<ChannelModel> items) {
        this.mItems = items;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public ChannelRecylcerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final ChannelModel item = mItems.get(position);
        holder.itemView.setTag(item);
        holder.title.setText(item.getTitle());
        holder.description.setText(item.getSubtitle());
        // TODO holder.logoChannel.setImageBitmap(item.getLogo());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;
        // TODO public ImageView logoChannel;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            // TODO logoChannel = (ImageView) itemView.findViewById(R.id.logo_channel);
        }
    }

    /*****************************************************************
     * PUBLIC METHOD
     ****************************************************************/

    public int getPosition() {
        return mPosition;
    }

    public void setPosition(int position) {
        this.mPosition = position;
    }
}
