package team.io.youcodeio.ui.adapter.about;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.about.About;
import team.io.youcodeio.ui.activity.about.TeamDetailActivity;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class AboutRecyclerViewAdapter extends RecyclerView.Adapter<AboutRecyclerViewAdapter.ViewHolder> {

    @BindString(R.string.about_skill_text)
    String mAboutSkillTextString;
    /*****************************************************************
     * DATA
     ****************************************************************/
    private int mPosition;
    private List<About> mItems;
    private int mItemLayout = R.layout.recyclerview_item_about;
    public Context mContext;


    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public AboutRecyclerViewAdapter(@NonNull final  List<About> items, @NonNull final Context context) {
        this.mItems = items;
        this.mContext = context;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public AboutRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        ButterKnife.bind(this, v);
        return new ViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final About item = mItems.get(position);
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
        private About mItem;
        public TextView name;
        public TextView description;
        public ImageButton menuButton;
        public Context mContext;

        public ViewHolder(@NonNull final View itemView, @NonNull final Context context) {
            super(itemView);
            mContext = context;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.about_dev_name);
            description = (TextView) itemView.findViewById(R.id.about_dev_description);
            menuButton = (ImageButton) itemView.findViewById(R.id.contextual_menu_about);
        }

        public void setItem(About item) {
            mItem = item;
            itemView.setTag(item);
            name.setText(item.name);
            description.setText(item.description);
            description.setText(String.format("%s - %s", item.skills, item.description));
        }

        @Override
        public void onClick(View view) {
            TeamDetailActivity.start(mContext, mItem);
            //Toast.makeText(mContext,"The Item Clicked is: "+ getAdapterPosition() + " :: " + mItem,Toast.LENGTH_SHORT).show();
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
