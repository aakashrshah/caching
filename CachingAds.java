
public class CachingAds {
	static DoublyLinkedList cache;

	
	public static void main(String[] args) {
		int N = 3;
		cache = new DoublyLinkedList(N);
		
		//Use case 1
		System.out.println(cache.get(1));		//null
		System.out.println(cache.get(2));		//null
		
		cache.set(1,new Ad(1));		//ok
		System.out.println(cache);

		
		cache.set(2,new Ad(2));		//ok
		System.out.println(cache);

		
		cache.set(3,new Ad(3));		//ok
		System.out.println(cache);

		
		
		//Use case 2
		cache.set(4,new Ad(4));		//remove 1. Add 4
		System.out.println(cache);

		cache.set(5,new Ad(5));		//remove 2. Add 5
		System.out.println(cache);

		cache.get(3);		//Ad(3)
		
		//Use case 3
		cache.get(1);		//null
		cache.get(2);		//null
		
		//Use case 4
		cache.get(3);		//Ad(3) Does it change location?

	}
}
