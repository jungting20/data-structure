
public class DiningPhilosophers {
	//�� "��ũ"�� �׳� Object ��ü�� �����ϰ� ��ũ�� ���� ����ȭ��Ų��.
	private Object[] forks;
	private Philosopher[] philosophers;
	//��ũ�� ö���ڵ��� �غ��Ѵ�.
	private DiningPhilosophers(int num){
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for(int i = 0; i < num; i++){
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i+1)%num;
			if(i == 0){
				philosophers[i] = new Philosopher(i, fork2, fork1);
			}else{
				philosophers[i] = new Philosopher(i, fork1, fork2);
			}
		}
	}
	//�Ա����
	public void startEating() throws InterruptedException{
		for(int i = 0; i < philosophers.length; ++i){
			philosophers[i].start();
		}
		/* ù ���� ö���ڰ� �Դ� ���� �ߴ��� ������ �����带
		 * �ߴܽ�Ų��. ������ ù ��° ö���ڰ� �Դ� ���� �ߴ��ϴ�
		 * ���� �Ͼ�� �����Ƿ� �ùķ��̼��� ������ ���ư���. 
		 */
		philosophers[0].join();
	}
	
	//�� ö���ڴ� ���� �ٸ� �����忡�� ���ư�
	private class Philosopher extends Thread{
		private int id;
		private int fork1;
		private int fork2;
		
		Philosopher(int id, int fork1, int fork2){
			this.id = id;
			this.fork1 = fork1;
			this.fork2 = fork2;
		}
		
		public void run(){
			status("Ready to eat using forks " + fork1 + "and " + fork2);
			while(true){
				status("Picking up fork " + fork1);
				synchronized(forks[fork1]){
					status("Picking up for " + fork2);
					synchronized(forks[fork2]){
						status("Eating");
					}
				}
			}
		}
		
		private void status(String msg){
			System.out.println("Philosopher " + id + ": " + msg);
		}
	}
	
	public static void main(String[] args){
		try{
			DiningPhilosophers d = new DiningPhilosophers(5);
			d.startEating();
		}
		catch(InterruptedException e){
			
		}
	}
}
