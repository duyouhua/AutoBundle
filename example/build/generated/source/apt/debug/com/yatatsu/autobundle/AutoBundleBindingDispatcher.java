package com.yatatsu.autobundle;

import android.content.Intent;
import android.os.Bundle;
import com.yatatsu.autobundle.example.ExampleActivity;
import com.yatatsu.autobundle.example.ExampleActivityAutoBundle;
import com.yatatsu.autobundle.example.ExampleBroadcastReceiver;
import com.yatatsu.autobundle.example.ExampleBroadcastReceiverAutoBundle;
import com.yatatsu.autobundle.example.ExampleFragment;
import com.yatatsu.autobundle.example.ExampleFragmentAutoBundle;
import com.yatatsu.autobundle.example.ExampleIntentService;
import com.yatatsu.autobundle.example.ExampleIntentServiceAutoBundle;
import java.lang.Object;

public final class AutoBundleBindingDispatcher {
  public void bind(Object target, Bundle args) {
    if (target instanceof ExampleActivity) {
      ExampleActivityAutoBundle.bind((ExampleActivity)target, args);
      return;
    }
    if (target instanceof ExampleBroadcastReceiver) {
      ExampleBroadcastReceiverAutoBundle.bind((ExampleBroadcastReceiver)target, args);
      return;
    }
    if (target instanceof ExampleFragment) {
      ExampleFragmentAutoBundle.bind((ExampleFragment)target, args);
      return;
    }
    if (target instanceof ExampleIntentService) {
      ExampleIntentServiceAutoBundle.bind((ExampleIntentService)target, args);
      return;
    }
  }

  public void bind(Object target, Intent intent) {
    if (target instanceof ExampleActivity) {
      ExampleActivityAutoBundle.bind((ExampleActivity)target, intent);
      return;
    }
    if (target instanceof ExampleBroadcastReceiver) {
      ExampleBroadcastReceiverAutoBundle.bind((ExampleBroadcastReceiver)target, intent);
      return;
    }
    if (target instanceof ExampleIntentService) {
      ExampleIntentServiceAutoBundle.bind((ExampleIntentService)target, intent);
      return;
    }
  }

  public void bind(Object target) {
    if (target instanceof ExampleFragment) {
      ExampleFragmentAutoBundle.bind((ExampleFragment)target);
      return;
    }
  }

  public void pack(Object target, Bundle args) {
    if (target instanceof ExampleActivity) {
      ExampleActivityAutoBundle.pack((ExampleActivity)target, args);
      return;
    }
    if (target instanceof ExampleBroadcastReceiver) {
      ExampleBroadcastReceiverAutoBundle.pack((ExampleBroadcastReceiver)target, args);
      return;
    }
    if (target instanceof ExampleFragment) {
      ExampleFragmentAutoBundle.pack((ExampleFragment)target, args);
      return;
    }
    if (target instanceof ExampleIntentService) {
      ExampleIntentServiceAutoBundle.pack((ExampleIntentService)target, args);
      return;
    }
  }
}
