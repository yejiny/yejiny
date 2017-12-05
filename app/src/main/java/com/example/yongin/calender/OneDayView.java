package com.example.yongin.calender;

import java.util.Calendar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yongin.calender.MConfig;
import com.example.yongin.calender.R;

public class OneDayView extends RelativeLayout {
 
    private static final String TAG = MConfig.TAG;
    private static final String NAME = "OneDayView";
    private final String CLASS = NAME + "@" + Integer.toHexString(hashCode());
    
    /** number text field */
    private TextView dayTv;
    /** message text field*/
    private TextView msgTv;
    /** Weather icon */
    private ImageView weatherIv;
    /** Value object for a day info */
    private OneDayData one;

    /**
     * OneDayView constructor
     * @param context context
     */
    public OneDayView(Context context) {
        super(context);
        init(context);
 
    }

    /**
     * OneDayView constructor for xml
     * @param context context
     * @param attrs AttributeSet
     */
    public OneDayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
 
    private void init(Context context)
    {

        View v = View.inflate(context, R.layout.activity_main, this);
        
        dayTv = (TextView) v.findViewById(R.id.onday_dayTv);
        weatherIv = (ImageView) v.findViewById(R.id.onday_weatherIv);
        msgTv = (TextView) v.findViewById(R.id.onday_msgTv);
        one = new OneDayData();
        
    }

    public void setDay(int year, int month, int day) {
        this.one.cal.set(year, month, day);
    }

    public void setDay(Calendar cal) {
        this.one.setDay((Calendar) cal.clone());
    }

    public void setDay(OneDayData one) {
        this.one = one;
    }

    public OneDayData getDay() {
        return one;
    }

    public void setMessage(String msg){
        one.setMessage(msg);
    }

    public CharSequence getMessage(){
        return  one.getMessage();
    }

    public int get(int field) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        return one.get(field);
    }

    public void setWeather(WeatherInfo.Weather weather) {
        this.one.setWeather(weather);
    }

    public void refresh() {
        
        //HLog.d(TAG, CLASS, "refresh");
        
        dayTv.setText(String.valueOf(one.get(Calendar.DAY_OF_MONTH)));

        if(one.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            dayTv.setTextColor(Color.RED);
        }
        else if(one.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            dayTv.setTextColor(Color.BLUE);
        }
        else {
            dayTv.setTextColor(Color.BLACK);
        }

        msgTv.setText((one.getMessage()==null)?"":one.getMessage());
        switch(one.weather) {
        case CLOUDY :
        case SUN_CLOUDY:
            weatherIv.setImageResource(R.drawable.cloudy);
            break;
        case RAINY:
            weatherIv.setImageResource(R.drawable.rainy);
            break;
        case SNOW :
            weatherIv.setImageResource(R.drawable.snowy);
            break;
        case SUNSHINE :
            weatherIv.setImageResource(R.drawable.sunny);
            break;
        }
        
    }
    
}