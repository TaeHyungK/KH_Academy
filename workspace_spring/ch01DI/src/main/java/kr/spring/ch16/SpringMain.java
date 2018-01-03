package kr.spring.ch16;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		//Singleton
		Worker worker = (Worker) context.getBean("worker");
		System.out.println(worker);
		
		Worker worker2 = (Worker) context.getBean("worker");
		System.out.println(worker2);
		
		System.out.println("----------------");
		
		WorkerA workerA = (WorkerA) context.getBean("workerA");
		System.out.println(workerA);
		
		WorkerA workerA2 = (WorkerA) context.getBean("workerA"); 
		System.out.println(workerA2);
		
		System.out.println("----------------");
		
		//서로 다른 범위의 빈에 대한 의존 처리
		Executor executor = (Executor) context.getBean("executor");
		System.out.println(executor+ ", " +executor.getWorkerB());
		
		Executor executor2 = (Executor) context.getBean("executor");
		System.out.println(executor2 + ", " + executor2.getWorkerB());
		
		
		context.close();
	}
}
