import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock{

  private static int hour;
  private static int minute;
  private static int second;
  private static int AM_PM;
  
  private static String hourTxt;
  private static String minTxt;
  private static String secTxt;
  
  private static JLabel timeLabel;
  private static String time;
  
  public static void main(String[] args){
    
    JFrame frame = new JFrame("JFrame");
    frame.setSize(300,110);
    frame.setVisible(true);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(Color.BLACK);
    
    timeLabel = new JLabel();
    timeLabel.setText("00:00:00");
    timeLabel.setForeground(Color.GREEN);
    timeLabel.setFont(new Font("Ariel", Font.PLAIN, 60));
    
    frame.setLayout(new FlowLayout());
    
    new Thread(){
      public void run(){
	while(true){
	  Calendar cal = new GregorianCalendar();
	  hour = cal.get(Calendar.HOUR);
	  minute = cal.get(Calendar.MINUTE);
	  second = cal.get(Calendar.SECOND);
	  AM_PM = cal.get(Calendar.AM_PM);
	  
	  if(AM_PM == 1){
	    hour = hour + 12;
	  }
	  
	  hourTxt = "" + hour;
	  minTxt = "" + minute;
	  secTxt = "" + second;
	  
	  if(hour < 10){
	    hourTxt = "0" + hour;
	  }
	  if(minute < 10){
	    minTxt = "0" + minute;
	  }
	  if(second < 10){
	    secTxt = "0" + second;
	  }
	  
	  time = hourTxt + ":" + minTxt + ":" + secTxt;
	  timeLabel.setText(time);
	  
	}
      }
    }.start();
    
    frame.add(timeLabel);
    
  }
  
}