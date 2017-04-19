/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        final ArrayList<EarthquakeList> earthquakes = QueryUtils.extractEarthquakes();
        /*final ArrayList<EarthquakeList> earthquakes = new ArrayList<EarthquakeList>();
        earthquakes.add(new EarthquakeList(5.2 , "San Francisco", 150606049));
        earthquakes.add(new EarthquakeList(3.7 ,"London", 150606049));
        earthquakes.add(new EarthquakeList(2.7 ,"Tokyo",150606049));
        earthquakes.add(new EarthquakeList(5.8 ,"Mexico City",150606049));
        earthquakes.add(new EarthquakeList(3.0 ,"Moscow",150606049));
        earthquakes.add(new EarthquakeList(3.1 ,"Rio de Janeiro",150606049));
        earthquakes.add(new EarthquakeList(1.1 ,"Paris",150606049));
*/
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Create a new {@link ArrayAdapter} of earthquakes
        EarthQuakeListAdapter adapter = new EarthQuakeListAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);


        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView adapterView,View view, int position, long l){
                String url = earthquakes.get(position).getURL();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
