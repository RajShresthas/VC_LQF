package Utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.yala.sushant.vc_lqf.R;

import java.util.List;

import model.User;

/**
 * Created by sushant on 6/29/17.
 */

public class ContactListAdapter extends ArrayAdapter<User> {



    private Activity context;
    private List<User> userList;

    public ContactListAdapter(Activity context, List<User> users) {
        super(context, R.layout.contact_layout, users);
        this.context = context;
        this.userList = users;
    }

//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        LayoutInflater inflater= context.getLayoutInflater();
//        View listViewItem = inflater.inflate(R.layout.contact_layout, null, true);
//
//        User u = userList.get(position);
//      TextView name = (TextView) view.findViewById(R.id.cfullname);
//        TextView username = (TextView) view.findViewById(R.id.cusername);
//
//      name.setText(u.getFullname());
//        username.setText(u.getUsername());
//        return listViewItem;
//    }






    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.contact_layout, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.cusername);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.cfullname);

        User u = userList.get(position);
        textViewName.setText(u.getUsername());
        textViewGenre.setText(u.getFullname());

        return listViewItem;
    }


}
