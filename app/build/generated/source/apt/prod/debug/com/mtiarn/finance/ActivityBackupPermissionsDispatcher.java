// This file was generated by PermissionsDispatcher. Do not modify!
package com.mtiarn.finance;

import android.support.v4.app.ActivityCompat;
import java.lang.Override;
import java.lang.String;
import java.lang.ref.WeakReference;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.PermissionUtils;

final class ActivityBackupPermissionsDispatcher {
  private static final int REQUEST_BACKUPDB = 0;

  private static final String[] PERMISSION_BACKUPDB = new String[] {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

  private static final int REQUEST_CHECKPERMISSIONS = 1;

  private static final String[] PERMISSION_CHECKPERMISSIONS = new String[] {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

  private static final int REQUEST_RESTOREDB = 2;

  private static final String[] PERMISSION_RESTOREDB = new String[] {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

  private static final int REQUEST_RESTOREDBFROMDROPBOX = 3;

  private static final String[] PERMISSION_RESTOREDBFROMDROPBOX = new String[] {"android.permission.READ_EXTERNAL_STORAGE","android.permission.WRITE_EXTERNAL_STORAGE"};

  private ActivityBackupPermissionsDispatcher() {
  }

  static void backupDBWithPermissionCheck(ActivityBackup target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_BACKUPDB)) {
      target.backupDB();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_BACKUPDB)) {
        target.showRationaleForContact(new ActivityBackupBackupDBPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_BACKUPDB, REQUEST_BACKUPDB);
      }
    }
  }

  static void restoreDBWithPermissionCheck(ActivityBackup target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_RESTOREDB)) {
      target.restoreDB();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_RESTOREDB)) {
        target.showRationaleForContact(new ActivityBackupRestoreDBPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_RESTOREDB, REQUEST_RESTOREDB);
      }
    }
  }

  static void restoreDBFromDropboxWithPermissionCheck(ActivityBackup target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_RESTOREDBFROMDROPBOX)) {
      target.restoreDBFromDropbox();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_RESTOREDBFROMDROPBOX)) {
        target.showRationaleForContact(new ActivityBackupRestoreDBFromDropboxPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_RESTOREDBFROMDROPBOX, REQUEST_RESTOREDBFROMDROPBOX);
      }
    }
  }

  static void checkPermissionsWithPermissionCheck(ActivityBackup target) {
    if (PermissionUtils.hasSelfPermissions(target, PERMISSION_CHECKPERMISSIONS)) {
      target.checkPermissions();
    } else {
      if (PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_CHECKPERMISSIONS)) {
        target.showRationaleForContact(new ActivityBackupCheckPermissionsPermissionRequest(target));
      } else {
        ActivityCompat.requestPermissions(target, PERMISSION_CHECKPERMISSIONS, REQUEST_CHECKPERMISSIONS);
      }
    }
  }

  static void onRequestPermissionsResult(ActivityBackup target, int requestCode,
      int[] grantResults) {
    switch (requestCode) {
      case REQUEST_BACKUPDB:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.backupDB();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_BACKUPDB)) {
          target.onCameraNeverAskAgain();
        } else {
          target.onCameraDenied();
        }
      }
      break;
      case REQUEST_RESTOREDB:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.restoreDB();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_RESTOREDB)) {
          target.onCameraNeverAskAgain();
        } else {
          target.onCameraDenied();
        }
      }
      break;
      case REQUEST_RESTOREDBFROMDROPBOX:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.restoreDBFromDropbox();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_RESTOREDBFROMDROPBOX)) {
          target.onCameraNeverAskAgain();
        } else {
          target.onCameraDenied();
        }
      }
      break;
      case REQUEST_CHECKPERMISSIONS:
      if (PermissionUtils.verifyPermissions(grantResults)) {
        target.checkPermissions();
      } else {
        if (!PermissionUtils.shouldShowRequestPermissionRationale(target, PERMISSION_CHECKPERMISSIONS)) {
          target.onCameraNeverAskAgain();
        } else {
          target.onCameraDenied();
        }
      }
      break;
      default:
      break;
    }
  }

  private static final class ActivityBackupBackupDBPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityBackup> weakTarget;

    private ActivityBackupBackupDBPermissionRequest(ActivityBackup target) {
      this.weakTarget = new WeakReference<ActivityBackup>(target);
    }

    @Override
    public void proceed() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_BACKUPDB, REQUEST_BACKUPDB);
    }

    @Override
    public void cancel() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      target.onCameraDenied();
    }
  }

  private static final class ActivityBackupRestoreDBPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityBackup> weakTarget;

    private ActivityBackupRestoreDBPermissionRequest(ActivityBackup target) {
      this.weakTarget = new WeakReference<ActivityBackup>(target);
    }

    @Override
    public void proceed() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_RESTOREDB, REQUEST_RESTOREDB);
    }

    @Override
    public void cancel() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      target.onCameraDenied();
    }
  }

  private static final class ActivityBackupRestoreDBFromDropboxPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityBackup> weakTarget;

    private ActivityBackupRestoreDBFromDropboxPermissionRequest(ActivityBackup target) {
      this.weakTarget = new WeakReference<ActivityBackup>(target);
    }

    @Override
    public void proceed() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_RESTOREDBFROMDROPBOX, REQUEST_RESTOREDBFROMDROPBOX);
    }

    @Override
    public void cancel() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      target.onCameraDenied();
    }
  }

  private static final class ActivityBackupCheckPermissionsPermissionRequest implements PermissionRequest {
    private final WeakReference<ActivityBackup> weakTarget;

    private ActivityBackupCheckPermissionsPermissionRequest(ActivityBackup target) {
      this.weakTarget = new WeakReference<ActivityBackup>(target);
    }

    @Override
    public void proceed() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      ActivityCompat.requestPermissions(target, PERMISSION_CHECKPERMISSIONS, REQUEST_CHECKPERMISSIONS);
    }

    @Override
    public void cancel() {
      ActivityBackup target = weakTarget.get();
      if (target == null) return;
      target.onCameraDenied();
    }
  }
}
