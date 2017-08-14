package com.kovalchyk_at.a1000words.log_in;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kovalchyk_at.a1000words.R;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity extends AppCompatActivity implements LoginActivityInterface {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mEmailSignInButton;
    private Button mFbSignInButton;
    private Button mGIncrementSignInButton;
    private Button mVKSignInButton;
    private Button mSignUpButton;
   /* private log_in_fragment mLogInFragment;
    private FragmentTransaction mFragmentTransaction;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginPresenter mPresenter = new LoginPresenter();
        // Set up the login form.

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mSignUpButton = (Button) findViewById(R.id.sign_up_button);
        mGIncrementSignInButton = (Button) findViewById(R.id.google_sign_in_button);
        mFbSignInButton = (Button) findViewById(R.id.facebook_sign_in_button);
        mVKSignInButton = (Button) findViewById(R.id.vk_sign_in_button);


       /* mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.login_fragment_container, new log_in_fragment() );
        mFragmentTransaction.commit();*/

        mLoginFormView = findViewById(R.id.login_scrollview);
        mProgressView = findViewById(R.id.login_progress);

    }

    @Override
    public void ShowPasswordEror() {

    }

    @Override
    public void ShowLoginEror() {

    }

    @Override
    public void ShowAnotherLogin() {

    }

}

