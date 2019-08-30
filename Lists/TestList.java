import java.util.Vector;
import java.util.Scanner;  

public class TestList {
	public TestList() {} 
	
	private int testAdding() {
		LinkedList<String> testList = new LinkedList<String>(); 
		
		System.out.println("Using a LinkedList of String objects");
		System.out.println("===============add(E e) method===============");
		System.out.println("Testing add(String e) method by adding the following phrases: dog, cat, bird, mouse ");
		testList.add("dog"); 
		testList.add("cat"); 
		testList.add("bird"); 
		testList.add("mouse"); 
		System.out.println("Now we display the contents:");
		testList.display(); 
		
		System.out.println("===============add(int index, E e) method==============="); 
		System.out.println("Let's insert the string 'iguana' between index 2 and 4."); 
		System.out.println("Note: this implementation will have the inserted node at position = index + 1"); 
		testList.add(3, "iguana");
		testList.display(); 
		System.out.println("\nTest insertion at the tail... add(5, 'dragon')");
		testList.add(5, "dragon"); 
		testList.display(); 
		System.out.println("\nTest insertion at the head... add(1, 'bunny')");
		testList.add(1, "bunny"); 
		testList.display(); 
		
		System.out.println("===============addAll(Collection<? extends E> c) method==============="); 
		System.out.println("Insert of a vector of One Piece characters into our String Linked List"); 
		Vector<String> onePieceList = new Vector<String>(); 
		onePieceList.add("Monkey D. Luffy"); 
		onePieceList.add("Nami"); 
		onePieceList.add("Zoro"); 
		onePieceList.add("Vivi"); 
		System.out.println("Inserting the One Piece vector...");
		testList.addAll(onePieceList); 
		testList.display(); 
		
		System.out.println("===============addAll(int index, Collection<? extends E> c) method==============="); 
		System.out.println("Now insert the same list between positions 3 and 4."); 
		testList.addAll(3, onePieceList); 
		testList.display(); 
		
		System.out.println("Now insert the same list at the head"); 
		testList.addAll(1, onePieceList);
		testList.display(); 
		
		System.out.println("Now insert the same list at the tail of this list"); 
		testList.addAll(testList.size(), onePieceList); 
		testList.display(); 
		
		System.out.println("===============addFirst(E e) method===============");
		System.out.println("We're going to add the string 'God Ussop' to the front of the list"); 
		testList.addFirst("God Ussop");
		testList.display(); 
		
		System.out.println("===============addLast(E e) method===============");
		System.out.println("Lastly, add the string 'Nico Robin' to the end of the list");
		testList.addLast("Nico Robin");
		testList.display(); 
		
		System.out.println("===============push() method===============");
		System.out.println("Pushing Jinbei into list");
		testList.push("Jinbei");
		testList.display(); 
		
		System.out.println("All adding methods tested!");
		System.out.println(""); 
		
		return 1; 
	
	} 

	private int testRemoving() {
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		for(int i = 0; i < 25; ++i) {
				testList.add(i); 
		}
		
		System.out.println("===============remove() method===============");
		testList.remove();
		testList.display(); 
		
		System.out.println("===============remove(int index) method===============");
		testList.remove(20); 
		testList.display(); 
		System.out.println("Next, try to remove the head");
		testList.remove(1); 
		testList.display(); 
		System.out.println("then, try to remove the tail"); 
		testList.remove(testList.size()); 
		testList.display(); 
		
		System.out.println("===============remove(Object o) method===============");
		System.out.println("For this method, a list of String objects will be used"); 
		LinkedList<String> stringTestList = new LinkedList<String>(); 
		for(int i = 0; i < 10; ++i) {
			stringTestList.add("a" + i); 
		}
		System.out.println("We'll remove the String object a5 from the list"); 
		stringTestList.remove("a5"); 
		stringTestList.display(); 
		
		System.out.println("===============removeFirstOccurence(Object o) method===============");
		stringTestList.add("a2"); 
		stringTestList.add("a2"); 
		stringTestList.add("a2"); 
		stringTestList.display(); 
		
		stringTestList.removeFirstOccurrence("a2");
		stringTestList.display();
		
		System.out.println("===============removeLastOccurence(Object o) method===============");
		stringTestList.removeLastOccurrence("a2"); 
		stringTestList.display(); 
		
		System.out.println("===============pop() method===============");
		System.out.println("Resutl from pop() method" + testList.pop());
		testList.display(); 
		
		
		System.out.println(""); 
		
		return 2; 
		
	}
	
