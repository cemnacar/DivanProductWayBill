package kocsistem.divanproductwaybill.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class OrderDTO implements Serializable
{
    public String DocumentNo;
    public String Storage;
    public Date OrderDate;
    public ArrayList<OrderDetailDTO> Items;

    public void setDocumentNo(String documentNo) {
        DocumentNo = documentNo;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public void setItems(ArrayList<OrderDetailDTO> items) {
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

    public ArrayList<OrderDetailDTO> getItems() {
        return Items;
    }
}