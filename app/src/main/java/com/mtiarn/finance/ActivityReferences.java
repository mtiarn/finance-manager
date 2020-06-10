package com.mtiarn.finance;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mtiarn.finance.adapter.AdapterMenuItems;
import com.mtiarn.finance.model.Cabbage;
import com.mtiarn.finance.model.Category;
import com.mtiarn.finance.model.Department;
import com.mtiarn.finance.model.Location;
import com.mtiarn.finance.model.MenuItem;
import com.mtiarn.finance.model.Payee;
import com.mtiarn.finance.model.Product;
import com.mtiarn.finance.model.Project;
import com.mtiarn.finance.model.Sender;
import com.mtiarn.finance.model.SmsMarker;
import com.mtiarn.finance.utils.RequestCodes;
import com.mtiarn.finance.widgets.ToolbarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ActivityReferences extends ToolbarActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private Drawable getIcon(int id) {
        return ContextCompat.getDrawable(this, id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<MenuItem> menuItemList = new ArrayList<>();

        final Intent[] intent = new Intent[1];
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_category),
                getString(R.string.ent_categories),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Category());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 0));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_payes),
                getString(R.string.ent_payees),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Payee());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 1));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_currencies_gray),
                getString(R.string.ent_currencies),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Cabbage());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 2));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_sender),
                getString(R.string.ent_senders),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Sender());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 3));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_sms_gray),
                getString(R.string.ent_sms_markers),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityModelList.class);
                        intent[0].putExtra("model", new SmsMarker());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 3));
//        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_templates),
//                getString(R.string.ent_templates),
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        intent[0] = new Intent(ActivityReferences.this, ActivityModelList.class);
//                        intent[0].putExtra("model", new Template());
//                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
//                    }
//                }, 4));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_projects),
                getString(R.string.ent_projects),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Project());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 5));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_departments),
                getString(R.string.ent_departments),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Department());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 5));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_location_gray),
                getString(R.string.ent_locations),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityList.class);
                        intent[0].putExtra("model", new Location());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 6));
        menuItemList.add(new MenuItem(getIcon(R.drawable.ic_product_gray),
                getString(R.string.ent_products),
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent[0] = new Intent(ActivityReferences.this, ActivityModelList.class);
                        intent[0].putExtra("model", new Product());
                        ActivityReferences.this.startActivityForResult(intent[0], RequestCodes.REQUEST_CODE_VIEW_MODELS);
                    }
                }, 6));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        AdapterMenuItems adapter = new AdapterMenuItems(menuItemList);
        adapter.setHasStableIds(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_references;
    }

    @Override
    protected String getLayoutTitle() {
        return getString(R.string.ent_references);
    }
}