	private int testPeeking() {
		LinkedList<Character> testList = new LinkedList<Character>(); 
		LinkedList<Character> emptyList = new LinkedList<Character>(); 
		
		//Initialize test list 
		String paladin = "Arthas";
		for(int i = 0; i < paladin.length(); ++i) {
			testList.add(paladin.charAt(i)); 
		}
		System.out.println("Our test list: ");
		testList.display(); 
		
		
		System.out.println("Testing utilizes a list of Character wrapper class objects"); 
		System.out.println("===============peek() method===============");
		System.out.println("Outputing peek() method invoked on testList: " + testList.peek());  // should output: A 
		
		System.out.println("===============peekFirst() method===============");
		System.out.println("Outputing peekFirst() method invoked on testList (basically, the same as testList.peek()): " + testList.peekFirst()); 
		System.out.println("Showcasing null output when peekFirst() is called on an empty list: " + emptyList.peekFirst()); 
		
		System.out.println("===============peekLast() method===============");
		System.out.println("Outputing peekLast() method invoked on testList: " + testList.peekLast()); 
		System.out.println("Showcasing null output when peek() is called on an empty list: " + emptyList.peekLast()); 
		
		System.out.println("");
		return 3; 
	}
	
	private int testPolling() {
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		
		for(int i = 0; i < 10; ++i) {
			testList.add(i); 
		}
		System.out.println("===============poll() method===============");
		System.out.println("Output of poll() method:  " + testList.poll()); 
		
		System.out.println("===============pollFirst() method===============");
		System.out.println("Output of pollFirst() method: " + testList.pollFirst()); 
		
		System.out.println("===============pollLast() method===============");
		System.out.println("Output of pollLast() method: " + testList.pollLast()); 
		System.out.println(""); 
		
		return 4; 
	}
	
	private int testOffering() {
		LinkedList<Byte> testList = new LinkedList<Byte>(); 
		Byte b = new Byte("5"); 
		
		System.out.println("===============offer() method===============");
		System.out.println("Testing offer() method. Add in min. Byte value.");
		testList.offer(b.MIN_VALUE);
		testList.display(); 
		
		System.out.println("===============offerFirst() method===============");
		System.out.println("Testing offerFirst() method. Add in 5."); 
		testList.offerFirst(b); 
		testList.display(); 
		
		System.out.println("===============offerLast() method===============");
		System.out.println("Testing offerLast() method. Add in max. Byte value."); 
		testList.offerLast(b.MAX_VALUE); 
		testList.display(); 
		
		System.out.println(""); 
		
		return 5; 
	}
	
	private int testFinding() {
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		for(int i = 1; i <= 10; ++i) {
			testList.add(i*i); 
		}
		System.out.println("\nTest list in this case is a list of the 10 squares (1,4,9,...,100)"); 
		System.out.println("===============contains() method==============="); 
		System.out.println("Check if this list contains 49 (should be true): " + testList.contains(49)); 
		System.out.println("Check error handling when a value is not found. Search for 13 (should be false): " + testList.contains(13)); 
		
		System.out.println("===============all get() methods==============="); 
		System.out.println("Testing get(int index) for index = 5 (should return 25): " + testList.get(5)); 
		System.out.println("Testing getFirst() (should return 1): " + testList.getFirst()); 
		System.out.println("Testing getLast()  (should return 100): " + testList.getLast()); 
		
		System.out.println("===============all indexOf() methods==============="); 
		System.out.println("Testing indexOf(Object o) for o = 81 (should return 9): " + testList.indexOf(81)); 
		System.out.println("Now, we're going to add five 121's to the end of the list to illustrate indexOf() & lastIndexOf()"); 
		for(int i = 0; i < 5; ++i) {
			testList.add(121); 
		}
		
		System.out.println("Testing indexOf(Object o) for o = 121 (should return 11, the first instance of 121 in the list" + testList.indexOf(121)); 
		System.out.println("Testing lastIndexOf(Object o) o = 121 (should return 15, the last instance of 121 in the list" + testList.lastIndexOf(121)); 
		
		
		System.out.println("===============element() methods==============="); 
		System.out.println("Resutls from the element() method: " + testList.element());
		
		return 6; 
	}
	
