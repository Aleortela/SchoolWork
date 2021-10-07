import java.util.ArrayList;

public class VendingMachine {
    protected int OPTIONS = 4;
    private int serialNumber;
    private String location;
    private int[] itemCounts;
    private int[] orderCounts;
    private int[] soldCounts;
    private double[] itemCosts = {0.50,0.50,0.25,1};
    private String[] itemLabels= {"Water: ","Coffee: ","Fritos: ","Lily's Chocolate: "};
    private double subtotal;
    private double total;

    public VendingMachine(int serialNumber) {
        this.serialNumber = serialNumber;
        this.location = "UNKNOWN";
        this.itemCounts = new int[OPTIONS];
        this.orderCounts = new int[OPTIONS];
        this.soldCounts = new int[OPTIONS];
    }

    public VendingMachine(int serialNumber, String location) {
        this.serialNumber = serialNumber;
        this.location = location;
        this.itemCounts = new int[OPTIONS];
        this.soldCounts = new int[OPTIONS];
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getSerialNumber2() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addItems(int water, int coffee, int fritos, int lilys) {
        itemCounts[0] += water;
        itemCounts[1] += coffee;
        itemCounts[2] += fritos;
        itemCounts[3] += lilys;
    }

    public void resetItems(int water, int coffee, int fritos, int lilys) {
        itemCounts[0] = water;
        itemCounts[1] = coffee;
        itemCounts[2] = fritos;
        itemCounts[3] = lilys;
    }

    public String toString() {
        return "Serial Number: " + serialNumber
                + "\nLocation: " + location
                + "\n"
                + "\nVending Machine Stock"
                + "\n"+itemLabels[0] + itemCounts[0]
                + "\n"+itemLabels[1] + itemCounts[1]
                + "\n"+itemLabels[2] + itemCounts[2]
                + "\n"+itemLabels[3] + itemCounts[3];
    }

    public boolean buyItem(int itemId) {
        while (!false) {
            if (itemId == 1 && itemCounts[0] < 0 && itemId == 2 && itemCounts[1] < 0
                    && itemId == 3 && itemCounts[2] < 0 && itemId == 4 && itemCounts[3] < 0)
            {
                return false;
            }
            else if(itemId == 1 && itemCounts[0] > 0)
            {
                orderCounts[itemId - 1]++;
                return true;
            }
            else if (itemId == 2 && itemCounts[1] > 0) {
                orderCounts[itemId - 1]++;
                return true;
            }
            else if (itemId == 3 && itemCounts[2] > 0)
            {
                orderCounts[itemId - 1]++;
                return true;
            }
            else if (itemId == 4 && itemCounts[3] > 0)
            {
                orderCounts[itemId - 1]++;
                return true;
            }
        }
    }
    public boolean buyItem(int itemId, int count)
    {
        while (!false) {
            if (itemId == 1 && itemCounts[0] < 0 && itemId == 2 && itemCounts[1] < 0
                    && itemId == 3 && itemCounts[2] < 0 && itemId == 4 && itemCounts[3] < 0)
            {
                return false;
            }
            else if(itemId == 1 && itemCounts[0] > 0)
            {
                orderCounts[itemId - 1]+= count;
                return true;
            }
            else if (itemId == 2 && itemCounts[1] > 0) {
                orderCounts[itemId - 1]+= count;
                return true;
            } else if (itemId == 3 && itemCounts[2] > 0) {
                orderCounts[itemId - 1]+= count;
                return true;
            } else if (itemId == 4 && itemCounts[3] > 0) {
                orderCounts[itemId - 1]+= count;
                return true;
            }
        }
    }
    public void returnItem(int itemId, int count)
    {

        if(count >= itemCounts[itemId-1])
        {
            orderCounts[itemId-1] = 0;
        }
        else
        {
            orderCounts[itemId-1] -= count;
        }
    }
    public double orderTotal()
    {
        subtotal= 0;
        total= 0;
        double tax = 0.10;
        for(int i=0;i<orderCounts.length;i++)
        {
            subtotal = subtotal + (orderCounts[i]*itemCosts[i]);
        }
        total = subtotal + (subtotal*tax);

        return total;
    }
    public void displayReceipt()
    {
        subtotal =0;
        System.out.println("Your Order:");
        for(int i= 0;i<orderCounts.length;i++)
        {
            System.out.println(itemLabels[i]+orderCounts[i]+"x "+(toDollars(itemCosts[i])));
        }
        for(int i=0;i<orderCounts.length;i++)
        {
            subtotal = subtotal + (orderCounts[i]*itemCosts[i]);
        }
        System.out.println("Subtotal: "+toDollars(subtotal));
        System.out.println("Total (plus 10% tax): "+toDollars(orderTotal()));
    }
    public boolean pay(double moneyAmount)
    {
        double change= 0;
        if(moneyAmount >=  orderTotal())
        {
            change= moneyAmount - orderTotal();
            System.out.println("Your change is: "+toDollars(change));
            for(int i= 0; i<itemCounts.length;i++)
            {
                soldCounts[i] = itemCounts[i];
            }
            return true;
        }
        else
        {
            System.out.println("Please enter enough money!! We have returned the money you entered: "+toDollars(moneyAmount));
            return false;
        }
    }

    public boolean equals(VendingMachine vm)
    {
        if(itemCounts[0] == itemCounts[1] && itemCounts[0] == itemCounts[2] && itemCounts[0] == itemCounts[3])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static String toDollars(double u)
    {
        return String.format("$%.2f", u);
    }



}
