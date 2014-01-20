package com.example.opendialogfragment;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeDialogFragment extends DialogFragment 
{

	@Override
	public View onCreateView ( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState )
	{
		View view = inflater.inflate( R.layout.dialog_layout , null ); 
		Bundle b = getArguments();
		getDialog().setTitle( "Time @ " + Country.name[b.getInt("position")] );
		TextView tv = (TextView) view.findViewById( R.id.current_time );
		tv.setText( getCurTime(b.getInt("position")) );
		
		return view;
	}
	
	public String getCurTime( int position )
	{
		String curTime = "";
		
		TimeZone timeZone = TimeZone.getTimeZone( Country.tz[position] );
		DateFormat df = DateFormat.getDateTimeInstance ( DateFormat.FULL,DateFormat.SHORT );
		df.setTimeZone(timeZone);
		Date d = new Date(); 
		curTime = df.format(d);
		return curTime;
	}
}