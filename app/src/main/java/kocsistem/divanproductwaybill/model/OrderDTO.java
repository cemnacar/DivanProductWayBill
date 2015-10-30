package kocsistem.divanproductwaybill.model;

import java.util.Date;

public class OrderDTO
{
    public String DocumentNo;
    public String Storage;
    public Date OrderDate;
    public OrderDetailDTO[] Items;

    public void setDocumentNo(String documentNo) {
        DocumentNo = documentNo;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public void setItems(OrderDetailDTO[] items) {
        Items = items;
    }

    public String getDocumentNo() {

        return DocumentNo;
    }

    public String getStorage() {
        return Storage;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public OrderDetailDTO[] getItems() {
        return Items;
    }
}