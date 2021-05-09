import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/* YOUR TARGET METHOD IS: remove(int index) 
 *
 * FINAL EXAM NON-CODING ANSWERS
 ********************************************************
 * 1. Using Git. Clone and pull the repository for your exam.
 *    Add your name and banner ID to Tests.java, commit and push.
 *    You have used Git.
 *    NOTE: To get full marks you MUST perform a commit after
 *          each question.  This way, if something goes wrong
 *          I can check each part separately and give you the
 *          marks you deserve.
 *-------------------------------------------------------------------------------------
 * 2a. Give three (3) test cases for the TARGET method (see above)
 *     Each test case should be one line long.
 ANSWER HERE:
 *
 * A B C D E  corresponds to 0 1 2 3 4
 * F G H corresponds to -1 -2 -3
 *
 * 1.The first test is testing whether it removes index 2 which is C and (check the size) of
 * the list is deducted after a removing process.
 * Then check whether it returns correct size after the removing process.
 * >> assertEquals(list.remove(2),"C");
 * >> assertEquals(list.size(),7);
 *
 * 2.The second test checks whether it removes negative correctly or not.
   index and testing with index -1 which is F will be removed from the negative array.
  >>assertEquals(list.remove(-1),"F");

*  3.The third test checks boundary condition of the given array index -4 and 5.
    Since the list consists of index -3 to 4 and this will fail the test.
   >>assertEquals(list.remove(-4),"I"); assertEquals(list.remove(5),"J");
 * 2b. Implement the unit tests below (after all these comments).
 *
 * Test cases are provided at the bottom section.
 *-------------------------------------------------------------------------------------
 * 3. Debug the issues causing your tests to fail.
 *    There are at least a couple bugs in the code.
 *    List bugs you found and fixed below.  Give
 *    - a brief description of each bug
 *    - method where the bug occurs
 *    - how you fixed the problem
ANSWER HERE:
* 1.
* Brief Description: When the remove test case is tested, NullPointer Exception is thrown.
* Location: Line 25, protected Object [] negArray;
* How to Fix: It hasn't initialized and so this will always fail when it comes to test.
* The constructor required two arrays which are negArray and posArray.
* Thus, the negArray also needs to be initialized.
* Fix: protected Object [] negArray = new Object[0];
*
* 2.
* Brief Description: The length extension is extended from the prevArray even though
* It assigned prevArray to the posArray.
* Location: public void extendPosArray(int extend) Line 109
* How to Fix: new Object[prevArray.length + extend] The extension should not happen
* from the prevArray.
* Fix: new Object[prevArray.length + extend] -> new Object[posArray.length + extend]
*
* 3.
* Brief Description: The size of the list is not decremented.
* Location: Line 192 public E remove(int index)
* How to Fix: The number of elements should be decreased after the removing process.
* Fix: Add  posNumElements--; and negNumElements--;
 *-------------------------------------------------------------------------------------

* 4a.  Identify three (3) locations in the code where assertions
*      would be appropriate. Give
*      - method where assertion should be used
*      - what the assertions should assert
ANSWER HERE:
*1.
* Location:Line 31 Constructor public IntIndexableList(ArrayList<E> posList, ArrayList<E> negList)
* Implementation:Before each for loop. assert posList!=null:"posList is null"; ,assert negList!=null:"negist is null";
* Reason: Checking whether the List is null or not.
*
* 2.
* Location: Line 42  Constructor  public IntIndexableList(E [] posArray, E [] negArray)
* Implementation: Before each for loop.  assert posArray!=null:"posArray is null";, assert negArray!=null:"negArray is null";
* Reason: It checks whether the array is null or not.

* 3.
* Location:  Line 107,Line 117  public void extendNegArray(int extend)   public void extendPosArray(int extend)
* Implementation:  assert extend>0: "extension is negative value";
* Reason: The extendNegArray and extendPosArray should check whether the extend value is negative or not. If it decreases, this is not
* a right method.
*
*
* (I did one more since 1 and 2 are very similar so.)
* 4.
* Location: Line 227  public boolean remove(Object o) method
* Implementation:  assert o!=null: "Object is null.";
* Reason:   If the remove(Object o) needs to be implemented, it should check whether
* the object is Null or not.
*
* 4b. Write the assertions in the code.
*
*-------------------------------------------------------------------------------------
* 5a. Suggest one (1) exception that would be appropriate
*     for the TARGET method and one (1) exception somewhere
*     else in the code.
*     State the condition under which the exceptions should be
*     thrown.
ANSWER HERE:
 * 1. public E remove(int index) throws ArrayIndexOutOfBoundsException (Target method Exception suggestion)
 *  ArrayIndexOutOfBounds Exception is appropriate since we need to check the boundary condition and
 *  when the  boolean max =index>posNumElements; boolean min =index<(-negNumElements); ArrayIndexOutofBounds Exception should be thrown.
 *
 * 2.public boolean contains(Object o) throws NullPointerException
 *  NullPointer Exception is appropriate since we need to check the specified element and
 * this should not be null value.

* 5b. Implement the exceptions you suggested.
*
* 5c. Add unit tests to test that the exceptions are thrown when
*     appropriate.
**-------------------------------------------------------------------------------------
* 6a. Identify three (3) procedural refactorings that can be
*     done in the code.  Give
*    - a brief description of each issue
*    - the method where the issue is
*    - how to fix the issue
ANSWER HERE:
*
* Description: Magic numbers occurred.
* Location: Line 88, 98
* Fix: Rename Magic number to Extra_Length
*
* Description: Bad naming. && public int indexOf(Object o) for loop conditions.
* Location:Line180 ,Line 212
* Fix:i => array_index
*
* Description: Do not use parameter like a local variable.
* Location:Line 243, public boolean remove(Object o)
* Fix: Create  Object obj = o; instead of using it from parameter directly.
*
* Description:Introduce an intermediate variable.
* Location: Line 219
* Fix: Instead of (index>posNumElements||index<(-negNumElements))
* Use (max||min) from the boolean max =index>posNumElements; boolean min =index<(-negNumElements);
*
* ******Extra ****** Extra time for this
* Description: Make the code looks simpler instead of putting long for loop and if statments in one method.
* Location:224
* Fix: Extract method from the  public E remove(int index)


* 6b. Perform the refactorings on the code.  Be sure to do
*     regression testing
*     Done. I still need to go back question 5 after this if time allowed.
*
* **-------------------------------------------------------------------------------------
* 7. Identify three (3) class-level refactorings that can be
*     done in the code.  Give
*    - a brief description of each issue
*    - where the issue is
*    - what SOLID principle (if any) are violated
*    - whether a class implementation or class interface refactoring
*      is needed
*    - how to fix the issue
ANSWER HERE:
*
* Description: IntIndexableList has protected variables
* Location:Line25-30
* Issue:The concrete classes don't need to use protected method.
* Solid Principle:(DIP violation)
* Class: Class interface refactoring and class Implementation
* Fix: Make the variables private and create and setter and getter methods for the extension.

*
* Description: IntIndexableList has too much responsibility.
* Location:The whole class
* Issue:The IntIndexableList is responsible for remove, contains, add ,extension, toScanner.
*  Too many methods in a class.
* Solid Principle: SRP violation
* Class: Class Interface refactoring
* Fix: Create a class that shares the responsibility in the one method Convert one to two classes.
*
*
* Description: IntIndexableList could be split to two classes from the parent class
* Location: The whole class.
* Issue: One class is dealing with two arrays which are positive and negative array or (list).
* Solid Principle:(OCP violation)
* Class: Class interface refactoring and class Implementation
* Fix: Create a superclass called IndexableList and extends two sub classes for
*  negative and positive arrays
*
* Description: The add method deals with both negative and positive in one method.
* Location: public void add(int index, E element)
* Issue: Two methods placed in one add method.
* Solid Principle: (SRP violation)
* Class: Class Interface Refactoring
* Fix: Split one method to two but initially it's strongly suggested to create two sub classes from the Indexablelist and extend two sub classes to
* deal with each of the array separately.
*
Finished Thank you Professor.  2.02pm 12/18/2020 Minwoo Yang
*******************************************************
* Place written answers above this line
*******************************************************
*/

