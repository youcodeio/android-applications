package team.io.youcodeio.ui.adapter.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.liveo.ui.RoundedImageView;
import team.io.youcodeio.R;
import team.io.youcodeio.helper.HandleErrorHelper;
import team.io.youcodeio.model.conferences.Conference;
import team.io.youcodeio.model.search.Search;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder>{

    /*****************************************************************
     * DATA
     ****************************************************************/
    private List<Search> mItems;
    private int mItemLayout = R.layout.recyclerview_item_search;
    private Context mContext;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchRecyclerViewAdapter(@NonNull final List<Search> items, @NonNull final Context context) {
        this.mItems = items;
        mContext = context;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public SearchRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Search item = mItems.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView searchVideotitle;
        public TextView searchVideoDescription;
        public ImageView searchVideoImage;
        private Context mContext;
        private Search mItem;

        public ViewHolder(@NonNull final View itemView, @NonNull final Context context) {
            super(itemView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            mContext = context;
            searchVideotitle = (TextView) itemView.findViewById(R.id.search_video_title);
            searchVideoDescription = (TextView) itemView.findViewById(R.id.search_video_description);
            searchVideoImage = (ImageView) itemView.findViewById(R.id.search_video_logo);
            itemView.findViewById(R.id.smMenuViewLeft).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "left menu view onclick", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setItem(Search item) {
            mItem = item;
            itemView.setTag(item);
            searchVideotitle.setText(item.snippet.title);
            searchVideoDescription.setText(item.snippet.description);
            Picasso.with(searchVideoImage.getContext())
                    .load(item.snippet.thumbnails.defaultResolution.url)
                    .placeholder(R.mipmap.ic_launcher_youcodeio)
                    .error(R.mipmap.ic_launcher_youcodeio)
                    .into(searchVideoImage);
        }

        @Override
        public void onClick(View view) {
            //ChannelLatestVideosActivity.start(mContext, mItem);
            Toast.makeText(mContext, "implement click", Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onLongClick(View view) {
            Toast.makeText(mContext, "implement Long click", Toast.LENGTH_SHORT).show();
            return true;
        }
    }
}
