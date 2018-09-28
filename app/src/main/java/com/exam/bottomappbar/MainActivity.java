package com.exam.bottomappbar;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.exam.bottomappbar.Fragment.HomeFragment;
import com.exam.bottomappbar.Fragment.PlusButtonFragment;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private FragmentTransaction transaction = null;
    private FloatingActionButton fabs = null;
    private BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabs = (FloatingActionButton) findViewById(R.id.fabs);

        if (savedInstanceState == null) {
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContainerHome, HomeFragment.newInstance());
            transaction.commit();
        }

        fabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                    fabs.setImageResource(R.drawable.baseline_reply_white_24);
                    transaction = getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(HomeFragment.class.getSimpleName());
                    transaction.add(R.id.flContainerHome, PlusButtonFragment.newInstance());
                    transaction.commit();
                    detachFab();
                    moveToDetails();
                    //showSelectPhotoActivity();
                } else {
                    fabs.setImageResource(R.drawable.baseline_add_white_24);
                    detachFab();
                    returnToHome();
                    onBackPressed();
                }
            }
        });
        bottomAppBar = findViewById(R.id.bottom_appbar);
        setSupportActionBar(bottomAppBar);
        bottomAppBar.replaceMenu(R.menu.my_menu);
    }

    public void detachFab() {
        bottomAppBar.setFabAttached(false);
    }

    public void moveToDetails() {
        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        attachFab();
    }

    public void returnToHome() {
        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        attachFab();
        if (bottomAppBar.getFabAlignmentMode() == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
            fabs.setImageResource(R.drawable.baseline_add_white_24);
        }
    }

    public void attachFab() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomAppBar.setFabAttached(true);
            }
        }, 150);
    }

    @Override
    public void onBackPressed() {
        detachFab();
        returnToHome();
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.next_btn:
                Toast.makeText(this, "next_btn", Toast.LENGTH_SHORT).show();
                //bottomSheetDialog.show(getSupportFragmentManager(),"bottomSheet");
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "action_settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
