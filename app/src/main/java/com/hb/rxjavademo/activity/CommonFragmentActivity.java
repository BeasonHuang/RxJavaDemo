package com.hb.rxjavademo.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hb.rxjavademo.R;

/**
 * @author huangbiao
 * @data 2019 2019-05-18 11:34
 */
public class CommonFragmentActivity extends AppCompatActivity {

    private static final String TAG = CommonFragmentActivity.class.getSimpleName();

    private static final String KEY_FRAGMENT_NAME = "KEY_FRAGMENT_NAME";
    private static final String KEY_ARGMENTS = "KEY_ARGMENTS";


    public static void start(Context context, Class<? extends Fragment> fragmentClazz, Bundle fragmentArgs) {
        start(context, fragmentClazz, fragmentArgs, null);
    }

    public static void startForResult(Activity activity, Class<? extends Fragment> fragmentClazz, Bundle fragmentArgs, int requestCode) {
        start(activity, fragmentClazz, fragmentArgs, requestCode);
    }

    public static void startForResult(Fragment fragment, Class<? extends Fragment> fragmentClazz, Bundle fragmentArgs, int requestCode) {
        start(fragment, fragmentClazz, fragmentArgs, requestCode);
    }


    private static void start(Object owner, Class<? extends Fragment> fragmentClazz, Bundle fragmentArgs, Integer requestCode) {
        Context context;
        if (owner instanceof Fragment) {
            context = ((Fragment) owner).getActivity();
        } else {
            context = (Context) owner;
        }
        Intent intent = new Intent(context, CommonFragmentActivity.class);
        intent.putExtra(KEY_FRAGMENT_NAME, fragmentClazz.getName());
        if (fragmentArgs != null) {
            intent.putExtra(KEY_ARGMENTS, fragmentArgs);
        }
        if (requestCode == null) {
            context.startActivity(intent);
        } else {
            if (owner instanceof Fragment) {
                ((Fragment) owner).startActivityForResult(intent, requestCode);
            } else {
                ((Activity) context).startActivityForResult(intent, requestCode);
            }
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_fragment);
        Intent intent = getIntent();
        Fragment fragment = Fragment.instantiate(this, intent.getStringExtra(KEY_FRAGMENT_NAME));
        Bundle args = intent.getBundleExtra(KEY_ARGMENTS);
        if (args != null) {
            fragment.setArguments(args);
        }

        addFragment(fragment);
    }

    private void addFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.common_fragment, fragment);

        try {
            transaction.commitAllowingStateLoss();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}