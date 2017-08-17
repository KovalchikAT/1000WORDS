package com.kovalchyk_at.a1000words.log_in;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.kovalchyk_at.a1000words.R;

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
        LoginPresenter mPresenter = new LoginPresenter(this);
        // Set up the login form.

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mSignUpButton = (Button) findViewById(R.id.register_new_user);
        mGIncrementSignInButton = (Button) findViewById(R.id.google_sign_in_button);
        mFbSignInButton = (Button) findViewById(R.id.facebook_sign_in_button);
        mVKSignInButton = (Button) findViewById(R.id.anonym_sign_in_button);

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

