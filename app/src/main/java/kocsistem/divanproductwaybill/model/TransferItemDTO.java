package kocsistem.divanproductwaybill.model;

public class TransferItemDTO
{
    public String Party;
    public double Quantity;
    public String Unit;
    public String ProductNo;

    public void setProductNo(String productNo) {
        ProductNo = productNo;
    }

    public void setParty(String party) {
        Party = party;
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

    public String getParty() {
        return Party;
    }

    public double getQuantity() {
        return Quantity;
    }

    public String getUnit() {
        return Unit;
    }


}