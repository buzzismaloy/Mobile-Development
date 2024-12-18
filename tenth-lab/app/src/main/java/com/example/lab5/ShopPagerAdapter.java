package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ShopPagerAdapter extends FragmentStatePagerAdapter {

    public ShopPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new WeaponFragment();
            case 2:
                return new BoguFragment();
            case 3:
                return new StoreAddressesFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Main";
            case 1:
                return "Weapon";
            case 2:
                return "Bogu";
            case 3:
                return "Stores";
            default:
                return null;
        }
    }
}
