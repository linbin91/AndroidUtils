package com.felink.androidutils.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by yl1445 on 2017/9/9.
 */

public class BaseFragment extends Fragment {

	private static final String ARG_PARAM1 = "param-1";
	private static final String ARG_PARAM2 = "param-2";
	private String mParam1;
	private String mParam2;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	// TODO: Rename and change types and number of parameters
	public static BaseFragment newInstance(String param1, String param2) {
		BaseFragment fragment = new BaseFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}
}
