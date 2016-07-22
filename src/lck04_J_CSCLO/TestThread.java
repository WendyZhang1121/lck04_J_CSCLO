package lck04_J_CSCLO;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestThread implements Runnable {
	
	private final Map<Integer, String> mapView = Collections.synchronizedMap(new HashMap<Integer, String>());
	private final Set<Integer> setView = mapView.keySet();
	public Map<Integer, String> getMap() { 
		return mapView;
	}
	
	public void run() {
		synchronized (mapView) { // Synchronize on map, rather than set
			for (Integer k : setView) { // ...
			} 
		}
	}
	
	public static void main(String[] args) throws Exception { 
		
		TestThread t = new TestThread();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
	}
}
