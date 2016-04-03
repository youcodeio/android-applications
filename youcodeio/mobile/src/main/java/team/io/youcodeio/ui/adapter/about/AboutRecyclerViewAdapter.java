package team.io.youcodeio.ui.adapter.about;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;
import team.io.youcodeio.R;
import team.io.youcodeio.model.about.About;

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


    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public AboutRecyclerViewAdapter(List<About> items) {
        this.mItems = items;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public AboutRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        ButterKnife.bind(this, v);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final About item = mItems.get(position);
        holder.itemView.setTag(item);
        holder.name.setText(item.name);
        holder.description.setText(String.format(mAboutSkillTextString, item.skills, item.description)); // FIXME : use Spanny lib to concat with different style
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    /*****************************************************************
     * INNER CLASS
     ****************************************************************/
    // TODO need to implements View.OnCreateContextMenuListener
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;
        public ImageButton menuButton;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.about_dev_name);
            description = (TextView) itemView.findViewById(R.id.about_dev_description);
            menuButton = (ImageButton) itemView.findViewById(R.id.contextual_menu_about);
            // TODO implement Context Menu in Recycler view
            //itemView.setOnCreateContextMenuListener(this);
        }

        /*@Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menuInfo is null
            for (About item : mItems) {

            }
            menu.add();
            menu.add();
        }*/
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
