// This file was generated by PermissionsDispatcher. Do not modify!
package com.mtiarn.finance;

import android.support.v4.app.ActivityCompat;
import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class ActivityMainPermissionsDispatcher {
  private static final int REQUEST_GETEXTERNALSTORAGEPERMISSION = 13;

  private static final String[] PERMISSION_GETEXTERNALSTORAGEPERMISSION = new String[] {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

  private static final int REQUEST_GETRECEIVESMSPERMISSION = 14;

  private static final String[] PERMISSION_GETRECEIVESMSPERMISSION = new String[] {"android.permission.RECEIVE_SMS"};

  private ActivityMainPermissionsDispatcher() {
  }

  static void getExternalStoragepermissionWithPermissionCheck(ActivityMain target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_GETEXTERNALSTORAGEPERMISSION)) {
      target.getExternalStoragepermission();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_GETEXTERNALSTORAGEPERMISSION)) {
        target.showRationaleForExStorage(new ActivityMainGetExternalStoragepermissionPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_GETEXTERNALSTORAGEPERMISSION, REQUEST_GETEXTERNALSTORAGEPERMISSION);
      }
    }
  }

  static void getReceiveSmsPermissionWithPermissionCheck(ActivityMain target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_GETRECEIVESMSPERMISSION)) {
      target.getReceiveSmsPermission();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_GETRECEIVESMSPERMISSION)) {
        target.showRationaleForReceiveSms(new ActivityMainGetReceiveSmsPermissionPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_GETRECEIVESMSPERMISSION, REQUEST_GETRECEIVESMSPERMISSION);
      }
    }
  }

  static void onRequestPermissionsResult(ActivityMain target, int requestCode, int[] grantResults) {
    switch (requestCode) {
      case REQUEST_GETEXTERNALSTORAGEPERMISSION:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.getExternalStoragepermission();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_GETEXTERNALSTORAGEPERMISSION)) {
          target.onExStorageNeverAskAgain();
        } else {
          target.onExStorageDenied();
        }
      }
      break;
      case REQUEST_GETRECEIVESMSPERMISSION:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.getReceiveSmsPermission();
      }
      break;
      default:
      break;
    }
  }

  private static final class ActivityMainGetExternalStoragepermissionPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityMain> weakTarget;

    private ActivityMainGetExternalStoragepermissionPermissionRequest(ActivityMain target) {
      this.weakTarget = new WeakReference<ActivityMain>(target);
    }

    @Override
    public void proceed() {
      ActivityMain target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_GETEXTERNALSTORAGEPERMISSION, REQUEST_GETEXTERNALSTORAGEPERMISSION);
    }

    @Override
    public void cancel() {
      ActivityMain target = weakTarget.get();
      if (target == null) return;
      target.onExStorageDenied();
    }
  }

  private static final class ActivityMainGetReceiveSmsPermissionPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityMain> weakTarget;

    private ActivityMainGetReceiveSmsPermissionPermissionRequest(ActivityMain target) {
      this.weakTarget = new WeakReference<ActivityMain>(target);
    }

    @Override
    public void proceed() {
      ActivityMain target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_GETRECEIVESMSPERMISSION, REQUEST_GETRECEIVESMSPERMISSION);
    }

    @Override
    public void cancel() {
    }
  }
}