	private int testClearing() {
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		for(int i = 0; i < 15; ++i) {
				testList.add(i*i*i); 
		}
		
		System.out.println("=======================clear() method========================="); 
		System.out.println("\n Our list of Integer objects: "); 
		testList.display(); 
		System.out.println("Clearing this list...");
		testList.clear(); 
		testList.display(); 
		
		return 7; 
	}
	
	@SuppressWarnings("unchecked")
	private int testCloning() {
		LinkedList<String> testList = new LinkedList<String>(); 
		LinkedList<String> cloneList = new LinkedList<String>(); 
		
		System.out.println("============clone() method==============="); 
		System.out.println("Creating and displaying  a list of String objects: ");
		testList.add("Crocodile"); 
		testList.add("Dracule Mihawk"); 
		testList.add("Boa Hancock"); 
		testList.add("Donquixote Doflamingo"); 
		testList.add("Gekko Moriah"); 
		testList.add("Bartholomew Kuma");
		testList.add("Jinbei"); 
		testList.display(); 
		
		System.out.println("Displaying clone list before being cloned: ");
		cloneList.display(); 
		
		System.out.println("\nNow cloning our test list: "); 
		cloneList = (LinkedList<String>)testList.clone(); 
		System.out.println("Displaying the cloned list now: ");
		cloneList.display(); 
		
		return 8; 
	}
	
	private int testOtherMethods() {
		LinkedList<Integer> testList = new LinkedList<Integer>(); 
		LinkedList<Integer> subList = new LinkedList<Integer>(); 
		LinkedList<Integer> emptyList = new LinkedList<Integer>(); 
		
		for(int i = 0; i < 20; ++i) {
			testList.add(i); 
		}
		
		System.out.println("============set() method==============="); 
		System.out.println("Before set() is called:");
		testList.display(); 
		System.out.println("After set() is called: "); 
		System.out.println("Replaced element: " + testList.set(2, 200)); 
		testList.display(); 
		
		System.out.println("============size() method===============");
		System.out.println("Size of the test list: " + testList.size()); 
		testList.remove(); 
		System.out.println("Size of the test list after calling remove(): " + testList.size());
		testList.add(2, 400); 
		System.out.println("Size of the test list after calling add():   " + testList.size()); 
		
		
		System.out.println("============toArray() method==============="); 
		Object[] array = new Integer[testList.size()]; 
		array = testList.toArray(); 
		for(int i = 0; i < 20; ++i) {
			System.out.println("Output of the toArray() array from testList: " + array[i]); 
		}
		
		System.out.println("============subList() method==============="); 
		System.out.println("Create and display subList (indices 2 thru 5)  of testList..."); 
		subList = testList.subList(2, 5); 
		subList.display(); 
		
		System.out.println("============isEmpty() method==============="); 
		System.out.println("Check if three different lists are empty: testList (" + testList.isEmpty() + ") subList (" 
							+ subList.isEmpty() + ") emptyList (" + emptyList.isEmpty() + ")"); 
		
		
		return 9; 
	}
	
	public int getTestResults(String choice) {
		int ch = Integer.parseInt(choice); 
		int value = 0; 
		
		switch(ch) {
			case 1:  value = testAdding();       break; 
			case 2:  value = testRemoving();     break; 
			case 3:  value = testPeeking();      break; 
			case 4:  value = testPolling();      break; 
			case 5:  value = testOffering();     break;
			case 6:  value = testFinding();      break; 
			case 7:  value = testClearing();     break; 
			case 8:  value = testCloning();      break; 
			case 9:  value = testOtherMethods(); break; 
			case 10: value = -1; 
		}
		
		return value; 
	} 
	
	public static void main(String[] args) {
		TestList tester = new TestList();  
		Scanner userInput = new Scanner(System.in); 
		int result = 0; 
		
		System.out.println("Welcome to this tester class for Peter's LinkedList implementation"); 
		do {
			System.out.println("\nChoose one of the LinkedList method groups to test.");
			System.out.println("===================================================");
			System.out.println("1.)  Adding ");
			System.out.println("2.)  Removing ");
			System.out.println("3.)  Peeking ");
			System.out.println("4.)  Polling ");
			System.out.println("5.)  Offering "); 
			System.out.println("6.)  Finding / Searching ");
			System.out.println("7.)  Clearing "); 
			System.out.println("8.)  Cloning ");
			System.out.println("9.)  Other Methods (toArray, size, subList, etc.)");
			System.out.println("10.) Quit "); 
			
			String choice = userInput.next();
			result = tester.getTestResults(choice); 
			
		} while(result >= 0);  
	} 

} 
