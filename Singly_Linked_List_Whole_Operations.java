import  java.util.*;
public class SinglyLinked_List
 {
    public class  Node
    {
    Node next;
    int data;
         Node(int val)
        {
        this.next=null;
        this.data=val;
         }

    }
  public Node head=null;
 

  public static void main(String[]args)
  {
      Scanner sc=new Scanner(System.in);
      SinglyLinked_List slist=new  SinglyLinked_List();
      System.out.println("Press 1 For  Insert at first Position");
      System.out.println("Press 2 For  Insert at Last Position");
      System.out.println("Press 3 For  Deletion at First Position");
      System.out.println("Press 4 For  Deletion at Last Position");
      System.out.println("Press 5 For  Traverse");
      System.out.println("Press 6 For  Exit");
      System.out.println("Press 7 to   Insert at Kth Position");
      System.out.println("Press 8 For  Deletion At Kth Position");

      
      for(;;)
      {
         
          int choice=sc.nextInt();
          int val=0;
          int pos=0;
          switch(choice)
          {
            /*int val=null;*/
            case 1:
            System.out.println("Enter Item to Insert");
            val=sc.nextInt();
            slist.insert_at_first(val);
            break;

            case 2:
            System.out.println("Enter Item to Insert");
            val=sc.nextInt();
            slist.insert_at_last(val);
            break;

            case 3:
           slist.deletion_at_first();
           System.out.println("Deletion Successful");
            break;

            case 4:
           slist.deletion_at_last();
           System.out.println("Deletion Successful");
            break;

            case 5:
            slist.display();
            break;

            case 6:
            System.exit(0);
            break;

            case 7:
            System.out.println("Enter Position");
             pos=sc.nextInt();
            slist.insert_at_kth_pos(pos);
            System.out.println("Insertion Successful");
            break;

            case  8:
            System.out.println("Enter Position");
             pos=sc.nextInt();
             slist.delete_at_kth_position(pos);
             System.out.println("Deletion Successful");
             break;
          }
      }
  }
  public void delete_at_kth_position(int pos)
  {
      if(pos==1)
      {
        deletion_at_first();

      }
      else
      {
        int count=1;
        Node temp=head;
        while(count<pos-1){
            temp=temp.next;
            count++;
        }
        temp.next= temp.next.next;
      }
      return;
  }
public void insert_at_kth_pos(int pos)
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter Value");
    int val=sc.nextInt();
    Node newNode=new Node(val);
    if(pos==1 && head==null)
    {
        head=newNode;
        newNode.next=null;
    }
    else{
        int count = 1;
        Node temp = head;
        while(count < pos-1){
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
         }
    return;
}
  public  void insert_at_last(int val )
  {
    Node newnode=new Node(val);
    newnode.next=null;
    if(head==null)
    {
        head=newnode;
        System.out.println("Insertion Successful");
        return;
    }
    else
    {
      Node temp=head;
      while(temp.next!=null)
      {
          temp=temp.next;
      }
      temp.next=newnode;
      System.out.println("Insertion Successful");
      return;
    }
     }

public void insert_at_first(int val)
{
    Node newNode=new Node(val);
    newNode.next=head;
    head=newNode;
    System.out.println("Insertion Successful");
    return;

}
public void deletion_at_first()
{
    Node temp=head;
   
    head=temp.next;
    return;
}
public void deletion_at_last()
{
    if(head.next == null){
        deletion_at_first();
    }
    else{
        Node temp=head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    
   
    
    return;
}
  public void display()
  {
    Node current = head;    
            
    if(head == null) 
    {    
        System.out.println("List is empty");    
        return;    
    } 

    System.out.println("Nodes of singly linked list: ");    

    while(current!= null)
     {    
        //Prints each node by incrementing pointer    
        System.out.print(current.data + " ");    
        current = current.next;    
    }    
    System.out.println();
  }

}
