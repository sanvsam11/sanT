package codingRound;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 23/02/17.
 * getvalue
 * add new entries to cache
 * specify ttl for each key(specified by the user)
 * pluggable
 * memory
 * eviction strategy
 * <p/>
 * key<size
 */
public class TTLCache implements cache {

    cacheMemory memory;
    int size;
    cacheElement[] cache;
    Thread userThread, evictionThread;
    volatile boolean shutdownCache = false;

    public TTLCache(int size) {
        memory = new mainMemory(size);
        cache = new cacheElement[size];
        this.size = size;
        System.out.println("1. Add key and value and time to live\n2. Get Value for key\n 3.Remove value for key\n4. Display Cache\n5.Quit");

    }

    public void startCache() {
        userThread();
        EvictionThread();
        userThread.start();
        evictionThread.start();
        try {
            userThread.join();
            evictionThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void userThread() {
        userThread = new Thread(new Runnable() {
            @Override
            public void run() {

                Scanner in = new Scanner(System.in);
                while (!shutdownCache) {
                    System.out.println("Enter your choice:");
                    int choice = in.nextInt();
                    if (choice == 5) {
                        shutdownCache = true;
                    }
                    if (choice == 1) {
                        if (memory.isFull()) System.out.println("Memory is full. Try later. (TTL duh)");
                        int key = in.nextInt();
                        int value = in.nextInt();
                        int ttl = in.nextInt();
                        cache[key] = new cacheElement();
                        cache[key].add(key, ttl);
                        memory.putValue(key, value);
                    }
                    if (choice == 2) {
                        int key = in.nextInt();
                        if (!memory.containsKey(key)) System.out.println("Key has no value.");
                        System.out.println("Key: " + key + " ,Value: " + memory.getValue(key));
                    }
                    if (choice == 3) {
                        int key = in.nextInt();
                        if (!memory.containsKey(key)) System.out.println("Key has no value.");
                        System.out.println("Removed value :" + memory.removeValue(key));
                    }
                    if (choice == 4) {
                        memory.printValues();
                    }
                }
            }
        });
    }

    void EvictionThread() {
        evictionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!shutdownCache) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < size; i++) {
                        if (cache[i] == null) continue;
                        int ttl = cache[i].getTTL();
                        ttl--;
                        if (ttl == 0) {
                            memory.removeValue(cache[i].getKey());
                            cache[i] = null;
                        } else cache[i].putTTL(ttl);
                    }
                }
            }
        });
    }

}

class cacheElement {
    int ttl = 0, key = 0;

    public void add(int key, int ttl) {
        this.ttl = ttl;
        this.key = key;
    }

    public int getTTL() {
        return ttl;
    }

    public int getKey() {
        return key;
    }

    public void putTTL(int ttl) {
        this.ttl = ttl;
    }

}
