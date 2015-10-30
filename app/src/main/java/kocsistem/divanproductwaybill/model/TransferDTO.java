package kocsistem.divanproductwaybill.model;

public class TransferDTO
{
    public String ProductionSite;
    public String Depot;
    public TransferItemDTO[] Items;

    public void setProductionSite(String productionSite) {
        ProductionSite = productionSite;
    }

    public void setDepot(String depot) {
        Depot = depot;
    }

    public void setItems(TransferItemDTO[] items) {
        Items = items;
    }

    public String getProductionSite() {

        return ProductionSite;
    }

    public String getDepot() {
        return Depot;
    }

    public TransferItemDTO[] getItems() {
        return Items;
    }
}