class Tests {
    /* You can clone and rename this method for all the tests that
     * you will need to do.
     *
     * All tests for all source files should be placed here.
     */

    //Declare two variables that can be used in the test cases.
    private static final Object [] preArray = { "A", "B", "C", "D", "E"};
    private static final Object [] negArray ={ "F", "G", "H"};
    private static final Object [] negArray2 ={"F","G",null};

    /*First Remove Testing
    Int Indexable lsit is extendable to the negative index so the constructors required two arrays
    which are prevArray and negArray as declared above.
    A B C D E  corresponds to 0 1 2 3 4
    F G H corresponds to -1 -2 -3
    The first test is testing whether it removes index 2 which is C
    Then check whether it returns correct size after the removing process.
     */

    @Test
    void Remove_test() {

            IntIndexableList list = new IntIndexableList(preArray,negArray);
            assertEquals(list.remove(2),"C");
            assertEquals(list.size(),7);
            //list.remove(null);
    }

    /*
    The second test checks whether it removes negative correctly or not.
     index and testing with index -1 which is F will be removed from the negative array.
     */

    @Test
    void Remove_test2(){

            IntIndexableList list = new IntIndexableList(preArray, negArray);
            assertEquals(list.remove(-1), "F");

    }

    /*
    The third test checks boundary condition of the given array.
    Since the list consists of index -3 to 4 and this will fail the test.
    -4 and 5 are the boundary conditions.
     */

    @Test
    void Remove_test3(){
            try {
                IntIndexableList list = new IntIndexableList(preArray, negArray);
                //assertEquals(list.remove(-4), "E");
                //assertEquals(list.remove(5), "H");
                list.remove(-4);
                assertEquals(list.get(-4),"Q");
                assertEquals(list.remove(5),"K");
            }catch (ArrayIndexOutOfBoundsException e){
                assertEquals(e.getMessage(),"Index out of bounds.");
                //System.out.println("Index out of bounds.");
            }
    }

    @Test
    void Contains_test(){
        try {
            IntIndexableList list = new IntIndexableList(preArray, negArray2);
            assertTrue(list.contains(null));
        }catch(NullPointerException e){
            assertEquals(e.getMessage(),"object==null.");
            //System.out.println("object==null.");
        }
    }
}
