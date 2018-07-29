package com.anhtd.instantship.view.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.anhtd.instantship.R;
import com.anhtd.instantship.databinding.ActivityRegisterBinding;
import com.anhtd.instantship.model.ResponeData;
import com.anhtd.instantship.network.ApiFactory;
import com.anhtd.instantship.network.UsersService;
import com.anhtd.instantship.utils.AppUtils;
import com.anhtd.instantship.utils.StringUtil;
import com.anhtd.instantship.viewModel.RegisterViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private RegisterHandler handler;
    private RegisterViewModel viewModel;
    private int roleId = 1;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        handler = new RegisterHandler();
        viewModel = new RegisterViewModel();
        binding.setViewModel(viewModel);
        binding.setHandler(handler);
        binding.rdgShip.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbtn_category_shipper:
                        roleId = 1;
                        break;
                    case R.id.rbtn_category_find_ship:
                        roleId = 2;
                        break;
                }
            }
        });
    }

    public class RegisterHandler {
        public void onRegister(View view) {
            String strPhone = binding.edtPhone.getText().toString().trim();
            if (!StringUtil.phoneSuscess(strPhone)) {
                Toast.makeText(RegisterActivity.this, "Số điện thoại không đúng", Toast.LENGTH_LONG).show();
                return;
            }
            String strEmail = binding.edtEmail.getText().toString().trim();
            if (!StringUtil.isValidEmail(strEmail)) {
                Toast.makeText(RegisterActivity.this, "Email không đúng", Toast.LENGTH_LONG).show();
                return;
            }
            String password = binding.edtPassword.getText().toString();
            if (!StringUtil.isGoodPasswordField(password)) {
                Toast.makeText(RegisterActivity.this, "Password quá dài hoặc quá ngắn", Toast.LENGTH_LONG).show();
                return;
            }

            UsersService usersService = ApiFactory.create();
            Disposable disposable = usersService.register(roleId, strPhone, password, strEmail)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<ResponeData>() {
                        @Override
                        public void accept(ResponeData responeData) throws Exception {
                            if (responeData.getErrorCode() != 0) {
                                Toast.makeText(RegisterActivity.this, "Đăng ký lỗi", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_LONG).show();
                                AppUtils.startActivityLTR(RegisterActivity.this, LoginActivity.class);
                            }
                        }
                    }, new Consumer<Throwable>() {

                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Toast.makeText(RegisterActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

            compositeDisposable.add(disposable);
        }


    }
}
