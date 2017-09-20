package com.kovalchyk_at.a1000words;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kovalchyk_at.a1000words.log_in.presenter.SignInPresenter;
import com.kovalchyk_at.a1000words.log_in.presenter.SignInPresenterImpl;
import com.kovalchyk_at.a1000words.log_in.view.SignInView;
import com.kovalchyk_at.a1000words.log_in.view.SignInViewImpl;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    private SignInPresenter signInPresenter;

    private SignInView signInView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signInPresenter = new SignInPresenterImpl(this);
        // Set up the login form.
        signInView = new SignInViewImpl(signInPresenter, this);
    }
}