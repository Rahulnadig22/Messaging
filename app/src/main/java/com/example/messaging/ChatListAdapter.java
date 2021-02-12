package com.example.messaging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListHolder>{
    private final Context context;
    private final ArrayList<chat> chatList;
    public ChatListAdapter(Context context, ArrayList<chat> chatList){
        this.context = context;
        this.chatList = chatList;
    }


    @NonNull
    @Override
    public ChatListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatListHolder(LayoutInflater.from(context).inflate(R.layout.item_chat,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    class ChatListHolder extends RecyclerView.ViewHolder {
        private LinearLayout mllRoot;
        private TextView mAuthor;
        private TextView mMessage;

        public ChatListHolder(@NonNull View itemView) {
            super(itemView);
            mllRoot = itemView.findViewById(R.id.ll_root_chat);
            mAuthor = itemView.findViewById(R.id.tv_author);
            mMessage = itemView.findViewById(R.id.tv_message);

        }
    }
}
