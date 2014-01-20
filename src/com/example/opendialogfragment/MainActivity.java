package com.example.opendialogfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String> ( this, android.R.layout.simple_list_item_1, Country.name );
		setListAdapter(adapter);
		
		
		OnItemClickListener listener = new OnItemClickListener()
		{
			@Override
			public void onItemClick ( AdapterView<?> arg0, View arg1, int position, long pid )
			{
				TimeDialogFragment tFragment = new TimeDialogFragment();
				Bundle b = new Bundle(); 
				b.putInt( "position", position );
				tFragment.setArguments(b);
				
				FragmentManager manager = getFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction(); 
				
				TimeDialogFragment tPrev = (TimeDialogFragment) manager.findFragmentByTag( "time_dialog" );
				
				if ( tPrev != null )
				{
					transaction.remove(tPrev);
				}
				
				tFragment.show( transaction, "time_dialog" );
			}
		};
		getListView().setOnItemClickListener(listener);
	}
}