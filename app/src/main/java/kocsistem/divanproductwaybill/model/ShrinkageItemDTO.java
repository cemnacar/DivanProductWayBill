package kocsistem.divanproductwaybill.model;

import java.util.Date;

public class ShrinkageItemDTO
{
    public String ProductNo;
    public double Quantity;
    public String Unit;
    public String Party;
    public String Reason;
    public String Description;

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public void setParty(String party) {
        Party = party;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getProductNo() {

        return ProductNo;
    }

    public double getQuantity() {
        return Quantity;
    }

    public String getUnit() {
        return Unit;
    }

    public String getParty() {
        return Party;
    }

    public String getReason() {
        return Reason;
    }

    public String getDescription() {
        return Description;
    }
}