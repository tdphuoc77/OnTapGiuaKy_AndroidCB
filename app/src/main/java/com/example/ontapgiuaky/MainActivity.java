package com.example.ontapgiuaky;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<ItemChar> list;
    private ListCharAdapter mApdater;
    private RecyclerView recyclerView;
    private int Amount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView();

    }

    public void gridView(){
        list= new ArrayList<ItemChar>();
        list.add(new ItemChar(R.drawable.images_2,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__2__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__4__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__5__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__5__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__5__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__5__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));
        list.add(new ItemChar(R.drawable.images__5__1,"Matteo Armchair",250,"ONE OF A KIND YACHT  INTERIOR IS MADE TO FIT YOUR BOAT TO MAKE IT AS COMFORTABLE AS YOUR HOUSE"));


        recyclerView= findViewById(R.id.recyclerView);

        mApdater= new ListCharAdapter(this, list);
        recyclerView.setAdapter(mApdater);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mApdater.setOnItemClickListener(new ListCharAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeScreen(position);
            }
        });
    }

    public  void changeScreen(int position){
        ItemChar itemChar=list.get(position);
        setContentView(R.layout.layoutaddchar);
        ImageView img= findViewById(R.id.imgProduct);
        TextView tvName=findViewById(R.id.tvNameProduct);
        TextView tvPrice= findViewById(R.id.tvPriceProduct);
        TextView tvContent= findViewById(R.id.tvContent);
        img.setImageResource(itemChar.getImg());
        tvName.setText(itemChar.getTvName()+"");
        tvPrice.setText("$"+itemChar.getTvPrice()+"");
        tvContent.setText(itemChar.getTvMoTa());
        TextView tvAmount= findViewById(R.id.tvAmount);
        ImageView imgAdd=findViewById(R.id.imgAdd);
        ImageView imgMinus=findViewById(R.id.imgMinus);
         imgAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Amount+=1;
                 tvAmount.setText(Amount+" ");
             }
         });
        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Amount>1)
                Amount-=1;
                tvAmount.setText(" " +Amount+" ");
            }
        });

        Button btnAddCard=findViewById(R.id.btnAdd);
        btnAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.layoutc);
                ImageView imgItem= findViewById(R.id.imgItem);
                TextView tvNameItem= findViewById(R.id.tvNameitem);
                TextView tvPriceItem= findViewById(R.id.tvPriceItem);
                TextView tvAmountItem= findViewById(R.id.tvAmountt);
                TextView tvProvisional= findViewById(R.id.tvProvisional);
                TextView tvTotal= findViewById(R.id.tvTotal);
                ImageView btnAddItem= findViewById(R.id.btnAddItem);
                ImageView btnMinusItem= findViewById(R.id.btnMinusItem);

                imgItem.setImageResource(itemChar.getImg());
                tvNameItem.setText(itemChar.getTvName()+"");
                tvPriceItem.setText("$"+itemChar.getTvPrice());
                tvAmountItem.setText(Amount+"");
                tvProvisional.setText("$"+itemChar.getTvPrice()*Amount);
                tvTotal.setText("$"+itemChar.getTvPrice()*Amount);


                btnAddItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Amount+=1;
                        tvAmountItem.setText(""+Amount);
                        tvProvisional.setText("$"+itemChar.getTvPrice()*Amount);
                        tvTotal.setText("$"+itemChar.getTvPrice()*Amount);
                    }
                });

                btnMinusItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(Amount>0){
                            Amount=Amount-1;
                            tvAmountItem.setText(""+Amount);
                            tvProvisional.setText("$"+itemChar.getTvPrice()*Amount);
                            tvTotal.setText("$"+itemChar.getTvPrice()*Amount);
                        }

                    }
                });
            }
        });
    }
}