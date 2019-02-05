package hms;

import java.util.ArrayList;
import java.util.List;

public class Concurrency {
	
	public static void main(String[] args) throws Exception{
		for(int i=0,numberOfThreads = 100; i<1000;i++) {
			final Data data = new Data();
			final List<Thread> threads = new ArrayList<>(numberOfThreads);
			for(int j=0; j<numberOfThreads;j++) {
				final Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
				              final int value = data.getValue();
				              data.setValue(value + 1);
					}
				});
				thread.start();
				threads.add(thread);
			}
			
			for (final Thread thread : threads) {
		        thread.join();
		      }
			
			if (data.getValue() == numberOfThreads) {
		        System.out.println("Passed");
		      } else {
		        System.out.printf("Failed with value %d instead of %d%n", data.getValue(), numberOfThreads);
		        break;
		      }
		}
	}
}
