package javaassignment_2;
import java.util.ArrayList;
import java.util.List;
public class Purchase {
    private List<PurchaseDetail> details = new ArrayList<>();

    // Add a purchase item
    public void addDetail(PurchaseDetail detail) {
        details.add(detail);
    }

    // Process the purchase and update stock
    public void processPurchase() {
        double total = 0;

        System.out.println("\n--- Purchase Bill ---");
        for (PurchaseDetail detail : details) {
            Product p = detail.getProduct();
            p.updateStock(detail.getQuantity());  // increase stock
            double subtotal = detail.getSubtotal();
            total += subtotal;

            System.out.println(p.getName() + " x " + detail.getQuantity() + " = ₹" + subtotal);
        }
          System.out.println("Total Product Cost ₹:"+total);
    }
}
