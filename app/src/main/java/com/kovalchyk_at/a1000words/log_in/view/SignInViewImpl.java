package com.kovalchyk_at.a1000words.log_in.view;

import android.app.Activity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.kovalchyk_at.a1000words.R;
import com.kovalchyk_at.a1000words.log_in.presenter.SignInPresenter;

/**
 * Created by AndRiy on 19.09.2017.
 */

public class SignInViewImpl implements SignInView {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private Button mEmailSignInButton;
    private Button mFbSignInButton;
    private Button mGIncrementSignInButton;
    private Button mAnonimSignInButton;
    private Button mSignUpButton;

    private SignInPresenter presenter;
    private Activity activity;

    public SignInViewImpl(SignInPresenter presenter, Activity activity) {
        this.activity = activity;
        this.presenter = presenter;
        initView(activity);
        initListeners();
    }

    private void initView(Activity activity){
        mEmailView = (AutoCompleteTextView) activity.findViewById(R.id.email);
        mPasswordView = (EditText) activity.findViewById(R.id.password);
        mEmailSignInButton = (Button) activity.findViewById(R.id.email_sign_in_button);
        mSignUpButton = (Button) activity.findViewById(R.id.register_new_user);
        mGIncrementSignInButton = (Button) activity.findViewById(R.id.google_sign_in_button);
        mFbSignInButton = (Button) activity.findViewById(R.id.facebook_sign_in_button);
        mAnonimSignInButton = (Button) activity.findViewById(R.id.anonym_sign_in_button);

        mLoginFormView = activity.findViewById(R.id.login_scrollview);
        mProgressView = activity.findViewById(R.id.login_progress);

    }

    private void initListeners() {

        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignInWithEmailAndPassword(mEmailView.toString(), mPasswordView.toString());
            }
        });
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignUpClick(mEmailView.toString(), mPasswordView.toString());
            }
        });
        mGIncrementSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignInWithGoogle(mEmailView.toString(), mPasswordView.toString());
            }
        });
        mFbSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignInWithFacebook(mEmailView.toString(), mPasswordView.toString());
            }
        });
        mAnonimSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAnonym();
            }
        });
    }

    @Override
    public void ShowPasswordError() {

    }

    @Override
    public void ShowLoginError() {

    }

    @Override
    public void ShowAnotherLogin() {

    }
}
