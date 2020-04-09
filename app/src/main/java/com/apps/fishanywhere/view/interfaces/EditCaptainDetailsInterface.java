package com.apps.fishanywhere.view.interfaces;

import com.apps.fishanywhere.model.Callbacks.GetCaptainDetailsCallback;
import com.apps.fishanywhere.model.Callbacks.GetRegisterCallback;

public interface EditCaptainDetailsInterface extends BaseInterface {
    void getCaptainDetails(GetCaptainDetailsCallback getCaptainDetailsCallback);
    void updateCaptainDetails(GetRegisterCallback getRegisterCallback);
//    void getCaptainDetails(GetCaptainDetailsCallback getCaptainDetailsCallback);
}
