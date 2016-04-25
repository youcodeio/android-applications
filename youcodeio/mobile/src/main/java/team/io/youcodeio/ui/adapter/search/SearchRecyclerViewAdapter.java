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
import com.tubb.smrv.SwipeMenuLayout;

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
    final private static int VIEW_TYPE_ENABLE = 0;
    final private static int VIEW_TYPE_DISABLE = 1;

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
        boolean swipeEnable = swipeEnableByViewType(getItemViewType(position));
        holder.setItem(item, swipeEnable);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView searchVideotitle;
        public TextView searchVideoDescription;
        public ImageView searchVideoImage;
        private Context mContext;
        private Search mItem;
        private SwipeMenuLayout sml;

        public ViewHolder(@NonNull final View itemView, @NonNull final Context context) {
            super(itemView);
            itemView.setClickable(true);
            mContext = context;
            searchVideotitle = (TextView) itemView.findViewById(R.id.search_video_title);
            searchVideoDescription = (TextView) itemView.findViewById(R.id.search_video_description);
            searchVideoImage = (ImageView) itemView.findViewById(R.id.search_video_logo);
            sml = (SwipeMenuLayout) itemView.findViewById(R.id.sml);

            itemView.findViewById(R.id.btLeft).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "left button onclick", Toast.LENGTH_SHORT).show();
                    VideoDetailsActivity.start(mContext, mItem);
                }
            });

            itemView.findViewById(R.id.smContentView).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "content view onclick", Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setItem(@NonNull final Search item, final boolean swipeEnable) {
            mItem = item;
            itemView.setTag(item);
            searchVideotitle.setText(item.snippet.title);
            searchVideoDescription.setText(item.snippet.description);
            Picasso.with(searchVideoImage.getContext())
                    .load(item.snippet.thumbnails.defaultResolution.url)
                    .placeholder(R.mipmap.ic_launcher_youcodeio)
                    .error(R.mipmap.ic_launcher_youcodeio)
                    .into(searchVideoImage);

            sml.setSwipeEnable(swipeEnable);
        }
    }

    private boolean swipeEnableByViewType(int viewType) {
        return viewType == VIEW_TYPE_ENABLE;
    }
}
