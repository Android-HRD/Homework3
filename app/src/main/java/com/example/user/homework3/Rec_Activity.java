package com.example.user.homework3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.paginate.Paginate;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class Rec_Activity extends AppCompatActivity implements CustomRycyclerAdapter.RecyclerViewCallBack {

    private ArrayList<ChatData> chatDatas;
    private int i;
    private int page = 1;
    private int num = 100;
    private int itemPerPage = 20;
    private boolean loading;
    private CustomRycyclerAdapter adapter;

    Button btnLike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_);

        chatDatas = new ArrayList<>();
        for (i = 1; i <= num; i++) {
            chatDatas.add(new ChatData());
        }



     //   CustomRycyclerAdapter adp = new CustomRycyclerAdapter();
        RecyclerView rec = (RecyclerView) findViewById(R.id.rec_view);
        rec.setLayoutManager(new LinearLayoutManager(this));
       // rec.setAdapter(adp);

        adapter = new CustomRycyclerAdapter(chatDatas,this);
        ScaleInAnimationAdapter animateAdapter = new ScaleInAnimationAdapter(adapter);
        rec.setItemAnimator(new SlideInLeftAnimator());
        rec.setAdapter(animateAdapter);


        //  START PAGINATION

        Paginate.Callbacks callbacks = new Paginate.Callbacks() {
            @Override
            public void onLoadMore() {
                loading = true;

                page++;
                num += itemPerPage;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        while (i <= num){
                           // contactList.add(new Contact("099 00000" + i, R.mipmap.ic_launcher));
                            chatDatas.add(new ChatData());
                            adapter.notifyItemInserted(chatDatas.size() - 1);
                            i++;
                        }
                        loading = false;
                    }
                }, 500);

            }

            @Override
            public boolean isLoading() {
                return loading;
            }

            @Override
            public boolean hasLoadedAllItems() {
                return page == 5;
            }
        };

        Paginate.with(rec, callbacks)
                .setLoadingTriggerThreshold(5)
                .addLoadingListItem(true)
                .build();

        //  STOP PAGINATION
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAddNewPost:
                /*Toast.makeText(this,"",Toast.LENGTH_LONG).show();*/
                Intent intent = new Intent(this,activity_add_new_post.class);
                startActivityForResult(intent,1);
              //  startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Rec_Activity.RESULT_OK){
                String result=data.getStringExtra("result");
            }
            if (resultCode == Rec_Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBtnPopupClick(Button btn, final int position) {
        Toast.makeText(getApplicationContext(),"Click",Toast.LENGTH_LONG).show();

        //Creating the instance of PopupMenu
        PopupMenu popup = new PopupMenu(getApplication(), btn);

        //Inflating the Popup using xml file
        popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

        //registering popup with OnMenuItemClickListener
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.itRemove){

                    // IF confirm Delete
                    chatDatas.remove(position);
                    adapter.notifyItemRemoved(position);
                }


                Toast.makeText(getApplication(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        popup.show();//showing popup menu
    }
}
