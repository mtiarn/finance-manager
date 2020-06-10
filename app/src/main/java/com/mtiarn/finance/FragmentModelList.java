package com.mtiarn.finance;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mtiarn.finance.adapter.AdapterAbstractModel;
import com.mtiarn.finance.dao.AbstractDAO;
import com.mtiarn.finance.dao.BaseDAO;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.managers.DebtsManager;
import com.mtiarn.finance.managers.FilterManager;
import com.mtiarn.finance.managers.ProductManager;
import com.mtiarn.finance.managers.SimpleDebtManager;
import com.mtiarn.finance.managers.SmsMarkerManager;
import com.mtiarn.finance.managers.TransactionManager;
import com.mtiarn.finance.model.Credit;
import com.mtiarn.finance.model.Events;
import com.mtiarn.finance.model.Product;
import com.mtiarn.finance.model.SimpleDebt;
import com.mtiarn.finance.model.SmsMarker;
import com.mtiarn.finance.model.Template;
import com.mtiarn.finance.utils.FabMenuController;
import com.mtiarn.finance.utils.SmsParser;
import com.mtiarn.finance.widgets.ContextMenuRecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentModelList extends Fragment {

    @BindView(R.id.recycler_view)
    ContextMenuRecyclerView mRecyclerView;
    @BindView(R.id.buttonAddAccountMarker)
    FloatingActionButton mButtonAddAccountMarker;
    @BindView(R.id.buttonAddCabbageMarker)
    FloatingActionButton mButtonAddCabbageMarker;
    @BindView(R.id.buttonAddTrTypeMarker)
    FloatingActionButton mButtonAddTrTypeMarker;
    @BindView(R.id.buttonAddPayeeMarker)
    FloatingActionButton mButtonAddPayeeMarker;
    @BindView(R.id.buttonAddIgnoreMarker)
    FloatingActionButton mButtonAddIgnoreMarker;
    @BindView(R.id.fabBGLayout)
    View mFabBGLayout;
    @BindView(R.id.buttonAddAccountMarkerLayout)
    LinearLayout mButtonAddAccountMarkerLayout;
    @BindView(R.id.buttonAddCabbageMarkerLayout)
    LinearLayout mButtonAddCabbageMarkerLayout;
    @BindView(R.id.buttonAddTrTypeMarkerLayout)
    LinearLayout mButtonAddTrTypeMarkerLayout;
    @BindView(R.id.buttonAddPayeeMarkerLayout)
    LinearLayout mButtonAddPayeeMarkerLayout;
    @BindView(R.id.buttonAddIgnoreMarkerLayout)
    LinearLayout mButtonAddIgnoreMarkerLayout;
    @BindView(R.id.fabMenuButtonRoot)
    FloatingActionButton mFabMenuButtonRoot;
    @BindView(R.id.fabMenuButtonRootLayout)
    LinearLayout mFabMenuButtonRootLayout;
    private IAbstractModel mInputModel;
    private ModelListEventListener mModelListEventListener;
    private AdapterAbstractModel adapter;
    Unbinder unbinder;
    FabMenuController mFabMenuController;

    void setmFilter(String mFilter) {
        this.mFilter = mFilter;
    }

    private String mFilter = "";

    public static FragmentModelList newInstance(IAbstractModel model, int requestCode) {
//        R.layout.fragment_model_list
        FragmentModelList frag = new FragmentModelList();
        Bundle args = new Bundle();
        args.putParcelable("model", model);
        args.putInt("requestCode", requestCode);
        frag.setArguments(args);

        return frag;
    }

    void setmModelListEventListener(ModelListEventListener mModelListEventListener) {
        this.mModelListEventListener = mModelListEventListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_model_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        mInputModel = getArguments().getParcelable("model");

        adapter = new AdapterAbstractModel(getActivity());

        adapter.setmAbstractModelEventsListener(new AdapterAbstractModel.AdapterAbstractModelEventsListener() {
            @Override
            public void OnAbstractModelItemClick(IAbstractModel abstractModel) {
                if (mModelListEventListener != null) {
                    mModelListEventListener.OnModelClick(abstractModel);
                }
            }
        });

        mRecyclerView.setAdapter(adapter);
        registerForContextMenu(mRecyclerView);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        registerForContextMenu(mRecyclerView);


        switch (mInputModel.getModelType()) {
            case IAbstractModel.MODEL_TYPE_CREDIT:
            case IAbstractModel.MODEL_TYPE_SIMPLEDEBT:
            case IAbstractModel.MODEL_TYPE_TEMPLATE:
            case IAbstractModel.MODEL_TYPE_PRODUCT:
                mFabMenuButtonRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FragmentModelList.this.editModel(null);
                    }
                });
                break;
            case IAbstractModel.MODEL_TYPE_SMSMARKER:
                initFabMenu();
                break;
        }
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (Math.abs(dy) > 4) {
                    if (dy > 0) {
                        mFabMenuButtonRootLayout.setVisibility(View.GONE);
                    } else {
                        mFabMenuButtonRootLayout.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateRecyclerView();
    }

    private void initFabMenu() {
        mFabMenuController = new FabMenuController(mFabMenuButtonRoot, mFabBGLayout, getActivity(),
                mButtonAddIgnoreMarkerLayout, mButtonAddPayeeMarkerLayout, mButtonAddTrTypeMarkerLayout,
                mButtonAddCabbageMarkerLayout, mButtonAddAccountMarkerLayout);

        FabMenuOnClickListener fabMenuOnClickListener = new FabMenuOnClickListener();

        mButtonAddAccountMarker.setOnClickListener(fabMenuOnClickListener);
        mButtonAddCabbageMarker.setOnClickListener(fabMenuOnClickListener);
        mButtonAddTrTypeMarker.setOnClickListener(fabMenuOnClickListener);
        mButtonAddPayeeMarker.setOnClickListener(fabMenuOnClickListener);
        mButtonAddIgnoreMarker.setOnClickListener(fabMenuOnClickListener);
    }

    private class FabMenuOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int markerType;
            switch (view.getId()) {
                case R.id.buttonAddAccountMarker:
                    markerType = SmsParser.MARKER_TYPE_ACCOUNT;
                    break;
                case R.id.buttonAddCabbageMarker:
                    markerType = SmsParser.MARKER_TYPE_CABBAGE;
                    break;
                case R.id.buttonAddTrTypeMarker:
                    markerType = SmsParser.MARKER_TYPE_TRTYPE;
                    break;
                case R.id.buttonAddPayeeMarker:
                    markerType = SmsParser.MARKER_TYPE_PAYEE;
                    break;
                case R.id.buttonAddIgnoreMarker:
                    markerType = SmsParser.MARKER_TYPE_IGNORE;
                    break;
                default:
                    markerType = SmsParser.MARKER_TYPE_ACCOUNT;
            }
            FragmentModelList.this.editModel(new SmsMarker(-1, markerType, "", ""));
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.context_menu_models, menu);
        if (!(mInputModel.getModelType() == IAbstractModel.MODEL_TYPE_SIMPLEDEBT |
                mInputModel.getModelType() == IAbstractModel.MODEL_TYPE_CREDIT)) {
            menu.findItem(R.id.action_show_transactions).setVisible(false);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (getUserVisibleHint()) {
            ContextMenuRecyclerView.RecyclerContextMenuInfo info = (ContextMenuRecyclerView.RecyclerContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.action_edit: {
                    AbstractDAO abstractDAO = BaseDAO.getDAO(mInputModel.getModelType(), getActivity());
                    if (abstractDAO != null) {
                        IAbstractModel abstractModel = abstractDAO.getModelById(info.id);
                        if (abstractModel != null) {
                            editModel(abstractModel);
                        }
                    }
                    break;
                }
                case R.id.action_delete: {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(R.string.ttl_confirm_action);
                    switch (mInputModel.getModelType()) {
                        case IAbstractModel.MODEL_TYPE_SMSMARKER: {
                            builder.setMessage(R.string.msg_delete_sms_marker_confirmation);
                            break;
                        }
                        case IAbstractModel.MODEL_TYPE_CREDIT: {
                            builder.setMessage(R.string.ttl_delete_credit_confirmation);
                            break;
                        }
                        case IAbstractModel.MODEL_TYPE_SIMPLEDEBT: {
                            builder.setMessage(R.string.ttl_delete_debt_confirmation);
                            break;
                        }
                        case IAbstractModel.MODEL_TYPE_TEMPLATE: {
                            builder.setMessage(R.string.ttl_delete_template_confirmation);
                            break;
                        }
                        case IAbstractModel.MODEL_TYPE_PRODUCT: {
                            builder.setMessage(R.string.msg_delete_product_confirmation);
                            break;
                        }
                    }

                    OnDeleteModelDialogOkClickListener clickListener = new OnDeleteModelDialogOkClickListener(info);
                    // Set up the buttons
                    builder.setPositiveButton("OK", clickListener);
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    builder.show();
                    break;
                }
                case R.id.action_show_transactions:
                    AbstractDAO dao;
                    IAbstractModel model;
                    dao = BaseDAO.getDAO(mInputModel.getModelType(), getActivity());
                    if (dao != null) {
                        model = dao.getModelById(info.id);
                        Intent intent = new Intent(getActivity(), ActivityTransactions.class);
                        if (model.getModelType() == IAbstractModel.MODEL_TYPE_CREDIT) {
                            model = DebtsManager.getAccount((Credit) model, getActivity());
                        }
                        intent.putParcelableArrayListExtra("filter_list", FilterManager.createFilterList(model.getModelType(), model.getID()));
                        intent.putExtra("caption", model.getFullName());
                        intent.putExtra(FgConst.HIDE_FAB, true);
                        intent.putExtra(FgConst.LOCK_SLIDINGUP_PANEL, true);
                        startActivity(intent);
                    }
                    break;
            }
            return true;
        } else
            return false;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @SuppressWarnings("unchecked")
    private void loadData() throws Exception {
        AbstractDAO abstractDAO = BaseDAO.getDAO(mInputModel.getModelType(), getActivity());
        if (abstractDAO != null) {
            List<IAbstractModel> models = (List<IAbstractModel>) abstractDAO.getAllModels();
            if (mInputModel.getModelType() == IAbstractModel.MODEL_TYPE_SIMPLEDEBT) {
                long cabbageID = getActivity().getIntent().getLongExtra("cabbageID", -1);
                if (cabbageID >= 0) {
                    SimpleDebt debt;
                    for (int i = models.size() - 1; i >= 0; i--) {
                        debt = (SimpleDebt) models.get(i);
                        if (debt.getCabbageID() != cabbageID || !debt.isActive()) {
                            models.remove(i);
                        }
                    }
                }
            }
            if (mInputModel.getModelType() == IAbstractModel.MODEL_TYPE_SMSMARKER) {
                for (IAbstractModel model : models) {
                    ((SmsMarker) model).setSearchString(SmsMarkerManager.loadNames((SmsMarker) model, getActivity()));
                }
            }
            adapter.setmModelList(models);
        }


        adapter.applyFilter(mFilter);
        adapter.notifyDataSetChanged();
    }

    void updateRecyclerView() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                try {
                    FragmentModelList.this.loadData();
                } catch (Exception e) {
                    //get items error
                }
            }
        });
    }

    private void editModel(IAbstractModel abstractModel) {
        switch (mInputModel.getModelType()) {
            case IAbstractModel.MODEL_TYPE_SMSMARKER: {
                if (abstractModel == null) {
                    abstractModel = new SmsMarker();
                }
                SmsMarkerManager.showEditdialog((SmsMarker) abstractModel, getActivity().getSupportFragmentManager(),
                        null, getActivity());
                mFabMenuController.closeFABMenu();
                break;
            }
            case IAbstractModel.MODEL_TYPE_CREDIT: {
                if (abstractModel == null) {
                    abstractModel = new Credit();
                }
                Intent intent = new Intent(getActivity(), ActivityEditCredit.class);
                intent.putExtra("credit", abstractModel);
                startActivity(intent);
                break;
            }
            case IAbstractModel.MODEL_TYPE_SIMPLEDEBT: {
                if (abstractModel == null) {
                    abstractModel = new SimpleDebt();
                }
                SimpleDebtManager.showEditDialog((SimpleDebt) abstractModel, getActivity().getSupportFragmentManager(), getActivity());
                break;
            }
            case IAbstractModel.MODEL_TYPE_PRODUCT: {
                if (abstractModel == null) {
                    abstractModel = new Product();
                }
                ProductManager.showEditDialog((Product) abstractModel, getActivity());
                break;
            }
            case IAbstractModel.MODEL_TYPE_TEMPLATE: {
                if (abstractModel == null) {
                    abstractModel = new Template();
                }
                Intent intent = new Intent(getActivity(), ActivityEditTransaction.class);
                intent.putExtra("template", abstractModel);
                intent.putExtra("transaction", TransactionManager.templateToTransaction((Template) abstractModel, getActivity()));
                intent.putExtra("focus_to_amount", true);
                startActivity(intent);
//                fabMenu.close(true);
                break;
            }
        }
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(Events.EventOnModelChanged event) {
        if (mInputModel.getModelType() == event.getModelType()) {
            updateRecyclerView();
        }
    }

    interface ModelListEventListener {
        void OnModelClick(IAbstractModel abstractModel);
    }

    private class OnDeleteModelDialogOkClickListener implements DialogInterface.OnClickListener {
        private final ContextMenuRecyclerView.RecyclerContextMenuInfo info;

        OnDeleteModelDialogOkClickListener(ContextMenuRecyclerView.RecyclerContextMenuInfo info) {
            this.info = info;
        }

        @Override
        public void onClick(DialogInterface dialog, int which) {
            AbstractDAO abstractDAO = BaseDAO.getDAO(mInputModel.getModelType(), getActivity());
            if (abstractDAO != null) {
                abstractDAO.deleteModel(abstractDAO.getModelById(info.id), true, getActivity());
            }
        }
    }
}
