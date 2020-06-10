// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityImportCSVAdvanced_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityImportCSVAdvanced target;

  private View view2131296470;

  private View view2131296606;

  private View view2131296615;

  @UiThread
  public ActivityImportCSVAdvanced_ViewBinding(ActivityImportCSVAdvanced target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityImportCSVAdvanced_ViewBinding(final ActivityImportCSVAdvanced target,
      View source) {
    super(target, source);

    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.editTextFileName, "field 'editTextFileName' and method 'OnSelectFileClick'");
    target.editTextFileName = Utils.castView(view, R.id.editTextFileName, "field 'editTextFileName'", EditText.class);
    view2131296470 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnSelectFileClick();
      }
    });
    target.progressbar = Utils.findRequiredViewAsType(source, R.id.progressbar, "field 'progressbar'", ProgressBar.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.recycler_view, "field 'mRecyclerView'", RecyclerView.class);
    target.mTextView3 = Utils.findRequiredViewAsType(source, R.id.textView3, "field 'mTextView3'", TextView.class);
    target.mLayoutRW = Utils.findRequiredViewAsType(source, R.id.layoutRW, "field 'mLayoutRW'", LinearLayout.class);
    target.mTextViewSkipLines = Utils.findRequiredViewAsType(source, R.id.textViewSkipLines, "field 'mTextViewSkipLines'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imageButtonDec, "field 'mImageButtonDec' and method 'OnChangeSkipLinesClick'");
    target.mImageButtonDec = Utils.castView(view, R.id.imageButtonDec, "field 'mImageButtonDec'", ImageButton.class);
    view2131296606 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnChangeSkipLinesClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.imageButtonInc, "field 'mImageButtonInc' and method 'OnChangeSkipLinesClick'");
    target.mImageButtonInc = Utils.castView(view, R.id.imageButtonInc, "field 'mImageButtonInc'", ImageButton.class);
    view2131296615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.OnChangeSkipLinesClick(p0);
      }
    });
    target.mTextInputLayoutLines = Utils.findRequiredViewAsType(source, R.id.textInputLayoutLines, "field 'mTextInputLayoutLines'", TextInputLayout.class);
    target.mSwitchCompatSkipDuplicates = Utils.findRequiredViewAsType(source, R.id.switchCompatSkipDuplicates, "field 'mSwitchCompatSkipDuplicates'", SwitchCompat.class);
  }

  @Override
  public void unbind() {
    ActivityImportCSVAdvanced target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextFileName = null;
    target.progressbar = null;
    target.mRecyclerView = null;
    target.mTextView3 = null;
    target.mLayoutRW = null;
    target.mTextViewSkipLines = null;
    target.mImageButtonDec = null;
    target.mImageButtonInc = null;
    target.mTextInputLayoutLines = null;
    target.mSwitchCompatSkipDuplicates = null;

    view2131296470.setOnClickListener(null);
    view2131296470 = null;
    view2131296606.setOnClickListener(null);
    view2131296606 = null;
    view2131296615.setOnClickListener(null);
    view2131296615 = null;

    super.unbind();
  }
}
