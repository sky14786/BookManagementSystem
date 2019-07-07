package application.kh.bms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import application.kh.bms.model.dao.LoadSave;
import application.kh.bms.model.vo.User;

public class RentalController {
   
   private String userId = "";
   private LoadSave dao = LoadSave.getDao();
   private ArrayList<User> users = new ArrayList<User>();
   
   private HashMap<String, GregorianCalendar> rentalBook = new HashMap<String, GregorianCalendar>();
   
   //�뿩���� �߰��ϱ�
   public void addRetalBook(String bookCode) {
      
      System.out.println("�ֵ巻Ż�� �޼ҵ� ����");
//      System.out.println("�뿩�� �ڵ� �Ѱܹ��� �� : "+bookCode);
      
      //���糯¥ �޾ƿ� 7�� ���� �ݳ���¥ �����
      GregorianCalendar cal = new GregorianCalendar(Locale.KOREA);
       //cal.setTime(new Date());
       cal.add(cal.DATE, 7);
       Date tD = new Date(cal.getTimeInMillis());
       System.out.println("�Էµ� �ݳ� ��¥ : " + tD);
       
       //Ȯ�ο�
       //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
       //String strDate = df.format(cal.getTime());

      rentalBook.put(bookCode, cal);   //å�ڵ�,�ݳ���¥ ����
      userId = dao.getNowUser();   //���� ����
      users = dao.loadUser();      //��ü ����
      
      //��ü �������� ���� ���� ã�� �뿩����(�ؽ���) �߰����ֱ�
      for(int i=0; i<users.size(); i++) {
         System.out.println("���� ������~ " + i);
         if(users.get(i).getId().equals(userId)) {
            users.get(i).addRentalList(rentalBook);
            System.out.println(userId + " // " + users.get(i).getRetalList());
            dao.saveUser(users);
            break;
         }
      }
      
   }
   
   
   //�뿩���� �ݳ��ϱ�
   public int delRentalBook(String bookCode) {
      System.out.println("����Ʈ��Ż�� �޼ҵ� ����");
      
      userId = dao.getNowUser();   //���� ����
      users = dao.loadUser();      //��ü ����
      long result = 0;
      
      for(int i=0; i<users.size(); i++) {
         if(users.get(i).getId().equals(userId)) {   //���� ���� ã��
            GregorianCalendar today = new GregorianCalendar(Locale.KOREA); //���ó�¥
            GregorianCalendar returnDate = (GregorianCalendar) users.get(i).getRetalList().get(bookCode); //�ݳ�����
            
             Date tD = new Date(today.getTimeInMillis());
             Date rD = new Date(returnDate.getTimeInMillis());
             
             System.out.println("���糯¥ : " + tD);
             System.out.println("�ݳ����� : " + rD);
                 
             // �ð����̸� �ð�,��,�ʸ� ���� ������ ������ �Ϸ� ������ ����
             long sub = rD.getTime() - tD.getTime();   //�ݳ���¥���� ���ó�¥ ����
             result = sub / (24 * 60 * 60 * 1000);
             System.out.println("��¥����=" + result);
             
            users.get(i).getRetalList().remove(bookCode);
            dao.saveUser(users);
             
            if(result < 0) {   //��ü
               return 1;
            }
            else {   //����ݳ�
               return 0;
            }
         }
      }
      return -999;
   }
   
}
