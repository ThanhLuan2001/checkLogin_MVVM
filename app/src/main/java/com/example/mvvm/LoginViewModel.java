package com.example.mvvm;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

public class LoginViewModel extends BaseObservable {

    private String email;
    private String password;

    public ObservableField<String> thongbaoLogin = new ObservableField<>();
    public ObservableField<Boolean> showThongBao = new ObservableField<>();
    public ObservableField<Boolean> thanhCong = new ObservableField<>();

    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin(){
        User user = new User(getEmail(),getPassword());
        showThongBao.set(true);

        if (user.KiemtraEmail()&&user.KiemtraPassword()){
            thongbaoLogin.set("Email và pass hợp lệ");
            thanhCong.set(true);
        }else{
            thongbaoLogin.set("Email và pass không hợp lệ");
            thanhCong.set(false);
        }
    }
}
