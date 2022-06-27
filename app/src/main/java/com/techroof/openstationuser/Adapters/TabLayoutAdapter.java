package com.techroof.openstationuser.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.techroof.openstationuser.HostFragments.ProfileHostFragment;
import com.techroof.openstationuser.ProfileTabLayoutFragments.HostFragment;
import com.techroof.openstationuser.ProfileTabLayoutFragments.ProfessionalFragment;

public class TabLayoutAdapter  extends FragmentStateAdapter {



    public TabLayoutAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new HostFragment();
        }
        return new ProfessionalFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

