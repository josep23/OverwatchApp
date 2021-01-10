package com.example.overwatchapp;

import android.gesture.GestureLibraries;
import android.net.Uri;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.ViewModelProvider;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static androidx.core.content.ContextCompat.checkSelfPermission;

public class InsertarHeroeFragment {
    package com.company.roomfloyd;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts.GetContent;
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.company.roomfloyd.databinding.FragmentInsertarAlbumBinding;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static androidx.core.content.ContextCompat.checkSelfPermission;


    public class InsertarAlbumFragment extends Fragment {
        private FragmentInsertarHeroeBinding binding;
        Uri imagenSeleccionada;
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            return (binding = FragmentInsertarHeroeBinding.inflate(inflater, container, false)).getRoot();
        }
        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            binding.foto_Heroe.setonClickListener(v -> {
                abrirGaleria();
            });
            binding.insertar.setOnClickListener(v -> {
                String Nombre_heroe = binding.Nombre_heroe.getText().toString();
                String Rol_heroe = binding.Rol_heroe.getText().toString();
            });
        }
        private void abrirGaleria(){
            if (checkSelfPermission(requireContext(), READ_EXTERNAL_STORAGE) == PERMISSION_GRANTED) {
                lanzadorGaleria.launch("image/*");
            } else {
                lanzadorPermisos.launch(READ_EXTERNAL_STORAGE);
            }
        }

        private final ActivityResultLauncher<String> lanzadorGaleria =
                registerForActivityResult(new GetContent(), uri -> {
         //           HeroesViewModel.establecerImagenSeleccionada(uri);
                    imagenSeleccionada = uri;
                    Glide.with(requireView()).load(uri).into(binding.foto_Heroe);
                });

        private final ActivityResultLauncher<String> lanzadorPermisos =
                registerForActivityResult(new RequestPermission(), isGranted -> {
                    if (isGranted) {
                        lanzadorGaleria.launch("image/*");
                    }
                });
    }

}
