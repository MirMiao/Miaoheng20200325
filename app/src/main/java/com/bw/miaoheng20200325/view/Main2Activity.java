package com.bw.miaoheng20200325.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bw.miaoheng20200325.R;
import com.bw.miaoheng20200325.adapter.MlssAdapter;
import com.bw.miaoheng20200325.adapter.PzshAdapter;
import com.bw.miaoheng20200325.adapter.RxxpAdapter;
import com.bw.miaoheng20200325.base.BaseActivity;
import com.bw.miaoheng20200325.contract.IContract;
import com.bw.miaoheng20200325.entity.HomeDataEntity;
import com.bw.miaoheng20200325.presenter.Presenter;

import java.util.List;

public class Main2Activity extends BaseActivity<Presenter> implements IContract.IView {

    private RecyclerView rv_rxxp;
    private RecyclerView rv_mlsh;
    private RecyclerView rv_pzsh;

    @Override
    protected void initData() {
        presenter.getHomeData();
    }

    @Override
    protected void initView() {
        rv_rxxp = findViewById(R.id.rv_rxxp);
        rv_mlsh = findViewById(R.id.rv_mlsh);
        rv_pzsh = findViewById(R.id.rv_pzsh);
        rv_rxxp.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        rv_mlsh.setLayoutManager(new LinearLayoutManager(this));
        rv_pzsh.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected Presenter initPresenter() {
        return new Presenter();
    }

    @Override
    protected int bindLayoutid() {
        return R.layout.activity_main2;
    }

    @Override
    public void seccess(Object object) {
      if(object instanceof HomeDataEntity){
          Toast.makeText(this, ""+((HomeDataEntity) object).getMessage(), Toast.LENGTH_SHORT).show();
          List<HomeDataEntity.ResultBean.RxxpBean.CommodityListBean> commodityList = ((HomeDataEntity) object).getResult().getRxxp().getCommodityList();
          List<HomeDataEntity.ResultBean.MlssBean.CommodityListBeanXX> commodityList1 = ((HomeDataEntity) object).getResult().getMlss().getCommodityList();
          List<HomeDataEntity.ResultBean.PzshBean.CommodityListBeanX> commodityList2 = ((HomeDataEntity) object).getResult().getPzsh().getCommodityList();
          RxxpAdapter rxxpAdapter = new RxxpAdapter(this, commodityList);
          rv_rxxp.setAdapter(rxxpAdapter);
          MlssAdapter mlssAdapter = new MlssAdapter(this, commodityList1);
          rv_mlsh.setAdapter(mlssAdapter);
          PzshAdapter pzshAdapter = new PzshAdapter(this, commodityList2);
          rv_pzsh.setAdapter(pzshAdapter);

      }
    }

    @Override
    public void failur(Throwable throwable) {

    }
}
