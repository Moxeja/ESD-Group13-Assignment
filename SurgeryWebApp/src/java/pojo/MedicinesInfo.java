/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Dominika
 */
public class MedicinesInfo {
    
    public final int mID;
    public final String mName;
    public final String mType;
    public final float mCost;

    public MedicinesInfo(int mID, String mName,
            String mType, float mCost){
        this.mID = mID;
        this.mName = mName;
        this.mType = mType;
        this.mCost = mCost;
    } 
}
