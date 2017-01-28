package com.uiresource.cookit.recycler;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.uiresource.cookit.R;

import java.util.List;

/**
 * Created by Dytstudio.
 */

public class PreparationAdapter extends SelectableAdapter<PreparationAdapter.ViewHolder> {

    private List<ItemPreparation> mArrayList;
    private Context mContext;
    private ViewHolder.ClickListener clickListener;



    public PreparationAdapter (Context context, List<ItemPreparation> arrayList,ViewHolder.ClickListener clickListener) {
        this.mArrayList = arrayList;
        this.mContext = context;
        this.clickListener = clickListener;

    }

    // Create new views
    @Override
    public PreparationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_preparation, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView,clickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.tvStep.setText(mArrayList.get(position).getStep());
        if (isSelected(position)) {
            viewHolder.done.setVisibility(View.VISIBLE);
            viewHolder.tvStep.setTextColor(mContext.getResources().getColor(R.color.colorTextGrey));
        }else{
            viewHolder.tvStep.setTextColor(mContext.getResources().getColor(R.color.colorTextDark));
            viewHolder.tvNumber.setText(mArrayList.get(position).getNumber());
            viewHolder.done.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener,View.OnLongClickListener  {

        public TextView tvStep;
        public TextView tvNumber;
        public ImageView done;

        private ClickListener listener;
        //private final View selectedOverlay;


        public ViewHolder(View itemLayoutView,ClickListener listener) {
            super(itemLayoutView);

            this.listener = listener;

            tvStep = (TextView) itemLayoutView.findViewById(R.id.tv_step);
            tvNumber = (TextView) itemLayoutView.findViewById(R.id.tv_number);
            done = (ImageView) itemLayoutView.findViewById(R.id.iv_done);
            itemLayoutView.setOnClickListener(this);

            itemLayoutView.setOnLongClickListener (this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClicked(getAdapterPosition ());
            }
        }
        @Override
        public boolean onLongClick (View view) {
            if (listener != null) {
                return listener.onItemLongClicked(getAdapterPosition ());
            }
            return false;
        }

        public interface ClickListener {
            public void onItemClicked(int position);

            public boolean onItemLongClicked(int position);

            boolean onCreateOptionsMenu(Menu menu);
        }
    }
}
