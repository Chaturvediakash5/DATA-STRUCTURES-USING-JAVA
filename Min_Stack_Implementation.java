import java.util.*;
class Min_Stack
{
   public  static  int top=-1;
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Size  Of Stack");
        int size=sc.nextInt();
        int arr[]=new int[size];
        int minElement=0;
        for(;;)
        {
            System.out.println("Press 1 For Push 2 For Pop");
            System.out.println("Press 3 For Peek 4 For whole Traversal");
            System.out.println("Press 5 For Min Element in Stack");
            System.out.println("Press 6 For Exit");
            int choice=sc.nextInt();
            
            switch(choice)
            {
                case 1:
                System.out.println("Enter The Value");
                int val=sc.nextInt();
                minElement=push(arr,val,size,minElement);
                break;

                case 2:
                minElement=pop(arr,minElement);
                break;

                case 3:
                System.out.println(arr[top]);
                break;

                case 4:
                display(arr,minElement);
                break;

                case 5:
                System.out.println(minElement);
                break;

                case 6:
                System.exit(0);
                break;

                
            }
        }
    }
    public static int pop(int arr[],int minElement)
    {
        if(top==-1)
        {
            System.out.println("Stack Under Flow Deletion Not Possible");
        }
        else{
            if(arr[top]>=minElement)
            {
                top-=1;
                System.out.println("Deletion Successful");
            }
            else
            {
                minElement=2*minElement-arr[top];                   
                top-=1;   
                System.out.println("Deletion Successful");                                                    
            }
        }
        return minElement;
    }
    public static void display(int arr[],int minElement)
    {
            if(top==-1)
            {
            System.out.println("Stack UnderFlow");

        }
        else{
            System.out.println("Min Element in Stack: "+minElement);
            for(int i=0;i<=top;i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        return;
    }
    public static int push(int arr[],int val,int size,int minElement)
    {
        
        if(top>=(size-1))
        {
            System.out.println("Stack OverFlow");

        }
        else if(top==-1)
        
        {
            minElement=val;
            arr[++top]=val;
            System.out.println("Insertion Successful");
        }
        else
        {
            if(val>=minElement)
            {
            arr[++top]=val;
            System.out.println("Insertion Successful");
            }
            else
            {   
                int temp=(2*val-minElement);
                arr[++top]=temp;          //Insertion Formula For Min Stack;
                minElement=val;                         
                System.out.println("Insertion Successful");
            }
        }
        return minElement;

    }
}
