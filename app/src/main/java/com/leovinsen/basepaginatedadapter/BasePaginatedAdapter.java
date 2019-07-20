package com.leovinsen.basepaginatedadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePaginatedAdapter<T, L extends BaseRecyclerListener, VH extends BaseViewHolder<T, L>>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> data;
    private L listener;
    private static final int VIEW_TYPE_ITEM = 1;
    private static final int VIEW_TYPE_LOADING = 0;

    @Override
    public int getItemViewType(int position) {
        return data.get(position) != null ? VIEW_TYPE_ITEM : VIEW_TYPE_LOADING;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ITEM ){
            View view = LayoutInflater.from(parent.getContext()).inflate(getViewHolderLayout(), parent, false);
            return createItemViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress_bar, parent, false);
            return new ProgressViewHolder(view);
        }
    }

    protected abstract VH createItemViewHolder(View view);

    protected abstract int getViewHolderLayout();

    public T getItem(int pos){
        return data.get(pos);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder.getItemViewType() == VIEW_TYPE_LOADING) return;

        VH itemHolder = (VH) viewHolder;
        itemHolder.onBind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    public void addItems(List<T> items){
        if(data == null) data = new ArrayList<>();
        data.addAll(items);
        notifyDataSetChanged();
    }

    //Adds a null which will be used for ProgressViewHolder
    public void startLoading(){
        data.add(null);
        notifyItemInserted(this.data.size() - 1);
    }

    public void stopLoading(){
        data.remove(this.data.size() - 1);
        notifyItemRemoved(data.size());
    }

    public void clearList() {
        data = new ArrayList<>();
        notifyDataSetChanged();
    }

    /**
     * Set click listener, which must extend {@link BaseRecyclerListener}
     *
     * @param listener click listener
     */
    public void setListener(L listener) {
        this.listener = listener;
    }

    static class ProgressViewHolder  extends RecyclerView.ViewHolder{

        ProgressBar progressBar;

        ProgressViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
