package Demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo_01 {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("========欢迎来到学生管理系统========");
		System.out.println("1 添加学生");
		System.out.println("2 删除学生");
		System.out.println("3 修改学生");
		System.out.println("4 查看所有学生");
		System.out.println("5  退出");
		
		ArrayList<Student> list=new ArrayList<>();
		
		
		wc:while(true) {
			
			System.out.println("请输入你的选择");
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
					System.out.println("退出，欢迎下次使用！");
					break wc;
				default:
					System.out.println("录入选择有误");
					break;
			}
		}	
	}

	private static void changeStudent(ArrayList<Student> list) {
		System.out.println("录入要修改学生的学号：");
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
			System.out.println("录入修改学生的名字：");
			String name=sc.nextLine();
			
			System.out.println("录入修改学生的年龄：");
			int age=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("录入修改学生的地址：");
			String address=sc.nextLine();
			
			Student newStudent=new Student(sid,name,age,address);
			
			list.set(index, newStudent);
			System.out.println("修改成功！");
		}else {
			System.out.println("学号不存在，请重新录入........");
		}
		
	}

	private static void deleteStudent(ArrayList<Student> list) {
		if(list.size()==0) {
			System.out.println("请先添加学生。。。");
		}else {
			System.out.println("请输入要删除的学号");
			String s=sc.nextLine();
			boolean flag=false;//false：要删除的学生不存在
			
			int index=-1;//记录的是要删除学生在集合中的索引
			for(int i=0;i<list.size();i++) {
				Student stu=list.get(i);
				
				if(stu.getSid().equals(s)){
					flag=true;
					index=i;
					break;
				}
			}
			if(flag) {
				//说明键盘录入的学号在集合中存在
				list.remove(index);
				System.out.println("删除成功");
			}else {
				//说明键盘录入的学号在集合中不存在
				System.out.println("录入的学号不存在");
			}
		}
		
		
	}

	private static void addStudent(ArrayList<Student> list) {
		
		System.out.println("请输入学生的学号");
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
			System.out.println("学号已经存在，请重新录入....");
		}else {
			System.out.println("请输入学生的姓名：");
			String name=sc.nextLine();
			
			System.out.println("请输入学生的年龄");
			int age=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("请输入学生的地址");
			String address=sc.nextLine();
			Student s=new Student(sid,name,age,address);
			list.add(s);
			
			System.out.println("添加成功！");
		}
		
		
		
	}

	private static void selectStudent(ArrayList<Student> list) {
		if(list.size()==0) {
			System.out.println("请先添加学生：....................");
		}else {
			System.out.println("学号\t姓名\t年龄\t地址");
			for(int i=0;i<list.size();i++) {
				Student s=list.get(i);
				System.out.println(s.getSid()+"\t"+s.getName()+"\t"+s.getAge()+"\t"+s.getAddress());
			}
		}	
	}
}
