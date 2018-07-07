package com.anhtd.instantship.viewModel;

import android.content.Context;

import java.util.Observable;

/**
 * Created by anhtd on 5/21/2018.
 */

public class LoginViewModel extends Observable {
    private Context context;

    public LoginViewModel(Context _context) {
        this.context = _context;
    }
}
