package com.kovalchyk_at.a1000words.log_in.presenter;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.kovalchyk_at.a1000words.LoginActivity;
import com.kovalchyk_at.a1000words.R;
import com.kovalchyk_at.a1000words.TabbedConteinerActivity;
import com.kovalchyk_at.a1000words.log_in.view.SignInView;

/**
 * Created by Kovalchyk_at on 14.08.2017.
 */

public class SignInPresenterImpl implements SignInPresenter {

    public final static String EXTRA_MESEGE = "com.kovalchyk_at.a1000words.log_in.mAuthUser";

    private LoginActivity mLoginActivity;
    private String TAG = "PresenterTAG";
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;
    private AuthCredential credential;
    private FirebaseUser user;

    private SignInView view;

    public SignInPresenterImpl(LoginActivity mloginActivity) {
        this.mLoginActivity = mloginActivity;

        initAuth();
    }

    private void initAuth() {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };
    }

    public void setView(SignInView view) {
        this.view = view;
    }

    public void checkAuth() {

    }


    public void onClick(final View view, String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        switch (view.getId()) {
            case R.id.email_sign_in_button:
                Log.d(TAG, "email_sign_in_button");
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "signInWithEmail:failed", task.getException());
                                    Toast.makeText(mLoginActivity, R.string.error_valid_user,
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
                break;
            case R.id.facebook_sign_in_button:
                Log.d(TAG, "facebook_sign_in_button");

                //  credential = FacebookAuthProvider.getCredential(token.getToken());
                break;
            case R.id.google_sign_in_button:
                Log.d(TAG, "google_sign_in_button");
                //  credential = GoogleAuthProvider.getCredential(googleIdToken, null);
                break;
            case R.id.anonym_sign_in_button:
                Log.d(TAG, "anonym_sign_in_button");
                mAuth.signInAnonymously()
                        .addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInAnonymously:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInAnonymously:failure", task.getException());
                                    Toast.makeText(mLoginActivity, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
                break;
            case R.id.register_new_user:
                Log.d(TAG, "register_new_user");
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Log.w(TAG, "signInWithEmail:failed", task.getException());
                                    Toast.makeText(mLoginActivity, R.string.error_valid_user,
                                            Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });
                break;
            default:
                Log.d(TAG, "default");
                return;
        }
        openTabbedActivity();

    }

    private void openTabbedActivity() {
        Log.d(TAG, "open new activity");
        Intent intent = new Intent(mLoginActivity, TabbedConteinerActivity.class);
        intent.putExtra(EXTRA_MESEGE, (Parcelable) mAuth.getCurrentUser());
        mLoginActivity.startActivity(intent);
    }

    private void fakeLogin() {
        mLoginActivity.startActivity(new Intent(mLoginActivity, TabbedConteinerActivity.class));
    }

    @Override
    public void onSignInWithEmailAndPassword(String email, String password) {
        initAuth();
        Log.d(TAG, "email_sign_in_button");
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(mLoginActivity, R.string.error_valid_user,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
        fakeLogin();
    }

    @Override
    public void onSignInWithFacebook(String email, String password) {
        Log.d(TAG, "facebook_sign_in_button");

        fakeLogin();
    }

    @Override
    public void onSignInWithGoogle(String email, String password) {
        Log.d(TAG, "google_sign_in_button");

        fakeLogin();
    }

    @Override
    public void onAnonym() {
        Log.d(TAG, "anonym_sign_in_button");
        mAuth.signInAnonymously().addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    FirebaseUser user = mAuth.getCurrentUser();
                    Log.d(TAG, "signInAnonymously:success " + user.getUid());
                    openTabbedActivity();
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInAnonymously:failure " + user.getUid(), task.getException());
                    Toast.makeText(mLoginActivity, "Authentication failed.", Toast.LENGTH_SHORT).show();
                }

                // ...
            }
        });
        initAuth();
        //fakeLogin();
    }

    @Override
    public void onSignUpClick(String email, String password) {
        Log.d(TAG, "register_new_user");
        initAuth();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(mLoginActivity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithEmail:failed", task.getException());
                            Toast.makeText(mLoginActivity, R.string.error_valid_user,
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
        fakeLogin();
    }

    @Override
    public void init() {
        mAuth.addAuthStateListener(mAuthListener);
    }


    @Override
    public void stop() {
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

}

                     /* mAuth = FirebaseAuth.getInstance();
                        mAuthListener = new FirebaseAuth.AuthStateListener() {
                            @Override
                            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                if (user != null) {
                                    // User is signed in
                                    Log.d("AuthTAG", "onAuthStateChanged:signed_in:" + user.getUid());
                                } else {
                                    // User is signed out
                                    Log.d("AuthTAG", "onAuthStateChanged:signed_out");
                                }
                                // ...
                            }
                        };*/