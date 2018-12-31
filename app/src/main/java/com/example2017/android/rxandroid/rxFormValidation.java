package com.example2017.android.rxandroid;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding2.widget.RxTextView;

import javax.xml.validation.Validator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subscribers.DisposableSubscriber;

public class rxFormValidation extends AppCompatActivity {


    EditText edit1;

    EditText edit2;

    EditText edit3;

    Button btnSubmit;

    private String TAG = this.getClass().getSimpleName();

    private DisposableSubscriber<Boolean> disposableSubscriber = null;
    private Flowable<CharSequence> firstNameChangeObservable;
    private Flowable<CharSequence> lastNameChangeObservable;
    private Flowable<CharSequence> emailChangeObservable;
    private Unbinder unbinder;
    Observable<Boolean> observable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_form_validation);

        unbinder = ButterKnife.bind(this);

        edit1=(EditText)findViewById(R.id.editText);
        edit2=(EditText)findViewById(R.id.editText2);
        edit3=(EditText)findViewById(R.id.editText2);
        btnSubmit=(Button)findViewById(R.id.button);



        // observe for first editText
        Observable<String> nameObservable = RxTextView.textChanges(edit1).skip(1).map(new Function<CharSequence, String>() {
            @Override
            public String apply(@NonNull CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        });

        // observe for second editText
        Observable<String> passwordObservable = RxTextView.textChanges(edit2).skip(2).map(new Function<CharSequence, String>() {
            @Override
            public String apply(CharSequence charSequence) throws Exception {
                return charSequence.toString();
            }
        });


        // to collect two observable
        observable = Observable.combineLatest(nameObservable, passwordObservable, new BiFunction<String, String, Boolean>() {
            @Override
            public Boolean apply(String s, String s2) throws Exception {
                return isValidForm(s, s2);
            }});

        observable.subscribe(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean aBoolean) {
                updateButton(aBoolean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
    public void updateButton(boolean valid) {
        if (valid)
            btnSubmit.setEnabled(true);
    }

    public boolean isValidForm(String name, String password) {
        boolean validName = !name.isEmpty();

        if (!validName) {
            edit1.setError("Please enter valid name");
        }

        boolean validPass = !password.isEmpty();
        if (!validPass) {
            edit2.setError("Incorrect password");
        }
        return validName && validPass;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();


    }



}