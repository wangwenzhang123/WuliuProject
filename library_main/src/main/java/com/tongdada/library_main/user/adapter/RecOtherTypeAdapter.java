package com.tongdada.library_main.user.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library_main.R;
import com.tongdada.library_main.user.respose.MessageBean;
import com.tongdada.library_main.widget.slideswaphelper.SlideSwapAction;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by WANG on 18/4/24.
 */

public class RecOtherTypeAdapter extends RecyclerView.Adapter<RecOtherTypeAdapter.RecViewholder> {


    private Context context;
    private List<MessageBean.PagenationBean.ListBean> data = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private DeletedItemListener deletedItemListener;

    public void setDeletedItemListener(DeletedItemListener deletedItemListener) {
        this.deletedItemListener = deletedItemListener;
    }

    public RecOtherTypeAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<MessageBean.PagenationBean.ListBean> list, boolean refresh) {
        if (refresh) {
            data.clear();
        }
        data.addAll(list);
        notifyDataSetChanged();
    }

    public void removeDataByPosition(int position) {
        if (position >= 0 && position < data.size()) {
            data.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, data.size() - 1);
        }
    }

    @Override
    public RecViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_message, parent, false);
        return new RecViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecViewholder holder, final int position) {
        holder.title.setText(data.get(position).getMessageContent());
        holder.time.setText(data.get(position).getSendTime());
        switch (data.get(position).getReadStatus()){
            case "N":
                holder.state.setText("未读") ;
                break;
            case "Y":
                holder.state.setText("已读") ;
                break;
            default:
                holder.state.setText("未知") ;
                break;
        }
        holder.slide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != deletedItemListener) {
                    deletedItemListener.deleted(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface DeletedItemListener {

        void deleted(int position);
    }
    /**
     * view.getWidth()获取的是屏幕中可以看到的大小.
     */
    public class RecViewholder extends RecyclerView.ViewHolder implements SlideSwapAction {
        public TextView title,time,state;
        public ImageView slide;

        public RecViewholder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.message_title);
            time = itemView.findViewById(R.id.message_time);
            state = itemView.findViewById(R.id.message_state);
            slide = itemView.findViewById(R.id.item_slide);

        }

        @Override
        public float getActionWidth() {
            return dip2px(slide.getContext(), 100);
        }

        @Override
        public View ItemView() {
            return time;
        }

    }

    /**
     * 根据手机分辨率从DP转成PX
     *
     * @param context
     * @param dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
