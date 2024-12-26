package com.example.java_android_practice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ContactRecViewAdaptor extends  RecyclerView.Adapter<ContactRecViewAdaptor.ViewHolder>{
    private ArrayList<Contact> contacts=new ArrayList<>();
    private  Context context;

    public ContactRecViewAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    //A ViewHolder is a container for item views, improving RecyclerView performance by reducing findViewById() calls.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).getName());
        holder.txtEmail.setText(contacts.get(position).getEmail());


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    Toast.makeText(context, contacts.get(adapterPosition).getName()+" selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Glide.with(context)
                .asBitmap()
                .load(contacts.get(position).getImageURL())
                .into(holder.imageURL);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName,txtEmail;
        ImageView imageURL;
//        private RelativeLayout parent;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.name);
            txtEmail=itemView.findViewById(R.id.email);
            imageURL=itemView.findViewById(R.id.imageURL);
            parent=itemView.findViewById(R.id.contactParent);
        }
    }

}
