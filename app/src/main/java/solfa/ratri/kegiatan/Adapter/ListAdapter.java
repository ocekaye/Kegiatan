package solfa.ratri.kegiatan.Adapter;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class ListAdapter<T, VH extends  RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    private List<T> mItems;

    public ListAdapter(){
        mItems = new ArrayList<>();
    }

    public ListAdapter(List items){
        mItems = items;
    }

    public void add(T item){
        mItems.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    public void add(T item, int position){
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void add(List<T> items){
        int lastNbElement = mItems.size();
        mItems.addAll(items);
        notifyDataSetChanged();
//        notifyItemRangeInserted(lastNbElement, mItems.size() - 1);
    }

    public void remove(int position){
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void clearAll(){
        mItems.clear();
        notifyDataSetChanged();
    }

    public T get(int position){
        return mItems.get(position);
    }

    public  List<T> getAll(){
        return  mItems;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

}
