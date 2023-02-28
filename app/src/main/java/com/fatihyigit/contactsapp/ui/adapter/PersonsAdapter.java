package com.fatihyigit.contactsapp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.databinding.CardDesignBinding;
import com.fatihyigit.contactsapp.ui.fragment.MainFragmentDirections;
import com.fatihyigit.contactsapp.ui.viewModel.MainViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.CardViewHolder> {
    private Context mContext;
    private List<Persons> persons;
    private MainViewModel viewModel;

    public PersonsAdapter(Context mContext, List<Persons> persons, MainViewModel viewModel) {
        this.mContext = mContext;
        this.persons = persons;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        CardDesignBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.card_design, parent, false);
        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Persons person = persons.get(position);
        CardDesignBinding b = holder.binding;

        b.setPersonObject(person);

        b.imageViewDelete.setOnClickListener(v -> {
            Snackbar.make(v, person.getPerson_name() + " " + mContext.getResources().getString(R.string.delete) + "?", Snackbar.LENGTH_LONG)
                    .setAction(mContext.getResources().getString(R.string.yes), v1 -> {
                        viewModel.delete(person.getPerson_id());
                    }).show();
        });

        b.cardView.setOnClickListener(v -> {
            MainFragmentDirections.ActionFragmentMainToPersonDetail mainToPersonDetail = MainFragmentDirections.actionFragmentMainToPersonDetail(person);
            Navigation.findNavController(v).navigate(mainToPersonDetail);
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        private CardDesignBinding binding;

        public CardViewHolder(CardDesignBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
