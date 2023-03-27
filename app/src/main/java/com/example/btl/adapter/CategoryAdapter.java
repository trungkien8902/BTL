package com.example.btl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl.R;
import com.example.btl.model.Tag;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolderCate> {

    Context context;
    List<Tag> Cates;
    final private OnItemCateClick mOnclick;

    public CategoryAdapter(Context context, List<Tag> categories, OnItemCateClick mOnclick) {
        this.context = context;
        Cates = categories;
        this.mOnclick = mOnclick;
    }

    @NonNull
    @Override
    public ViewHolderCate onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cate, parent, false);
        return new ViewHolderCate(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCate holder, int position) {
        Tag tag = Cates.get(position);
        holder.txtCateName.setText(tag.getTag());
    }

    @Override
    public int getItemCount() {
        return Cates.size();
    }

    public static interface OnItemCateClick{
        void onCateItemClick(int clickedItemIndex);
    }

    public class ViewHolderCate extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtCateName;

        public ViewHolderCate(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtCateName = itemView.findViewById(R.id.tv_cate_name);
        }

        @Override
        public void onClick(View v) {
            int index = getAdapterPosition();
            mOnclick.onCateItemClick(index);
        }
    }
}
