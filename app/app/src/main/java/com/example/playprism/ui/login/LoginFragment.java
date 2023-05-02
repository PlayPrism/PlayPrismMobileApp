package com.example.playprism.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.playprism.MainActivity;
import com.example.playprism.R;
import com.example.playprism.databinding.FragmentLoginBinding;
import com.example.playprism.ui.giveaways.GiveawaysFragment;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);

        root = binding.getRoot();

        root.findViewById(R.id.button_login).setOnClickListener(v -> login());
        root.findViewById(R.id.button_signUp).setOnClickListener(v -> signUp());

        return root;

    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;

    }

    private NavController getNavController() {
        MainActivity mainActivity = (MainActivity) getActivity();

        if (mainActivity == null) {
            return null;
        }

        NavController navController = Navigation.findNavController(mainActivity, R.id.nav_host_fragment_activity_main);
        return navController;
    }

    private void login() {

        NavController navController = getNavController();
        if (navController == null) {
            return;
        }
        navController.navigate(R.id.navigation_giveaways);

    }

    private void signUp() {

        NavController navController = getNavController();
        if (navController == null) {
            return;
        }
        navController.navigate(R.id.navigation_signUp);

    }
}