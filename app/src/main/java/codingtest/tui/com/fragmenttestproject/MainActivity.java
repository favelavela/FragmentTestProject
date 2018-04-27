package codingtest.tui.com.fragmenttestproject;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements PlusOneFragment.OnFragmentInteractionListener{

    MainActivityFragment mainActivityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment plusOneFragment = new PlusOneFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.add(R.id.layout_for_fragment, plusOneFragment);
        fragmentTransaction.commit();

        mainActivityFragment = new MainActivityFragment();

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.add(R.id.layout_for_second_fragment, mainActivityFragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onFragmentInteraction(String text) {
        mainActivityFragment.setTextToSecondFragment(text);
    }
}
