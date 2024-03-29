package com.example.admin.materialdesigndemo;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Toolbar toolbar=(Toolbar)findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        drawerLayout=(DrawerLayout)findViewById( R.id.drawer_layout );
        NavigationView navView=(NavigationView) findViewById( R.id.nav_view );
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled( true );
            actionBar.setHomeAsUpIndicator( R.drawable.ic_menu_black_24dp );
        }
        navView.setCheckedItem( R.id.nav_call );
        navView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        } );

        FloatingActionButton fab=(FloatingActionButton)findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText( MainActivity.this,"fab",Toast.LENGTH_SHORT ).show();
                Snackbar.make( v,"date delete", Snackbar.LENGTH_SHORT)
                        .setAction( "undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText( MainActivity.this,"data restored",Toast.LENGTH_SHORT ).show();
                            }
                        } ).show();
            }
        } );



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate( R.menu.toolbar,menu );
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.backup:
                Toast.makeText(this,"u click backup",Toast.LENGTH_SHORT) .show();break;
            case R.id.delete:
                Toast.makeText(this,"u click delete",Toast.LENGTH_SHORT).show();break;
            case R.id.settings:
                Toast.makeText(this,"u click settings",Toast.LENGTH_SHORT).show();break;
            case android.R.id.home:
                drawerLayout.openDrawer( GravityCompat.START );break;
            default:
        }
        return true;
    }
}
