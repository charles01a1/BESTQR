package com.example.bestqr.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bestqr.CameraActivity;
import com.example.bestqr.R;
import com.example.bestqr.databinding.FragmentUserBinding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UserFragment extends Fragment {

//    private Profile profile;
    private UserViewModel userViewModel;
    private FragmentUserBinding binding;

    private Button btn1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        binding = FragmentUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        // onClick Listener for the QR button on the toolbar
        // This button navigates to QrFragment, which displays a list of the user's QR codes
        ImageButton qr_button = binding.toolbarUserQr;
        qr_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.action_navigation_from_user_to_qr);
            }

        });

        // onClick Listener for the Sort button on the toolbar
        // when pressed, this button displays a PopupMenu containing 3 different sorting methods
        ImageButton sort_button = binding.toolbarUserSort;
        sort_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(getActivity(), sort_button);
                popup.getMenuInflater().inflate(R.menu.user_sort_menu, popup.getMenu());
                popup.show();
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Setup navigation for Fragment Top-Level destination toolbar
        // Top-Level Fragments need to pass an AppBarConfiguration to the toolbar
        // to function correctly.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(CameraActivity.getTopLevelDestinations()).build();
        NavController navController = NavHostFragment.findNavController(this);
        NavigationUI.setupWithNavController(binding.toolbarUser, navController, appBarConfiguration);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}