package com.apps.fishanywhere.model;

import android.graphics.drawable.Drawable;

/**
 * Created by anupamchugh on 22/12/17.
 */

public class MenuModel {

    public String menuName, menuImage;
    public boolean hasChildren, isGroup;
    Drawable image;

    public MenuModel(String menuName, boolean isGroup, boolean hasChildren, Drawable image) {

        this.menuName = menuName;
        this.image = image;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }
}
