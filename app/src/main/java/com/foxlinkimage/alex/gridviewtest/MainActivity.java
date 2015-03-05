package com.foxlinkimage.alex.gridviewtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends ActionBarActivity {
    private GridView gridView;
    private int[] image = {
            R.drawable.mouse,
            R.drawable.cow,
            R.drawable.tiger,
            R.drawable.rabbit,
            R.drawable.dragon,
            R.drawable.snake,
            R.drawable.horse,
            R.drawable.goat,
            R.drawable.monkey,
            R.drawable.chicken,
            R.drawable.dog,
            R.drawable.pig
    };

    private String[] imgText = {"鼠","牛","虎","兔","龍","蛇","馬","羊","猴","雞","狗","豬"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for(int i =0;i < imgText.length;i++)
        {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("image", image[i]);
            item.put("text",imgText[i]);
            items.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, items,R.layout.grid_item, new String[]{"image","text"}, new int[]{R.id.image,R.id.text});

        gridView = (GridView)findViewById(R.id.main_page_gridview);
        gridView.setNumColumns(3);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Your choice is "+imgText[position],Toast.LENGTH_SHORT).show();
                view.setBackgroundColor(Color.BLUE);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
