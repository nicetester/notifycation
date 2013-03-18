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

	//����֪ͨ����Ϣ��������	
	NotificationManager m_NotificationManager;	
	Intent  m_Intent;	
	PendingIntent m_PendingIntent;	
	
	//����Notification����	
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

      //��ʼ��NotificationManager����
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

    /** ���� */
     private void showNotification(){
      //���֪ͨʱת������
      //Intent intent = new Intent(this, this.getClass());
      //intent.addCategory(WINDOW_SERVICE);
      //��Ҫ�����õ��֪ͨʱ��ʾ���ݵ���
      m_PendingIntent = PendingIntent.getActivity(MainActivity.this, 0, getIntent(), 0); //���ת����������m_Intent();
      //����Notification����
      m_Notification = new Notification();
      //����֪ͨ��״̬����ʾ��ͼ��
      m_Notification.icon = R.drawable.ic_launcher;
      //�����ǵ��֪ͨʱ��ʾ������
      m_Notification.tickerText = "����ΰ����LED��֪ͨ��Ϣ......";
      //֪ͨʱ����Ĭ�ϵ�����
      m_Notification.defaults = Notification.DEFAULT_SOUND;
      //����֪ͨ��ʾ�Ĳ���
      m_Notification.setLatestEventInfo(MainActivity.this, "LED��", "����ΰ����LED��", m_PendingIntent);
      //�������Ϊִ�����֪ͨ
      m_NotificationManager.notify(0, m_Notification);
     }

     /** ȡ�� */
     private void cancelNotification(){
          m_NotificationManager.cancelAll();
     }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
