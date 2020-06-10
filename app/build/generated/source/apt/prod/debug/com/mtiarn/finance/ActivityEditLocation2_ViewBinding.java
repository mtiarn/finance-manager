// Generated code from Butter Knife. Do not modify!
package com.mtiarn.finance;

import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.airbnb.android.airmapview.AirMapView;
import com.mtiarn.finance.widgets.ToolbarActivity_ViewBinding;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivityEditLocation2_ViewBinding extends ToolbarActivity_ViewBinding {
  private ActivityEditLocation2 target;

  private View view2131296377;

  @UiThread
  public ActivityEditLocation2_ViewBinding(ActivityEditLocation2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivityEditLocation2_ViewBinding(final ActivityEditLocation2 target, View source) {
    super(target, source);

    this.target = target;

    View view;
    target.editTextName = Utils.findRequiredViewAsType(source, R.id.editTextName, "field 'editTextName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.buttonSaveLocation, "field 'mButtonSaveLocation' and method 'onSaveClick'");
    target.mButtonSaveLocation = Utils.castView(view, R.id.buttonSaveLocation, "field 'mButtonSaveLocation'", Button.class);
    view2131296377 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onSaveClick();
      }
    });
    target.map = Utils.findRequiredViewAsType(source, R.id.map, "field 'map'", AirMapView.class);
  }

  @Override
  public void unbind() {
    ActivityEditLocation2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.editTextName = null;
    target.mButtonSaveLocation = null;
    target.map = null;

    view2131296377.setOnClickListener(null);
    view2131296377 = null;

    super.unbind();
  }
}
