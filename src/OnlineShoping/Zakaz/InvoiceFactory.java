package OnlineShoping.Zakaz;

import OnlineShoping.pabota_s_tovarom.Invoice;

public class InvoiceFactory {
    private static int invoiceCounter = 1000;

    public static Invoice createInvoice(Order order) {
        String invoiceNumber = " INV- " + (invoiceCounter++);
        return new Invoice(invoiceNumber, order.getClientName(),
                order.getItems(), order.getTotalAmount());
    }
}
