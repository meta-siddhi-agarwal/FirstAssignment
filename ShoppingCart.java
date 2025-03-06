import java.util.*;

public class ShoppingCart {

int itemid;

String name,desc;

double price;//setting price to be of double type

Map<ShoppingCart,Integer> hm=new HashMap<>();

//creating parametrized constructor

ShoppingCart(int id,String Name,String description,Double Price){

itemid=id;

name=Name;

desc=description;

price=Price;

}



public static void main(String[] args) {

// TODO Auto-generated method stub

Scanner sc=new Scanner(System.in);

System.out.println("Enter item id");

int id=sc.nextInt();

System.out.println("Enter item name");

String name=sc.next();

System.out.println("Enter description of the item");

String desc=sc.next();

System.out.println("Enter price of the item");

double price=sc.nextDouble();

System.out.println("Enter quantity of the item");

int quantity=sc.nextInt();

ShoppingCart shop=new ShoppingCart(id,name,desc,price);

System.out.println("Enter operation to perform"+"\n"+"1.Add items to cart"+"\n"+"2.Show quantity"+"\n"+"3.Update quantity"+"\n"+"4.Delete item"+"\n"+"5.Display total cart bill");

int a=sc.nextInt();
switch(a){
    case 1:
        shop.addToCart(shop,quantity);
        System.out.println("Item added successfully");
        break;
        case 2:
            System.out.println(shop.display(shop));
            break;
            case 3:
                System.out.println("Enter updated quantity");
                int updated_quan=sc.nextInt();
                shop.update(shop,updated_quan);
                System.out.println("Item updated successfully");
                break;
                case 4:
                 shop.delete(shop);
                 System.out.println("Item deleted successfully");
                 break;
                 case 5:
                     System.out.println(shop.displayBill());
                     break;
                     default:
                     System.out.println(" Please enter valid no.");
}



}

//addingitems to cart

void addToCart(ShoppingCart item,Integer quantity){

hm.put(item,quantity);

}

//displaying quantity for each unique item

int display(ShoppingCart item) {

return hm.get(item);

}

//updating quantity of items

void update(ShoppingCart item,Integer quantity) {

hm.put(item, quantity);

}

//deleting any item

void delete(ShoppingCart item) {

hm.remove(item);

}

//display total bill of the cart

double displayBill() {

double ans[]={0.0};
hm.forEach((ShoppingCart s,Integer j)->{
double ind_price=s.price;
double total=ind_price*j;
ans[0]+=total;

});

return ans[0];







}

}