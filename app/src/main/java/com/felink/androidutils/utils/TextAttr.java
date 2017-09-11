package com.felink.androidutils.utils;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yl1445 on 2017/9/11.
 */

public class TextAttr implements Parcelable {
	public int defaultIndex;
	public int style;
	public boolean beep;
	public String cancel;
	public boolean wrapList;
	public int timeOut;
	public boolean lockIn;
	public boolean wrapTitle;
	public boolean destroyOnExit;
	public String title;

	public TextAttr(){

	}
	protected TextAttr(Parcel in) {
		readFromParcel(in);
	}

	public void readFromParcel(Parcel in) {
		defaultIndex = in.readInt();
		style = in.readInt();
		beep = in.readInt() == 1;
		cancel = in.readString();
		wrapList = in.readInt() == 1;
		timeOut = in.readInt();
		lockIn = in.readInt() == 1;
		wrapTitle = in.readInt() == 1;
		destroyOnExit = in.readInt() == 1;
		title = in.readString();
	}


	public static final Creator<TextAttr> CREATOR = new Creator<TextAttr>() {
		@Override
		public TextAttr createFromParcel(Parcel in) {
			return new TextAttr(in);
		}

		@Override
		public TextAttr[] newArray(int size) {
			return new TextAttr[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(defaultIndex);
		dest.writeInt(style);
		dest.writeInt(beep?1:0);
		dest.writeString(cancel);
		dest.writeInt(wrapList?1:0);
		dest.writeInt(timeOut);
		dest.writeInt(lockIn?1:0);
		dest.writeInt(wrapList?1:0);
		dest.writeInt(destroyOnExit?1:0);
		dest.writeString(title);
	}
}