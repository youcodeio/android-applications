package team.io.youcodeio.ui.adapter.about;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import team.io.youcodeio.R;
import team.io.youcodeio.model.AboutModel;

/**
 * Created by stevenwatremez on 15/01/16.
 *
 */
public class AboutRecyclerViewAdapter extends RecyclerView.Adapter<AboutRecyclerViewAdapter.ViewHolder>{

    /*****************************************************************
     * DATA
     ****************************************************************/
    private int mPosition;
    private List<AboutModel> mItems;
    private int mItemLayout = R.layout.recyclerview_item_about;
    private Map<String, String> mIdToSocialNetworkLink;


    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public AboutRecyclerViewAdapter(List<AboutModel> items) {
        this.mItems = items;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public AboutRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final AboutModel item = mItems.get(position);
        holder.itemView.setTag(item);
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
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
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);
            menuButton = (ImageButton) itemView.findViewById(R.id.contextual_menu_about);
            // TODO implement Context Menu in Recycler view
            //itemView.setOnCreateContextMenuListener(this);
        }

        /*@Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menuInfo is null
            for (AboutModel item : mItems) {

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

    // TODO create the Getter of the mIdToSocialNetworkLink Map
}
