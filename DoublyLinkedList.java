
public class DoublyLinkedList {
	ListNode head;
	ListNode tail;
	int currentListSize;
	int capacity;
	
	public DoublyLinkedList(int cap) {
		this.head = new ListNode();
		this.tail = new ListNode();
		this.head.next = tail;
		this.tail.prev = head;
		this.currentListSize = 2;
		
		if(cap > 2) {
			this.capacity = cap;
		}
	}

	
	public Ad get(int i) {
		ListNode current = head;
		while(current.next != tail) {
			if(current.key == i) {
				return current.val;
			}
			current = current.next;
		}
		
		return null;
	}

	public void set(int i, Ad ad) {
		if(head.val == null) {
			head.key = i;
			head.val = ad;
			return;
		}else if(tail.val == null){
			tail.key = i;
			tail.val = ad;
			return;
		}else {
			ListNode newNode = new ListNode(i,ad);
			if(currentListSize <= capacity - 1) {
				ListNode temp = head;
				head = newNode;
				newNode.next = temp;
				temp.prev = newNode;
				currentListSize++;
			}else if(currentListSize == capacity){
				ListNode current = tail;
				while(current.prev != head){
					current = current.prev;
				}
				ListNode tempNext = current.next;
				ListNode tempPrev = current.prev;
				current = newNode;
				current.next = tempNext;
				current.prev = tempPrev;

			}
		}
		return;
	}
	
	@Override
	public String toString() {
		ListNode current = head;
		StringBuilder sb = new StringBuilder();
		if(head.val != null) {
			sb.append("Head = Key : " + head.key);
		}

		while(current.next != tail) {
			sb.append(" ~~> Key : " + current.next.key);
			current = current.next;
		}

		if(tail.val != null) {
			sb.append(" ~~> Tail = Key : " + tail.key);
		}
		sb.append("\n");
		return sb.toString();
	}
	
	
}
