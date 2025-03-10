//Time Complexity: O(nlogn)
 //Space Complexity : O(N)
 import java.util.Stack;
class IterativeQuickSort { 

    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable 
        arr[i] = arr[i] +arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        //Compare elements and swap.
        int i = l,j=h,pivot=arr[l];

        while(i< j) {
            while(i<arr.length && arr[i]<=pivot) {
                i++;
            }
            while(arr[j] > pivot) {
                j--;
            }
            if(i < j)
                swap(arr, i, j);
        }
        swap(arr, j, l);
        return j;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        //Try using Stack Data Structure to remove recursion.
       
        Stack<Integer> stack = new Stack<Integer>();



       stack.push(l);
       stack.push(h);


        while(!stack.isEmpty()){
            h = stack.pop();
            l = stack.pop();

            int pivot = partition(arr, l, h);

            if(pivot-1 >l){
                stack.push(l);
                stack.push(pivot-1);

            }

            if(pivot+1 <h){
               stack.push(pivot+1);
                stack.push(h);
            }
        }

    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 