package com.example.heshu.parkmanage.bean;

/**
 * Created by heshu on 2018/6/13.
 */

public class PlaceBean {
   private int id;
   private placeState mState;

   public enum placeState{
      ORDER,
      CHOOSE,
      NO
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public placeState getState() {
      return mState;
   }

   public void setState(placeState state) {
      mState = state;
   }


}
