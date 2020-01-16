package Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo_01 {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("========��ӭ����ѧ������ϵͳ========");
		System.out.println("1 ���ѧ��");
		System.out.println("2 ɾ��ѧ��");
		System.out.println("3 �޸�ѧ��");
		System.out.println("4 �鿴����ѧ��");
		System.out.println("5  �˳�");
		
		ArrayList<Student> list=new ArrayList<>();
		
		
		wc:while(true) {
			
			System.out.println("���������ѡ��");
			String s=sc.nextLine();
			
			switch(s) {
				case"1":
					addStudent(list);					
					break;
				case"2":
					deleteStudent(list);
					break;
				case"3":
					changeStudent(list);
					break;
				case"4":
					selectStudent(list);
					break;
				case"5":
					System.out.println("�˳�����ӭ�´�ʹ�ã�");
					break wc;
				default:
					System.out.println("¼��ѡ������");
					break;
			}
		}	
	}

	private static void changeStudent(ArrayList<Student> list) {
		System.out.println("¼��Ҫ�޸�ѧ����ѧ�ţ�");
		String sid=sc.nextLine();
		
		boolean flag=false;
		int index=-1;
		for(int i=0;i<list.size();i++) {
			Student s=list.get(i);
			if(sid.equals(s.getSid())) {
				flag=true;
				index=i;
				break;
			}
		}
		if(flag==true) {
			System.out.println("¼���޸�ѧ�������֣�");
			String name=sc.nextLine();
			
			System.out.println("¼���޸�ѧ�������䣺");
			int age=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("¼���޸�ѧ���ĵ�ַ��");
			String address=sc.nextLine();
			
			Student newStudent=new Student(sid,name,age,address);
			
			list.set(index, newStudent);
			System.out.println("�޸ĳɹ���");
		}else {
			System.out.println("ѧ�Ų����ڣ�������¼��........");
		}
		
	}

	private static void deleteStudent(ArrayList<Student> list) {
		if(list.size()==0) {
			System.out.println("�������ѧ��������");
		}else {
			System.out.println("������Ҫɾ����ѧ��");
			String s=sc.nextLine();
			boolean flag=false;//false��Ҫɾ����ѧ��������
			
			int index=-1;//��¼����Ҫɾ��ѧ���ڼ����е�����
			for(int i=0;i<list.size();i++) {
				Student stu=list.get(i);
				
				if(stu.getSid().equals(s)){
					flag=true;
					index=i;
					break;
				}
			}
			if(flag) {
				//˵������¼���ѧ���ڼ����д���
				list.remove(index);
				System.out.println("ɾ���ɹ�");
			}else {
				//˵������¼���ѧ���ڼ����в�����
				System.out.println("¼���ѧ�Ų�����");
			}
		}
		
		
	}

	private static void addStudent(ArrayList<Student> list) {
		
		System.out.println("������ѧ����ѧ��");
		String sid=sc.nextLine();
		boolean flag=false;
		
		for(int i=0;i<list.size();i++) {
			Student s=list.get(i);
			if(s.getSid().equals(sid)) {
				flag=true;
				break;
			}
		}
		
		if(flag==true) {
			System.out.println("ѧ���Ѿ����ڣ�������¼��....");
		}else {
			System.out.println("������ѧ����������");
			String name=sc.nextLine();
			
			System.out.println("������ѧ��������");
			int age=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("������ѧ���ĵ�ַ");
			String address=sc.nextLine();
			Student s=new Student(sid,name,age,address);
			list.add(s);
			
			System.out.println("��ӳɹ���");
		}
		
		
		
	}

	private static void selectStudent(ArrayList<Student> list) {
		if(list.size()==0) {
			System.out.println("�������ѧ����....................");
		}else {
			System.out.println("ѧ��\t����\t����\t��ַ");
			for(int i=0;i<list.size();i++) {
				Student s=list.get(i);
				System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
			}
		}	
	}
}
