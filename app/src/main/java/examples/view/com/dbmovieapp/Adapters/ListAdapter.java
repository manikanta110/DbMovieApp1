package examples.view.com.dbmovieapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import examples.view.com.dbmovieapp.Feed.Result;
import examples.view.com.dbmovieapp.R;

/**
 * Created by user on 16-Oct-17.
 */

public class ListAdapter extends BaseAdapter {
    Context context;
    List<Result> list =new ArrayList<>();

    public ListAdapter(Context context,List<Result> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
          ViewHolder holder;
          LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          view = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.author = (TextView)view.findViewById(R.id.author);
            holder.content = (TextView)view.findViewById(R.id.content);
        holder.author.setText(list.get(i).getAuthor());
        holder.content.setText(list.get(i).getContent());


        return view;
    }


    private class ViewHolder {

        TextView author;
        TextView content;
    }

}
