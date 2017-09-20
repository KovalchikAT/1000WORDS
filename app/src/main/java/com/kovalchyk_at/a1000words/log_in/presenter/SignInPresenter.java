package com.kovalchyk_at.a1000words.log_in.presenter;

/**
 * Created by Kovalchyk_at on 14.08.2017.
 */

public interface SignInPresenter {
    void onSignInWithEmailAndPassword(String email, String password);
    void onSignInWithFacebook(String email, String password);
    void onSignInWithGoogle(String email, String password);
    void onAnonym();

    void onSignUpClick(String email, String password);
    void init();
    void stop();
}
