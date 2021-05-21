package edu.umb.cs681.hw17;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	// hashmap
	ConcurrentHashMap <java.nio.file.Path, AtomicInteger> hashMap = new ConcurrentHashMap <java.nio.file.Path, AtomicInteger>();
	// static lock
	private static ReentrantLock staticLock = new ReentrantLock();
	// instance
	private static AccessCounter instance = null;
	
	private AccessCounter(){}
	
	
	public static AccessCounter getInstance()
	{
		staticLock.lock();
		try {
			if(instance==null)
			{
				instance = new AccessCounter();
			}
		} finally {
			staticLock.unlock();
		}
		return instance;
	}

	public void increment(java.nio.file.Path path)
	{
		hashMap.compute(path, (java.nio.file.Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + 1);
				return new AtomicInteger(1);
			} else {
				System.out.println(Thread.currentThread().getName() + " increase " + path + " to " + (v.get()+1));
				return new AtomicInteger(v.incrementAndGet());
			}
		});
	}

	public int getCount(java.nio.file.Path path)
	{
		return hashMap.compute(path, (java.nio.file.Path k, AtomicInteger v) -> {
			if(v == null) {
				System.out.println(Thread.currentThread().getName() + " get " + path + " count " + 0);
				return new AtomicInteger(0);
			} else {
				System.out.println(Thread.currentThread().getName() + " get " + path + " count " + v.get());
				return v;
			}
		}).get();
	}

	
}
