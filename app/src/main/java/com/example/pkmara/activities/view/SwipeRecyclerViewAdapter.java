package com.example.pkmara.activities.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.example.pkmara.R;
import com.example.pkmara.activities.presenter.MainActivity;
import com.example.pkmara.activities.presenter.MenuActivity;
import com.example.pkmara.activities.presenter.MenuDetailActivity;
import com.example.pkmara.models.MenuObject;
import com.example.pkmara.models.OrderJSON;

import java.util.ArrayList;

public class SwipeRecyclerViewAdapter extends RecyclerSwipeAdapter<SwipeRecyclerViewAdapter.SimpleViewHolder> {
    private OrderJSON mOrderJson;
    private Context mContext;
    private ArrayList<MenuObject> menuList;

    public SwipeRecyclerViewAdapter(Context context, ArrayList<MenuObject> objects) {
        this.mContext = context;
        this.menuList = objects;
        mOrderJson = MainActivity.mOrderJSON;
    }


    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.swipe_layout, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final SimpleViewHolder viewHolder, final int position) {
        final MenuObject item = menuList.get(position);
        viewHolder.Name.setText(item.getMenuName() + " - Row Position " + position);
        viewHolder.EmailId.setText(String.valueOf((int)item.getPrice()));
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        //dari kiri
        //viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper1));
        //dari kanan
        viewHolder.swipeLayout.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wraper));
        viewHolder.swipeLayout.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onStartOpen(SwipeLayout layout) {
            }
            @Override
            public void onOpen(SwipeLayout layout) {
            }
            @Override
            public void onStartClose(SwipeLayout layout) {
            }
            @Override
            public void onClose(SwipeLayout layout) {
            }
            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
            }
            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
            }
        });

        viewHolder.swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, " Click : " + item.getMenuName() + " \n" + String.valueOf(item.getQuantitiy()), Toast.LENGTH_SHORT).show();
            }
        });
/*
        viewHolder.btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on Information " + viewHolder.Name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
*/
        viewHolder.Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(view.getContext(), "Clicked on Share " + viewHolder.Name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MenuDetailActivity.class);
                intent.putExtra("MENU_NAME", menuList.get(position).getMenuName());
                intent.putExtra("MENU_PRICE", String.valueOf(menuList.get(position).getPrice()/menuList.get(position).getQuantitiy()));
                intent.putExtra("MENU_QUANTITY", menuList.get(position).getQuantitiy());
                Log.d("Debug", "MENU_PRICE: " + (menuList.get(position).getPrice())/(menuList.get(position).getQuantitiy()));
                mContext.startActivity(intent);
                Toast.makeText(view.getContext(), "Clicked on Edit  " + viewHolder.Name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        viewHolder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String mName = menuList.get(position).getMenuName();
                mItemManger.removeShownLayouts(viewHolder.swipeLayout);
                menuList.remove(position);
                //Log.d("Debug", "MenuName: " + mName);
                //Log.d("Debug", "Position: " + String.valueOf(position));
                //mOrderJson.removeMenuObj(mName);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, menuList.size());
                mItemManger.closeAllItems();
                Toast.makeText(v.getContext(), "Deleted " + viewHolder.Name.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mItemManger.bindView(viewHolder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public SwipeLayout swipeLayout;
        public TextView Name;
        public TextView EmailId;
        public TextView Delete;
        public TextView Edit;
        public TextView Share;
        public ImageButton btnLocation;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            swipeLayout = (SwipeLayout) itemView.findViewById(R.id.swipe);
            Name = (TextView) itemView.findViewById(R.id.Name);
            EmailId = (TextView) itemView.findViewById(R.id.EmailId);
            Delete = (TextView) itemView.findViewById(R.id.Delete);
            Edit = (TextView) itemView.findViewById(R.id.Edit);
            Share = (TextView) itemView.findViewById(R.id.Share);
            btnLocation = (ImageButton) itemView.findViewById(R.id.btnLocation);
        }
    }
}
