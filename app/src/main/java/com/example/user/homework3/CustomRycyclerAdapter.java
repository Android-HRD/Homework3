package com.example.user.homework3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User on 17-Nov-16.
 */

public class CustomRycyclerAdapter extends RecyclerView.Adapter<CustomRycyclerAdapter.CustomViewHolder> {

    private ArrayList<ChatData> chatDatas;
    private RecyclerViewCallBack recyclerViewCallBack;

    public CustomRycyclerAdapter(ArrayList<ChatData> chatDatas, Context context) {
        this.chatDatas = chatDatas;
        recyclerViewCallBack = (RecyclerViewCallBack) context;
    }


    String[] data = {"dsfsadf","dsafasd","sdfsadf","dsafsadf","asdfasdfsa","dfsafsdaf"};
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        Log.d("LifeRecycle","123");
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        //return data.length;
       // return 100;
        return chatDatas.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        ImageView btnPopup;
        Button btnLike,btnCommend;
        private String TAG="Log";

        public CustomViewHolder(View myCustomLayout) {

            super(myCustomLayout);

            btnLike= (Button) myCustomLayout.findViewById(R.id.btnLike);
            btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewCallBack.onBtnPopupClick(btnLike,0);
                }
            });
        }
    }

    class View1 extends CustomViewHolder{

        public View1(View itemView) {

            super(itemView);
        }
    }

    interface RecyclerViewCallBack{
        void onBtnPopupClick(Button btn,int position);
    }
}
