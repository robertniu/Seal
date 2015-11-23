package com.chenhan.seal;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import at.abraxas.amarino.Amarino;


public class SealActivity extends Activity implements OnClickListener{
private static final String TAG = "SEAL";

	//private static final String DEVICE_ADDRESS = "07:12:04:13:30:04"; //MJKDZ linvor
	private static final String DEVICE_ADDRESS = "00:15:FF:F3:CD:4E"; //YFRobot
	int red=1;
    Button bnFront;
    Button bnBack;
    Button bnLeft;
    Button bnRight;
    Button bnStop;
    Button bnAll;
    Button bnPlay;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bnFront=(Button)findViewById(R.id.bnfront);
        //bnFront.setOnClickListener(this);
        bnFront.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   front();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					   stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
      
        bnBack=(Button)findViewById(R.id.bnback);
        bnBack.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   back();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					   stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
        bnLeft=(Button)findViewById(R.id.bnleft);
        bnLeft.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   left();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					   stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
        bnRight=(Button)findViewById(R.id.bnright);
        bnRight.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   right();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					   stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
        bnAll=(Button)findViewById(R.id.bnall);
        bnAll.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   all();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					   stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
        bnPlay=(Button)findViewById(R.id.bnplay);
        bnPlay.setOnTouchListener(new OnTouchListener(){

			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				 switch (arg1.getAction()) {
				   
				   case MotionEvent.ACTION_DOWN:
				   {
				    //按住事件发生后执行代码的区域
					   play();
				    break;
				   }
				   case MotionEvent.ACTION_MOVE:
				   {
				    //移动事件发生后执行代码的区域
				    break;
				   }
				   case MotionEvent.ACTION_UP:
				   {
				    //松开事件发生后执行代码的区域
					  // stop();
				    break;
				   }
				   
				   default:
				    
				    break;
				   }
				return false;
			} 
        
        
        });
        
        Amarino.connect(this, DEVICE_ADDRESS);
        Log.d(TAG, "connect");
    }
	protected void onStop() {
		super.onStop();
		Amarino.disconnect(this, DEVICE_ADDRESS);
	}
    public void onClick(View target) {
        if (target == bnFront)
        	front();
        else if (target == bnBack)
            back();
        else if (target == bnLeft)
            left();
        else if (target == bnRight)
            right();
        else if (target == bnStop)
            stop();
        else if (target == bnAll)
            all();
        else if (target == bnPlay)
            all();

    }

	private void front(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'o', red);
	}
	private void back(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'p', red);
	}
	private void stop(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'q', red);
	}
	private void left(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'r', red);
	}
	private void right(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 's', red);
	}
	private void all(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 't', red);
	}
	private void play(){
		Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'u', red);
	}
}