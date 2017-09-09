package com.felink.androidutils.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by yl1445 on 2017/9/7.
 */

public abstract class CommonAdapter<T> extends RecyclerView.Adapter<ViewHolder>{

	private Context mContext;
	private List<T> mDatas;
	private int mLayoutId;

	protected OnItemClickListener mOnItemClickListener;


	public CommonAdapter(Context context, List<T> datas, final  int layoutId) {
		mContext = context;
		mDatas = datas;
		mLayoutId = layoutId;
	}



	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ViewHolder holder = ViewHolder.createViewHolder(mContext, parent, mLayoutId);
		onViewHolderCreated(holder,holder.getConvertView());
		setListener(parent, holder, viewType);
		return holder;
	}

	public void onViewHolderCreated(ViewHolder holder,View itemView){

	}

	public abstract  void convert(ViewHolder holder, T t,int position);

	protected boolean isEnabled(int viewType) {
		return true;
	}


	protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType) {
		if (!isEnabled(viewType)) return;
		viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mOnItemClickListener != null) {
					int position = viewHolder.getPosition();
					mOnItemClickListener.onItemClick(v, viewHolder , position);
				}
			}
		});

		viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				if (mOnItemClickListener != null) {
					int position = viewHolder.getPosition();
					return mOnItemClickListener.onItemLongClick(v, viewHolder, position);
				}
				return false;
			}
		});
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		convert(holder, mDatas.get(position),position);
	}

	@Override
	public int getItemCount() {
		int itemCount = mDatas.size();
		return itemCount;
	}

	public List<T> getDatas() {
		return mDatas;
	}

	public interface OnItemClickListener {
		void onItemClick(View view, RecyclerView.ViewHolder holder, int position);
		boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		this.mOnItemClickListener = onItemClickListener;
	}
}
