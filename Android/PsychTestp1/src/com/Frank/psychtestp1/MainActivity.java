package com.Frank.psychtestp1;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity
{
    private static final String TAG = null;
    private int number;
    private TextView textfield;
    private Handler handler;
    private boolean Running = true;
    int sum;
    int countI=0;
    int countMax=5;
    int avg;
    TIME time= new TIME();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textfield = (TextView) findViewById(R.id.TVtimer);
        handler = new Handler();
        
       
        

        final Runnable runnable = new Runnable()
        {

            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                // random number
                
                int minimum = 1000;
                double maximum = 8000;
                int randomNum = minimum + (int) (Math.random() * maximum);
                //

                sleepy(randomNum);
               
                number=0;
                while (Running)
                {
                    time.start();
                    sleepy(10);
                    time.pause();
                    handler.post(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            number = time.now();
                            textfield.setText(String.valueOf(number));

                        }

                    });
                }
                
                Running = true;
               // number=0;
            }

        };
        new Thread(runnable).start();
        RelativeLayout rlayout = (RelativeLayout) findViewById(R.id.MainLay);
       
        rlayout.setOnTouchListener(new OnTouchListener () {
            
          
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                  Log.d("TouchTest", "Touch down");
                  if (number > 0)
                  {
                      Running = false;
                      time.pause();
                      
                      return true;
                  }
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                  Log.d("TouchTest", "Touch up");
                  sleepy(3000);
                  textfield.setText("again");
                  time.function();
                  
                  new Thread(runnable).start();
                  
                }return false;
                
                
              }
            });
        
       /* rlayout.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                if (number > 0)
                {
                    Running = false;
                    releasePossible=true;

                }
            }
           
            

        });*/
        
    }
    //public boolean onTouchEvent(MotionEvent event) {
     //   Log.d(TAG,""+event.getAction());
     //   return true; // Required for recieving subsequent events (ACTION_MOVE, ACTION_UP)
//}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void sleepy(int time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    public class TIME
    {
        private int NOW = 0,
                    START = 0;
        private boolean PAUSED = true;

        public int now() {
            return PAUSED ? NOW : NOW + (int)System.currentTimeMillis() - START;
        }
        public void start  () {
            if (PAUSED) {
                PAUSED = false;
                START = (int)System.currentTimeMillis();
            }
        }
        public void pause () {
            if (!PAUSED) {
                PAUSED = true;
                NOW += (int)System.currentTimeMillis() - START;
            }
        }
        public void function () {
            NOW = 0;
            START = 0;
            PAUSED = true;
        }
    }

}
