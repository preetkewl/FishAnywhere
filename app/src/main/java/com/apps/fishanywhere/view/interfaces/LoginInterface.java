package com.apps.fishanywhere.view.interfaces;

import com.apps.fishanywhere.model.Callbacks.GetLoginCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;
import com.apps.fishanywhere.model.Callbacks.GetResetPasswordCallback;

public interface LoginInterface extends BaseInterface {
    public void getLogin(GetLoginCallback getLoginCallback);
    public void  getResetPassword(GetResetPasswordCallback getResetPasswordCallback);
    public void registerCaptain(GetRegisterCallback getRegisterCallback);

}
