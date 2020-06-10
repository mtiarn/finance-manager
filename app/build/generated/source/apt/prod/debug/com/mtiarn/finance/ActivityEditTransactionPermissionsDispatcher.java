// This file was generated by PermissionsDispatcher. Do not modify!
package com.mtiarn.finance;

import android.support.v4.app.ActivityCompat;
import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class ActivityEditTransactionPermissionsDispatcher {
  private static final int REQUEST_STARTDETECTCOORDS = 5;

  private static final String[] PERMISSION_STARTDETECTCOORDS = new String[] {"android.permission.ACCESS_FINE_LOCATION","android.permission.ACCESS_COARSE_LOCATION"};

  private ActivityEditTransactionPermissionsDispatcher() {
  }

  static void startDetectCoordsWithPermissionCheck(ActivityEditTransaction target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_STARTDETECTCOORDS)) {
      target.startDetectCoords();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_STARTDETECTCOORDS)) {
        target.showRationaleForContact(new ActivityEditTransactionStartDetectCoordsPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_STARTDETECTCOORDS, REQUEST_STARTDETECTCOORDS);
      }
    }
  }

  static void onRequestPermissionsResult(ActivityEditTransaction target, int requestCode,
      int[] grantResults) {
    switch (requestCode) {
      case REQUEST_STARTDETECTCOORDS:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.startDetectCoords();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_STARTDETECTCOORDS)) {
          target.onLocationNeverAskAgain();
        } else {
          target.onLocationDenied();
        }
      }
      break;
      default:
      break;
    }
  }

  private static final class ActivityEditTransactionStartDetectCoordsPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityEditTransaction> weakTarget;

    private ActivityEditTransactionStartDetectCoordsPermissionRequest(ActivityEditTransaction target) {
      this.weakTarget = new WeakReference<ActivityEditTransaction>(target);
    }

    @Override
    public void proceed() {
      ActivityEditTransaction target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_STARTDETECTCOORDS, REQUEST_STARTDETECTCOORDS);
    }

    @Override
    public void cancel() {
      ActivityEditTransaction target = weakTarget.get();
      if (target == null) return;
      target.onLocationDenied();
    }
  }
}
