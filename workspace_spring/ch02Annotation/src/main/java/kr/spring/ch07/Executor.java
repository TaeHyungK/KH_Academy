package kr.spring.ch07;

public class Executor {
	private Worker worker;

	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	public void addUnit() {
		worker.work();
	}
}
