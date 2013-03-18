package srclib.huyanwei.notify;

import android.os.Bundle;

import android.view.View.OnClickListener;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	//声明通知（消息）管理器	
	NotificationManager m_NotificationManager;	
	Intent  m_Intent;	
	PendingIntent m_PendingIntent;	
	
	//声明Notification对象	
	Notification  m_Notification;
	
	Button btn1 , btn2 ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      
        btn1=(Button)findViewById(R.id.btn_notification_start);
        btn1.setOnClickListener(this);

        btn2=(Button)findViewById(R.id.btn_notification_stop);
        btn2.setOnClickListener(this);

      //初始化NotificationManager对象
      m_NotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
      
    }
    
    public void onClick(View view){
    	  switch (view.getId()) {
    	  		case R.id.btn_notification_start:
    	  			showNotification();
    	  			break;
    	  		case R.id.btn_notification_stop:
    	  			cancelNotification();
    	  			break;
    	  		default:
    	  			break;
    	  }
  	 }

    /** 设置 */
     private void showNotification(){
      //点击通知时转移内容
      //Intent intent = new Intent(this, this.getClass());
      //intent.addCategory(WINDOW_SERVICE);
      //主要是设置点击通知时显示内容的类
      m_PendingIntent = PendingIntent.getActivity(MainActivity.this, 0, getIntent(), 0); //如果转移内容则用m_Intent();
      //构造Notification对象
      m_Notification = new Notification();
      //设置通知在状态栏显示的图标
      m_Notification.icon = R.drawable.ic_launcher;
      //当我们点击通知时显示的内容
      m_Notification.tickerText = "胡艳伟测试LED灯通知消息......";
      //通知时发出默认的声音
      m_Notification.defaults = Notification.DEFAULT_SOUND;
      //设置通知显示的参数
      m_Notification.setLatestEventInfo(MainActivity.this, "LED灯", "胡艳伟测试LED灯", m_PendingIntent);
      //可以理解为执行这个通知
      m_NotificationManager.notify(0, m_Notification);
     }

     /** 取消 */
     private void cancelNotification(){
          m_NotificationManager.cancelAll();
     }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
