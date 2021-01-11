package com.example.overwatchapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

public class listarHeroesFragment {
   private FragmentlistaHeroesBinding binding;
   private NavController navController;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentListarHeroesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        heroesViewModel = new ViewModelProvider(requireActivity()).get(heroesViewModel.class);

        navController = Navigation.findNavController(view);

        binding.navegarAInsertar.setOnClickListener(v -> {
            navController.navigate(R.id.action_listarHeroesFragment_to_insertarAlbumFragment);
        });
    }
}
