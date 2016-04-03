package team.io.youcodeio.ui.adapter.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.liveo.ui.RoundedImageView;
import team.io.youcodeio.R;
import team.io.youcodeio.helper.HandleErrorHelper;
import team.io.youcodeio.model.search.Search;

/**
 * Created by stevenwatremez on 08/03/16.
 *
 */
public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder>{

    /*****************************************************************
     * DATA
     ****************************************************************/
    private int mPosition;
    private List<Search> mItems;
    private int mItemLayout = R.layout.recyclerview_item_search;

    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public SearchRecyclerViewAdapter(@NonNull final List<Search> items) {
        this.mItems = items;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public SearchRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Search item = mItems.get(position);
        holder.itemView.setTag(item);
        holder.searchVideotitle.setText(item.snippet.title);
        holder.searchVideoDescription.setText(item.snippet.description);
        Picasso.with(holder.searchVideoImage.getContext())
                .load(item.snippet.thumbnails.defaultResolution.url)
                .placeholder(R.mipmap.ic_launcher_youcodeio)
                .error(R.mipmap.ic_launcher_youcodeio)
                .into(holder.searchVideoImage);
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

        public ViewHolder(View itemView) {
            super(itemView);
            searchVideotitle = (TextView) itemView.findViewById(R.id.search_video_title);
            searchVideoDescription = (TextView) itemView.findViewById(R.id.search_video_description);
            searchVideoImage = (ImageView) itemView.findViewById(R.id.search_video_logo);
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
