package pack;

import java.util.*;

public class ShoppingCart {

//first scanner obj. for getting int and double values
static Scanner sc=new Scanner(System.in);

//second scanner obj. for getting string
static Scanner sc1=new Scanner(System.in);

int itemid;

String name,desc;

double price;//setting price to be of double type

//map for storing items
static Map<ShoppingCart,Integer> hm=new HashMap<>();

//creating parametrized constructor

ShoppingCart(int id,String Name,String description,Double Price){

itemid=id;

name=Name;

desc=description;

price=Price;

}


public static void main(String[] args) {
	boolean is_true=true;
	while(is_true) 
	{	
	try {
		System.out.println("Choose which operation to perform\n"
		+"1.Add items to cart\n"+"2.Show quantity\n"
		+"3.Update quantity\n"+"4.Delete item\n"
		+"5.Display total cart bill\n"+
		"6.Exit");
		
		int input=sc.nextInt();
		
	switch(input){
	    case 1:
	    	ShoppingCart item=input();
	    	int quantity=input1("quanity");
	        boolean is_addedd=addToCart(item,quantity);
	        if(is_addedd==true)System.out.println("Item added successfully");
	        else System.out.println("Item id already exists\n"+
	        "Please enter different id");
	        break;
	     case 2:
	        int id=id("whose quantity to be displayed");
	        int quan=display(id);
	        if(quan<0)System.out.println("Please enter valid id");
	        else System.out.println("Quantity of item is "+quan);
	        break;
	     case 3:
	        int id1=id("whose quantity to be updated");
	        int updated_quan=input1("updated_quantity");
	        boolean ans=update(id1,updated_quan);
	        if(ans==true)System.out.println("Quantity updated successfully");
	        else System.out.println("Please enter valid id");
	        break;
	      case 4:
	    	  int id2=id("which needs to be deleted");
	    	  boolean result=delete(id2);
	    	  if(result==true)System.out.println("Item deleted successfully");
		      else System.out.println("Please enter valid id");
		      break;
	      case 5:
	          System.out.println("Total bill amount is "+displayBill());
	          break;
	      case 6:
	    	  is_true=false;
	    	  System.out.println("Program ended successfully");
	    	  break;
	      default:
	    	  is_true=false;
	          System.out.println("Please enter valid no.");
	}
	}
	catch(Exception e) {
		is_true=false;
		System.out.println("Please enter valid no.");
	}
	}
}

//taking items as input from user
static ShoppingCart input() {
	System.out.println("Enter item id");
	int id=sc.nextInt();
	System.out.println("Enter item name");
	String name=sc1.nextLine();
	System.out.println("Enter item description");
	String des=sc1.nextLine();
	System.out.println("Enter item price");
	double price=sc.nextDouble();
	ShoppingCart shop=new ShoppingCart(id, name, des, price);
	return shop;
	
}

//taking quantity as input from user
static int input1(String msg) {
	System.out.println("Enter "+msg+" of item");
	int quantity=sc.nextInt();
	return quantity;
}

//taking itemid as input
static int id(String msg) {
	System.out.println("Enter id of item "+msg);
	int id=sc.nextInt();
	return id;
}

//adding items to cart
static boolean addToCart(ShoppingCart item,Integer quantity){
boolean ans=false;
if(hm.containsKey(item)) {}
else {
	hm.put(item,quantity);
	ans=true;
}
return ans;
}

//displaying quantity for each unique item
static int display(int id) {
	int quantity[]= {-1};
hm.forEach((ShoppingCart item,Integer quan)->{
	if(item.itemid==id) {
		quantity[0]=hm.get(item);
	}
});
return quantity[0];
}


//updating quantity of items
static boolean update(int id,int updated_quantity) {
	boolean ans[]= {false};
hm.forEach((ShoppingCart item, Integer quantity)->{
	if(item.itemid==id){
		hm.put(item, updated_quantity);
		ans[0]=true;
	}
}

		);
return ans[0];
}


//deleting any item
static boolean delete(int id) {
boolean ans[]= {false};
hm.forEach((ShoppingCart item,Integer quantity)->{
	if(item.itemid==id) {
		hm.remove(item);
		ans[0]=true;
	}
});
return ans[0];
}


//display total bill of the cart
static double displayBill() {
double ans[]={0.0};
hm.forEach((ShoppingCart s,Integer j)->{
double ind_price=s.price;
double total=ind_price*j;
ans[0]+=total;
});
return ans[0];
}
}
