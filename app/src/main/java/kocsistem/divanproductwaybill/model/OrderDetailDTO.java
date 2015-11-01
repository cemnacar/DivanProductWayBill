package kocsistem.divanproductwaybill.model;

import java.io.Serializable;

public class OrderDetailDTO implements Serializable
{
    public String ProductNo;
    public String DocumentNo;
    public String ProductName;
    public double Quantity;
    public String Unit;
    public double BarcodeQuantity;

    public void setBarcodeQuantity(double barcodeQuantity) {
        BarcodeQuantity = barcodeQuantity;
    }

    public double getBarcodeQuantity() {

        return BarcodeQuantity;
    }

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public void setDocumentNo(String documentNo) {
        DocumentNo = documentNo;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getProductNo() {

        return ProductNo;
    }

    public String getDocumentNo() {
        return DocumentNo;
    }

    public String getProductName() {
        return ProductName;
    }

    public double getQuantity() {
        return Quantity;
    }

    public String getUnit() {
        return Unit;
    }
}