package com.anhtd.instantship.viewModel;


import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;


/**
 * Created by anhtd on 5/21/2018.
 */

public class RegisterViewModel extends BaseObservable {
    public ObservableField<String> edtPhone = new ObservableField<>();
    public ObservableField<String> edtEmail = new ObservableField<>();
    public ObservableField<String> edtPassword = new ObservableField<>();
    public ObservableInt roleId = new ObservableInt();

    public RegisterViewModel() {
        roleId.set(1);
    }

    public void setRoleId(int role) {
        roleId.set(role);
        notifyChange();
    }
}
