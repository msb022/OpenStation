package com.techroof.openstationuser.HostFragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.techroof.openstationuser.Adapters.TabLayoutAdapter;
import com.techroof.openstationuser.R;
import com.techroof.openstationuser.databinding.FragmentProfileHostBinding;

public class ProfileHostFragment extends Fragment {


    BottomNavigationView bottomNavigationView;
    private FragmentProfileHostBinding profileHostBinding;
    private TabLayoutAdapter adapter;

    public ProfileHostFragment() {
        // Required empty public constructor
    }


    public static ProfileHostFragment newInstance(String param1, String param2) {
        ProfileHostFragment fragment = new ProfileHostFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        bottomNavigationView=getActivity().findViewById(R.id.bottomNavigationView);


        // Inflate the layout for this fragment
        profileHostBinding= FragmentProfileHostBinding.inflate(inflater, container, false);

        //statusbar

        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(getActivity(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getActivity().getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(getActivity(), WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
            getActivity().getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        //appbar

        profileHostBinding.appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {

                    Toast.makeText(getActivity(), "Collapsed", Toast.LENGTH_SHORT).show();


                    viewVisibleAnimator(profileHostBinding.crdviewHostProfile);

                    // Collapsed
                } else if (verticalOffset == 0) {

                    //profileHostBinding.crdviewHostProfile.setVisibility(View.GONE);
                    viewGoneAnimator(profileHostBinding.crdviewHostProfile);
                    // Expanded
                } else {
                    // Somewhere in between

                    // profileHostBinding.crdviewHostProfile.setVisibility(View.VISIBLE);


                }
            }
        });

        profileHostBinding.profileTabLayout.addTab(profileHostBinding.profileTabLayout.newTab().setText("Professional"));
        profileHostBinding.profileTabLayout.addTab(profileHostBinding.profileTabLayout.newTab().setText("Host"));

        FragmentManager fragmentManager = getFragmentManager();
        adapter = new TabLayoutAdapter(fragmentManager , getLifecycle());
        //profileHostBinding.profileTabLayoutViewpager.setAdapter(adapter);

        profileHostBinding.profileTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){

                   // bottomNavigationView.getMenu().removeItem(R.id.listings);
                    bottomNavigationView.getMenu().findItem(R.id.listings).setVisible(false);


                }else if(tab.getPosition()==1){

                    bottomNavigationView.getMenu().findItem(R.id.listings).setVisible(true);

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

      /*  profileHostBinding.profileTabLayoutViewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                profileHostBinding.profileTabLayout.selectTab(profileHostBinding.profileTabLayout.getTabAt(position));
            }
        });*/


        return profileHostBinding.getRoot();
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private void viewVisibleAnimator(final View view) {

        view.animate()
                .alpha(1f)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.VISIBLE);
                    }
                });

    }


    private void viewGoneAnimator(final View view) {

        view.animate()
                .alpha(0f)
                .setDuration(500)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        view.setVisibility(View.GONE);
                    }
                });

    }


}