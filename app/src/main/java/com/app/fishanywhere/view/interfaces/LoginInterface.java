package com.app.fishanywhere.view.interfaces;

import com.app.fishanywhere.model.Callbacks.GetLoginCallback;
import com.app.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.app.fishanywhere.model.Callbacks.GetResetPasswordCallback;

public interface LoginInterface extends BaseInterface {
    public void getLogin(GetLoginCallback getLoginCallback);
    public void  getResetPassword(GetResetPasswordCallback getResetPasswordCallback);
    public void registerCaptain(GetRegisterCallback getRegisterCallback);

}
