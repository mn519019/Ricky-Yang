public class AssertMe {
  public static void main(String [] args) {
    System.out.println("About to assert");
    assert System.out != null :"System.out is null";
    //assert System.out == null : "I was meant to fail"; // This assertion should fail


  }

}
