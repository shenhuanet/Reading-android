package com.shenhua.reading.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.shenhua.reading.R;
import com.shenhua.reading.bean.KanyuanBean;
import java.util.List;

/**
 * Created by shenhua on 2016/3/30.
 */
public class KanyuanAdapter extends RecyclerView.Adapter<KanyuanViewHolder> implements View.OnClickListener{

    private Context context;
    private List<KanyuanBean> datas;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public KanyuanAdapter(Context context, List<KanyuanBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public KanyuanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.items_kuanyuan_reclist, parent, false);
        KanyuanViewHolder holder = new KanyuanViewHolder(view);
        view.setOnClickListener(this);//将创建的View注册点击事件
        return holder;
    }

    @Override
    public void onBindViewHolder(KanyuanViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        holder.title.setText(datas.get(position).getTitle());
        holder.itemView.setTag(datas.get(position).getTitle());//将数据保存在Tag中，以便点击时进行获取
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    /**
     * declare interface
     */
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    /**
     * override onClick
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (String) v.getTag());//使用getTag方法获取数据
        }
    }

    /**
     * OnItemClickListener outside call
     *
     * @param listener
     */
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}

class KanyuanViewHolder extends RecyclerView.ViewHolder {
    TextView title;

    public KanyuanViewHolder(View itemView) {
        super(itemView);
        //findviewbyid
        title = (TextView) itemView.findViewById(R.id.ky_item_title);
    }
}

