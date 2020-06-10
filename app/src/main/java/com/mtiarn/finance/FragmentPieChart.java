package com.mtiarn.finance;

import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.renderer.PieChartRenderer;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.mtiarn.finance.dao.AbstractDAO;
import com.mtiarn.finance.dao.BaseDAO;
import com.mtiarn.finance.interfaces.IAbstractModel;
import com.mtiarn.finance.managers.AbstractModelManager;
import com.mtiarn.finance.utils.BaseNode;
import com.mtiarn.finance.utils.CabbageFormatter;
import com.mtiarn.finance.utils.ColorUtils;
import com.mtiarn.finance.utils.FgLargeValuesFormatter;
import com.mtiarn.finance.utils.NormalValuesFormatter;
import com.mtiarn.finance.utils.ParcelableHelper;
import com.mtiarn.finance.utils.ScreenUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentPieChart extends Fragment implements OnChartValueSelectedListener {

    public static final String TAG = "FragmentPieChart";
    @BindView(R.id.pieChart)
    PieChart mPieChart;
    Unbinder unbinder;
    @BindView(R.id.fab)
    FloatingActionButton mFab;
    @BindView(R.id.textViewSelected)
    TextView mTextViewSelected;
    @BindView(R.id.imageViewColor)
    ImageView mImageViewColor;
    @BindView(R.id.fabLayout)
    LinearLayout mFabLayout;
    private FgLargeValuesFormatter largeValuesFormatter;
    private NormalValuesFormatter mormalValuesFormatter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
//        R.layout.fragment_pie_chart
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        unbinder = ButterKnife.bind(this, view);

        mFab.setOnClickListener(new EntityChartFabOnClickListener(mPieChart, getActivity()));

        setupPieChart();

        largeValuesFormatter = new FgLargeValuesFormatter();
        mormalValuesFormatter = new NormalValuesFormatter();

        return view;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        switch (item.getItemId()) {
            case R.id.action_toggle_percents:
                boolean showPercents = preferences.getBoolean(FgConst.PREF_SHOW_PIE_PERCENTS, true);
                preferences.edit().putBoolean(FgConst.PREF_SHOW_PIE_PERCENTS, !showPercents).apply();
                updateChart(false);
                return true;
            case R.id.action_toggle_lines:
                boolean showLines = preferences.getBoolean(FgConst.PREF_SHOW_PIE_LINES, true);
                preferences.edit().putBoolean(FgConst.PREF_SHOW_PIE_LINES, !showLines).apply();
                updateChart(false);
                return true;
//            case R.id.action_toggle_shrink_values:
//                boolean showShrinkLabels = preferences.getBoolean(FgConst.PREF_SHRINK_CHART_LABELS, true);
//                preferences.edit().putBoolean(FgConst.PREF_SHRINK_CHART_LABELS, !showShrinkLabels).apply();
//                updateChart(false);
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateChart(true);
    }

    private String formatValue(float value) {
        if (isShrinkValues()) {
            return largeValuesFormatter.makePretty(value);
        } else {
            return mormalValuesFormatter.getFormattedValue(value);
        }
    }

    private ValueFormatter getValueFormatter() {
        if (isShrinkValues()) {
            return largeValuesFormatter;
        } else {
            return mormalValuesFormatter;
        }
    }

    private boolean isShrinkValues() {
        return android.support.v7.preference.PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(FgConst.PREF_SHRINK_CHART_LABELS, true);
    }

    void updateChart(boolean animate) {
        ReportBuilder reportBuilder = ReportBuilder.getInstance(getActivity());
        long parentID = reportBuilder.getParentID();
        if (parentID < 0) {
            mPieChart.setCenterText("");
        } else {
            AbstractDAO dao = BaseDAO.getDAO(reportBuilder.getModelType(), getActivity());
            if (dao != null) {
                IAbstractModel model = dao.getModelById(parentID);
                mPieChart.setCenterText(model.getFullName());
            }
        }

        setData(reportBuilder.getEntitiesDataset(), animate);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setupPieChart() {
        mPieChart.setDescription("");
        mPieChart.setExtraOffsets(40, 10, 40, 5);

        mPieChart.setDragDecelerationFrictionCoef(0.95f);

        mPieChart.setDrawHoleEnabled(true);
        mPieChart.setHoleColor(ColorUtils.getBackgroundColor(getActivity()));
        mPieChart.setCenterTextColor(ColorUtils.getTextColor(getActivity()));

        mPieChart.setHoleRadius(50f);
        mPieChart.setTransparentCircleRadius(50f);

        mPieChart.setRotationAngle(0);
        mPieChart.setRotationEnabled(true);
        mPieChart.setHighlightPerTapEnabled(true);

        mPieChart.setOnChartValueSelectedListener(this);

        mPieChart.setRenderer(new FgPieChartRenderer(mPieChart, mPieChart.getAnimator(), mPieChart.getViewPortHandler()));
        mPieChart.getLegend().setEnabled(false);
    }

    private class FgPieChartRenderer extends PieChartRenderer {

        public FgPieChartRenderer(PieChart chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
            super(chart, animator, viewPortHandler);
        }

        @Override
        public void drawValues(Canvas c) {
            Paint.Style oldStyle = mValuePaint.getStyle();
            mValuePaint.setStyle(Paint.Style.STROKE);
            float oldStrokeWidth = mValuePaint.getStrokeWidth();
            mValuePaint.setStrokeWidth(ScreenUtils.dpToPx(3f, FGApplication.getContext()));
            int color1 = ColorUtils.getTextColor(getActivity());
            int color2 = ColorUtils.getTextInverseColor(getActivity());

            PieData data = mChart.getData();
            List<IPieDataSet> dataSets = data.getDataSets();

            for (int i = 0; i < dataSets.size(); i++) {
                IPieDataSet dataSet = dataSets.get(i);
                mValueLinePaint.setColor(ColorUtils.ContrastColor(dataSet.getValueLineColor()));

                int entryCount = dataSet.getEntryCount();
                for (int j = 0; j < entryCount; j++) {
                    dataSet.setValueTextColor(color2);
                }
            }

            super.drawValues(c);

            mValuePaint.setStyle(oldStyle);
            mValuePaint.setStrokeWidth(oldStrokeWidth);

            for (int i = 0; i < dataSets.size(); i++) {
                IPieDataSet dataSet = dataSets.get(i);
                mValueLinePaint.setColor(ColorUtils.ContrastColor(dataSet.getValueLineColor()));

                int entryCount = dataSet.getEntryCount();
                for (int j = 0; j < entryCount; j++) {
                    dataSet.setValueTextColor(color1);
                }
            }

            super.drawValues(c);
        }
    }

    private void setData(BaseNode tree, boolean animate) {
        ReportBuilder reportBuilder = ReportBuilder.getInstance(getActivity());
        if (reportBuilder.getActiveShowIndex() == ReportBuilder.SHOW_INCOME & tree.getModel().getIncome().compareTo(BigDecimal.ZERO) == 0) {
            mPieChart.clear();
            return;
        }

        if (reportBuilder.getActiveShowIndex() == ReportBuilder.SHOW_EXPENSE & tree.getModel().getExpense().compareTo(BigDecimal.ZERO) == 0) {
            mPieChart.clear();
            return;
        }

        ArrayList<Entry> yVals = new ArrayList<>();
        ArrayList<String> xVals = new ArrayList<>();
        ArrayList<IAbstractModel> models = new ArrayList<>();
        BigDecimal val;
        BigDecimal totalSum = BigDecimal.ZERO;
        int i = 0;
        for (BaseNode node : tree.getChildren()) {
            switch (reportBuilder.getActiveShowIndex()) {
                case ReportBuilder.SHOW_INCOME:
                    val = node.getModel().getIncome();
                    break;
                case ReportBuilder.SHOW_EXPENSE:
                    val = node.getModel().getExpense();
                    break;
                default:
                    val = BigDecimal.ZERO;
            }
            totalSum = totalSum.add(val);
            if (val.compareTo(BigDecimal.ZERO) != 0) {
                models.add(node.getModel());
            }
        }

        IAbstractModel rootDuplicate = (IAbstractModel) ParcelableHelper.immediateDeepCopy(tree.getModel());

        if (reportBuilder.getParentID() >= 0) {
            switch (reportBuilder.getActiveShowIndex()) {
                case ReportBuilder.SHOW_INCOME:
                    val = tree.getModel().getIncome().subtract(totalSum);
                    rootDuplicate.setIncome(val);
                    break;
                case ReportBuilder.SHOW_EXPENSE:
                    val = tree.getModel().getExpense().subtract(totalSum);
                    rootDuplicate.setExpense(val);
                    break;
                default:
                    val = BigDecimal.ZERO;
            }
            if (val.compareTo(BigDecimal.ZERO) != 0) {
                AbstractDAO dao = BaseDAO.getDAO(rootDuplicate.getModelType(), getActivity());
                rootDuplicate.setName(dao.getModelById(rootDuplicate.getID()).getName());
                models.add(rootDuplicate);
            }
        }

        switch (reportBuilder.getActiveShowIndex()) {
            case ReportBuilder.SHOW_INCOME:
                totalSum = tree.getModel().getIncome();
                break;
            case ReportBuilder.SHOW_EXPENSE:
                totalSum = tree.getModel().getExpense();
                break;
            default:
                totalSum = BigDecimal.ZERO;
        }

        if (models.isEmpty()) {
            mPieChart.clear();
            return;
        }

        BigDecimal total = reportBuilder.getActiveShowIndex() == ReportBuilder.SHOW_INCOME ? tree.getModel().getIncome() : tree.getModel().getExpense();

        BigDecimal v;
        for (int j = models.size() - 1; j >= 0; j--) {
            if (reportBuilder.getActiveShowIndex() == ReportBuilder.SHOW_INCOME) {
                v = models.get(j).getIncome();
            } else {
                v = models.get(j).getExpense();
            }
            if ((v.floatValue() / total.floatValue()) < 0.005) {
                models.remove(j);
            }
        }

        ArrayList<IAbstractModel> models1 = new ArrayList<>();
        while (!models.isEmpty()) {
            models1.add(models.get(0));
            models.remove(0);
            if (!models.isEmpty()) {
                models1.add(models.get(models.size() - 1));
                models.remove(models.size() - 1);
            }
        }

        for (IAbstractModel model : models1) {
            if (reportBuilder.getActiveShowIndex() == ReportBuilder.SHOW_INCOME) {
                v = model.getIncome();
            } else {
                v = model.getExpense();
            }
            Entry pieEntry = new Entry(v.floatValue(), i++);
            pieEntry.setData(model);
            yVals.add(pieEntry);
            xVals.add(model.toString());
        }

        PieDataSet dataSet = new PieDataSet(yVals, "");
        dataSet.setSliceSpace(0f);
        dataSet.setValueTextColor(ColorUtils.getTextColor(getActivity()));
//        dataSet.setSelectionShift(5f);
        if (PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(FgConst.PREF_SHOW_PIE_LINES, true)) {
            dataSet.setValueLinePart1OffsetPercentage(80.f);
            dataSet.setValueLinePart1Length(0.6f);
            dataSet.setValueLinePart2Length(0.1f);
            dataSet.setValueLineVariableLength(true);
            dataSet.setValueLineColor(ColorUtils.getTextColor(getActivity()));
            dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            mPieChart.setExtraOffsets(40, 10, 40, 5);
        } else {
            dataSet.setXValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
            dataSet.setYValuePosition(PieDataSet.ValuePosition.INSIDE_SLICE);
            mPieChart.setExtraOffsets(5, 5, 5, 5);
        }

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS) colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS) colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS) colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS) colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(xVals, dataSet);
        if (PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(FgConst.PREF_SHOW_PIE_PERCENTS, true)) {
            mPieChart.setUsePercentValues(true);
            data.setValueFormatter(new PercentFormatter());
        } else {
            mPieChart.setUsePercentValues(false);
            data.setValueFormatter(getValueFormatter());
        }
        data.setValueTextSize(11f);
        mPieChart.setData(data);
        String s = String.format("%s:\n%s", getString(R.string.ent_total), formatValue(totalSum.floatValue()));
        mPieChart.setCenterText(s);

        mImageViewColor.setVisibility(View.INVISIBLE);
        mTextViewSelected.setVisibility(View.INVISIBLE);

        if (animate) {
            mPieChart.animateY(1000, Easing.EasingOption.EaseInOutQuad);
            mFabLayout.setVisibility(View.GONE);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (mPieChart != null) {
                        mPieChart.highlightValues(null);
                    }
                }
            }, 1000);

        } else {
            mPieChart.invalidate();
            if (mPieChart.getHighlighted() == null) {
                mFabLayout.setVisibility(View.GONE);
            } else {
                mFabLayout.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        ReportBuilder reportBuilder = ReportBuilder.getInstance(getActivity());
        IAbstractModel model = (IAbstractModel) e.getData();
        if (reportBuilder.getParentID() != model.getID() && AbstractModelManager.getAllChildren(model, getActivity()).size() > 0) {
            reportBuilder.setParentID(model.getID());
            updateChart(true);
            return;
        }
        CabbageFormatter cabbageFormatter = null;
        try {
            cabbageFormatter = new CabbageFormatter(reportBuilder.getActiveCabbage());
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String s = String.format("%s %s", e.getData().toString(), cabbageFormatter.format(new BigDecimal(e.getVal())));
        GradientDrawable bgShape = (GradientDrawable) mImageViewColor.getBackground();
        IPieDataSet dataSet = mPieChart.getData().getDataSet();
        bgShape.setColor(dataSet.getColor(dataSet.getEntryIndex(e)));
        mTextViewSelected.setText(s);

        mFabLayout.setVisibility(View.VISIBLE);
        mImageViewColor.setVisibility(View.VISIBLE);
        mTextViewSelected.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNothingSelected() {
        mFabLayout.setVisibility(View.GONE);
        mImageViewColor.setVisibility(View.INVISIBLE);
        mTextViewSelected.setVisibility(View.INVISIBLE);
    }
}
