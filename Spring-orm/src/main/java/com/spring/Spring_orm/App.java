package com.spring.Spring_orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Spring_orm.entity.Learner;
import com.spring.Spring_orm.services.LearnerDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    
    LearnerDao learnerDao=context.getBean("learnerService",LearnerDao.class);
   
//    Learner learner=new Learner(1,"keerti","bhopal");
//    int r=learnerDao.insert(learner);
//    System.out.println("Data inserted..."+r);
    
    Scanner s=new Scanner(System.in);
    
    Boolean go=true;
	
	while(go) {
    
    System.out.println("press 1 to insert new learner");
    System.out.println("press 2 to get all learner's data");
    System.out.println("press 3 to display learner data by id");
    System.out.println("press 4 to delete learner data");
    System.out.println("press 5 to update data");
    System.out.println("press 6 to exit");
    
    System.out.println("Enter your choice...");
    
    int c=s.nextInt();
    
    switch(c) {
    
    case 1:
    	
    	System.out.println("Enter learner id");
    	int id=s.nextInt();
    	
    	System.out.println("Enter learner name");
    	String lname=s.next();
    	
    	System.out.println("Enter learner city");
        String lcity=s.next();  
    	
    	
        Learner l=new Learner();
    	l.setlId(id);
    	l.setLname(lname);
    	l.setLcity(lcity);
    	
    
		int r = learnerDao.insert(l);

    	System.out.println("data inserted!!!");
    	
    	
    	break;
    
    case 2:List<Learner> allLearners = learnerDao.getAllLearners();
	for(Learner l1:allLearners)
	{
		System.out.println("******************************************************");
		//System.out.println(l1);
		System.out.println("Id="+l1.getlId());
		System.out.println("Name="+l1.getLname());
		System.out.println("city="+l1.getLcity());
		System.out.println();
		System.out.println("******************************************************");
	}
    	break;
    
    case 3:
		System.out.println("enter any id whose data you wanna display");
		int id2=s.nextInt();
		
		Learner l2 = learnerDao.getLearner(id2);
		
		
		System.out.println("******************************************************");
		//System.out.println(l2);
		System.out.println("Id="+l2.getlId());
		System.out.println("Name="+l2.getLname());
		System.out.println("city="+l2.getLcity());
		System.out.println();
		System.out.println("******************************************************");
		
    	break;
   
    case 4:System.out.println("enter the id whose data you wanna delete!!!");
	int id3=s.nextInt();
	
	learnerDao.deleteLearner(id3);
	System.out.println("learner data got deleted!!!!");
	
	break;
	
    
    case 5:
    	System.out.println("enter the id whose data you wanna update!!!!");
		int id4=s.nextInt();
		
		System.out.println("enter new name");
		String name2= s.next();
		
		System.out.println("enter new city");
		String city2= s.next();
		
		Learner l3= new Learner();
		l3.setlId(id4);
		l3.setLname(name2);
		l3.setLcity(city2);
		
		
		learnerDao.updateLearner(l3);
		System.out.println("Data got updated!!!!");
		
    	break;
    
    case 6:
    	go=false;
	break;
	
	default:
		System.out.println("wrong choice!!!!");
    	break;
    
    }
    }

    
    }
    }

