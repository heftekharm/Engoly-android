package com.hfm.engoly;

import java.io.Serializable;

/**
 * Created by Hosein on 10/13/2016.
 */
public class Speech implements Serializable {
    /*       public Speech(Parcel in) {
            this.speaker = in.readString();
            this.text = in.readString();
            this.starttime = in.readDouble();
            this.endtime = in.readDouble();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(speaker);
            dest.writeString(text);
            dest.writeDouble(starttime);
            dest.writeDouble(endtime);
        }

        @Override
        public int describeContents() {
            return hashCode();
        }
        public static final Parcelable.Creator<Speech> CREATOR = new Parcelable.Creator<Speech>() {


            @Override
            public Speech createFromParcel(Parcel source) {
                return new Speech(source);
            }

            @Override
            public Speech[] newArray(int size) {
                return new Speech[size];
            }
        };*/
    private double starttime, endtime;
    private String speaker, text;

    public Speech(String speaker, String text, double starttime, double endtime) {
        this.speaker = speaker;
        this.text = text;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public double getStarttime() {
        return starttime;
    }

    public double getEndtime() {
        return endtime;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getText() {
        return text;
    }


}
