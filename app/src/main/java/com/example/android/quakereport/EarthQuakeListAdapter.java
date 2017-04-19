package com.example.android.quakereport;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by calencastro on 26/03/2017.
 */

public class EarthQuakeListAdapter extends ArrayAdapter<EarthquakeList> {

    public EarthQuakeListAdapter(Activity context, ArrayList<EarthquakeList> EarthquakeLists) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for three TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, EarthquakeLists);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_earthquake, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        EarthquakeList currentEarthQuake = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView textMagView = (TextView) listItemView.findViewById(R.id.textMag);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        Double cMag = currentEarthQuake.getMag();
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        textMagView.setText(magnitudeFormat.format(cMag));

        GradientDrawable magnitudeCircle = (GradientDrawable) textMagView.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(cMag));

        // Find the TextView in the list_item.xml layout with the ID version_number

        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        String location = currentEarthQuake.getLocation();
        String main;
        String nearLocation;
        if(location.contains(" of "))
        {
            String[] locationParts = location.split(" of ");
            main = locationParts[1];
            nearLocation = locationParts[0] + " of ";
        }
        else
        {
            main = location;
            nearLocation = getContext().getString(R.string.near);
        }

        TextView textNearLocationView = (TextView) listItemView.findViewById(R.id.textNearLocation);
        textNearLocationView.setText(nearLocation);
        TextView textLocationView = (TextView) listItemView.findViewById(R.id.textLocation);
        textLocationView.setText(main);




        //SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm DD/MM/YYYY");
        long cDateTime = currentEarthQuake.getDate();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("DD-MM-yyyy",Locale.US);
        String dateToDisplay = dateFormatter.format(new Date(cDateTime));

        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm",Locale.US);
        String timeToDisplay = timeFormatter.format(new Date(cDateTime));



        TextView textDateView = (TextView) listItemView.findViewById(R.id.textDate);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        textDateView.setText(dateToDisplay);

        TextView textTimeView = (TextView) listItemView.findViewById(R.id.textTime);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        textTimeView.setText(timeToDisplay);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double mag){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(mag);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
