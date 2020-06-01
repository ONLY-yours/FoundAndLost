package com.example.foundandlost;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.foundandlost.adapter.ItemAdapter;
import com.example.foundandlost.base.BaseActivity;
import com.example.foundandlost.base.FoundActivity;
import com.example.foundandlost.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class LostActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView rv1;

    private Button btnLost;
    private Button btnFound;
    private ImageView ivTvClear;

    private View btnSearch;

    private EditText etSearch;

    private List<ItemBean> listbean=new ArrayList<ItemBean>(10);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lost);

        initview();
//        createMessage(10,"");
    }

    void initview(){
        btnLost=findViewById(R.id.btn_lost);
        btnFound=findViewById(R.id.btn_found);

        btnFound.setOnClickListener(this);
        btnLost.setOnClickListener(this);

        ivTvClear=findViewById(R.id.iv_tvclear);
        ivTvClear.setOnClickListener(this);

        etSearch=findViewById(R.id.et_search);


        btnSearch=findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);


        rv1=findViewById(R.id.rv1);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv1.setLayoutManager(manager);

        rv1.setAdapter(new ItemAdapter());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_search:
                createMessage(10,""+etSearch.getText().toString());
                break;
            case R.id.iv_tvclear:
                etSearch.setText("");
                break;

            case R.id.btn_lost:
                break;
            case R.id.btn_found:

                startActivity(FoundActivity.class);
                break;
        }
    }


    //用于添加假数据
    void createMessage(int size,String foundWords){
        listbean.clear();
        for (int i =0;i<size;i++){
            ItemBean itembean = new ItemBean();
            if (i%4==0){
                itembean.setName("灰色手表");
                itembean.setTime("时间：5月30日 18：30");
                itembean.setDescribe("详细描述： 于下午丢失于操场，\n请有缘人捡到归还，谢谢！");
                itembean.setIdnumber(0);
            }else if (i%4==1){
                itembean.setName("寝室钥匙");
                itembean.setTime("时间：6月1日 8：50");
                itembean.setDescribe("详细描述：本人于早上晨跑时丢\n失寝室钥匙一串，有缘人捡到请\n归还");
                itembean.setIdnumber(1);
            }else if (i%4==2){
                itembean.setName("mc周边T恤");
                itembean.setTime("时间：6月30日 20：50");
                itembean.setDescribe("详细描述：本人于30日晚打球时丢\n失T恤一件，有缘人捡到请\n归还");
                itembean.setIdnumber(2);

            }else if (i%4==3){
                itembean.setName("饭卡");
                itembean.setTime("时间：6月30日 20：50");
                itembean.setDescribe("详细描述：本人于2日中午吃饭时丢\n失校园卡一张，有缘人捡到请\n归还");
                itembean.setIdnumber(3);
            }
            if (itembean.getName().indexOf(foundWords)>0 || itembean.getDescribe().indexOf(foundWords)>0
                    || itembean.getTime().indexOf(foundWords)>0){
                listbean.add(itembean);
            }
        }
        rv1.setAdapter(new ItemAdapter(listbean));
    }

}
