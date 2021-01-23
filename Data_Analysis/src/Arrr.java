public class Arrr {

  public static void main(String[] args) {
    int[] arr = null;
    arr = new int[0];
    arr = new int[]{1, 7, 9};
    int arr_max = max(arr);
    System.out.println("arr max is " + arr_max);
  }

  private static int max(int[] arr) {
    assert arr != null : "null array";
    assert arr.length > 0 : "empty array";

    int maxValue = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > maxValue) {
        maxValue = arr[i];
      }
    }
    return maxValue;
  }
}
