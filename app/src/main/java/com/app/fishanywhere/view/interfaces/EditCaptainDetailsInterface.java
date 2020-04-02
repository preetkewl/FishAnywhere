package com.app.fishanywhere.view.interfaces;

import com.app.fishanywhere.model.Callbacks.GetCaptainDetailsCallback;
import com.app.fishanywhere.model.Callbacks.GetRegisterCallback;

public interface EditCaptainDetailsInterface extends BaseInterface {
    void getCaptainDetails(GetCaptainDetailsCallback getCaptainDetailsCallback);
    void updateCaptainDetails(GetRegisterCallback getRegisterCallback);
//    void getCaptainDetails(GetCaptainDetailsCallback getCaptainDetailsCallback);
}
