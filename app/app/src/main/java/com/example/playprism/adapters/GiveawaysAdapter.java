package com.example.playprism.adapters;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playprism.MainActivity;
import com.example.playprism.R;
import com.example.playprism.models.GiveawaysItem;
import com.example.playprism.ui.giveaways.GiveawaysItemFragment;

import java.util.List;

public class GiveawaysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<GiveawaysItem> giveawaysItems;

    public GiveawaysAdapter(Context context, List<GiveawaysItem> giveawaysItems) {
        this.context = context;
        this.giveawaysItems = giveawaysItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        viewHolder = getViewHolder(parent, inflater);

        return viewHolder;
    }

    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        RecyclerView.ViewHolder viewHolder;
        View viewItem = inflater.inflate(R.layout.giveaways_item, parent, false);
        viewHolder = new GiveawayItemViewHolder(viewItem);
        return viewHolder;
    }

    @SuppressLint({"SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GiveawayItemViewHolder giveawayItemViewHolder = (GiveawayItemViewHolder) holder;

        String title = giveawaysItems.get(position).getTitle();
        String category = giveawaysItems.get(position).getCategory();

        giveawayItemViewHolder.takePartButton.setOnClickListener(v -> {
                    NavController navController = Navigation.findNavController(v);
                    GiveawaysItemFragment.setGiveawayId(giveawaysItems.get(position).getId());
                    navController.navigate(R.id.navigation_giveaways_item_profile);
                }
        );

        giveawayItemViewHolder.titleTextView.setText(title);
        giveawayItemViewHolder.categoryTextView.setText(category);
    }

    @Override
    public int getItemCount() {
        return giveawaysItems.size();
    }

    // add item to list:
    public void addItem(GiveawaysItem giveawaysItem) {
        giveawaysItems.add(giveawaysItem);
        notifyItemInserted(giveawaysItems.size() - 1);
    }

    protected static class GiveawayItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleTextView;
        private final TextView categoryTextView;
        private final Button takePartButton;

        public GiveawayItemViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            categoryTextView = itemView.findViewById(R.id.giveawayCategoryTextView);
            takePartButton = itemView.findViewById(R.id.button_participate);
        }
    }
}


