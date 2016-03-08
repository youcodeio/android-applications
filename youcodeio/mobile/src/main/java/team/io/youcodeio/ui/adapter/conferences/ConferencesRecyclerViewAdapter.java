package team.io.youcodeio.ui.adapter.conferences;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

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
    private int mPosition;
    private List<Conference> mItems;
    private int mItemLayout = R.layout.recyclerview_item_conferences;
    private List<ConferenceSessions> mConferenceSessionsList;


    /*****************************************************************
     * CONSTRUCTOR
     ****************************************************************/
    public ConferencesRecyclerViewAdapter(List<Conference> items) {
        this.mItems = items;
    }

    /*****************************************************************
     * OVERRIDE METHODS
     ****************************************************************/
    @Override
    public ConferencesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(mItemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Conference item = mItems.get(position);
        holder.itemView.setTag(item);
        holder.title.setText(item.name);
        holder.subtitle.setText(item.description);
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
        public TextView title;
        public TextView subtitle;
        public ImageButton menuButton;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.conference_title);
            subtitle = (TextView) itemView.findViewById(R.id.conference_description);
            menuButton = (ImageButton) itemView.findViewById(R.id.contextual_menu_conferences);
            // TODO implement Context Menu in Recycler view
            //itemView.setOnCreateContextMenuListener(this);
        }

        /*@Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //menuInfo is null
            for (Conference item : mI) {

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

    // TODO create the Getter of the mIdToConferencesYear Map
}