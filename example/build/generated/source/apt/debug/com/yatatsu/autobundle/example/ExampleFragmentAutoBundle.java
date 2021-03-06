package com.yatatsu.autobundle.example;

import android.os.Bundle;
import java.lang.String;
import java.util.Date;

public final class ExampleFragmentAutoBundle {
  public static ExampleFragmentAutoBundle.FragmentBuilder createFragmentBuilder(String title,
      Date targetDate) {
    return new ExampleFragmentAutoBundle.FragmentBuilder(title,targetDate);
  }

  public static void bind(ExampleFragment target) {
    bind(target, target.getArguments());
  }

  public static void bind(ExampleFragment target, Bundle source) {
    if (source.containsKey("title")) {
      target.title = (String) source.getString("title");
    } else {
      throw new IllegalStateException("title is required, but not found in the bundle.");
    }
    if (source.containsKey("targetDate")) {
      ExampleFragment.DateArgConverter targetDateConverter = new ExampleFragment.DateArgConverter();
      target.targetDate = (Date) targetDateConverter.original( source.getLong("targetDate") );
    } else {
      throw new IllegalStateException("targetDate is required, but not found in the bundle.");
    }
  }

  public static void pack(ExampleFragment source, Bundle args) {
    if (source.title != null) {
      args.putString("title", source.title);
    } else {
      throw new IllegalStateException("title must not be null.");
    }
    if (source.targetDate != null) {
      ExampleFragment.DateArgConverter targetDateConverter = new ExampleFragment.DateArgConverter();
      args.putLong("targetDate", targetDateConverter.convert(source.targetDate) );
    } else {
      throw new IllegalStateException("targetDate must not be null.");
    }
  }

  public static final class FragmentBuilder {
    final Bundle args;

    public FragmentBuilder(String title, Date targetDate) {
      this.args = new Bundle();
      this.args.putString("title", title);
      ExampleFragment.DateArgConverter targetDateConverter = new ExampleFragment.DateArgConverter();
      this.args.putLong("targetDate", targetDateConverter.convert(targetDate) );
    }

    public ExampleFragment build() {
      ExampleFragment fragment = new ExampleFragment();
      fragment.setArguments(args);
      return fragment;
    }

    public ExampleFragment build(ExampleFragment fragment) {
      fragment.setArguments(args);
      return fragment;
    }
  }
}
