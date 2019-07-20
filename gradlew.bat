// Generated code from Butter Knife. Do not modify!
package com.nostratech.mufit.consumer.profile;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.nostratech.mufit.consumer.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding implements Unbinder {
  private ProfileActivity target;

  private View view2131362309;

  private View view2131362283;

  private View view2131362348;

  private View view2131362320;

  private View view2131362081;

  @UiThread
  public ProfileActivity_ViewBinding(ProfileActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProfileActivity_ViewBinding(final ProfileActivity target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.profileImage = Utils.findRequiredViewAsType(source, R.id.profile_image, "field 'profileImage'", ImageView.class);
    target.editTextNama = Utils.findRequiredViewAsType(source, R.id.text_nama, "field 'editTextNama'", EditText.class);
    target.editTextEmail = Utils.findRequiredViewAsType(source, R.id.text_email, "field 'editTextEmail'", EditText.class);
    target.editTextTelepon = Utils.findRequiredViewAsType(source, R.id.text_telepon, "field 'editTextTelepon'", EditText.class);
    target.swipeRefreshProfile = Utils.findRequiredViewAsType(source, R.id.swipeRefresh_profile, "field 'swipeRefreshProfile'", SwipeRefreshLayout.class);
    target.layoutScroll = Utils.findRequiredViewAsType(source, R.id.layout_scroll, "field 'layoutScroll'", ScrollView.class);
    target.progressBarLoading = Utils.findRequiredViewAsType(source, R.id.progressBar_loading, "field 'progressBarLoading'", ProgressBar.clas