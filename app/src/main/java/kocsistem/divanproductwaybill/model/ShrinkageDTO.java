package kocsistem.divanproductwaybill.model;

import java.util.Date;

public class ShrinkageDTO
{
    public Date CreateDate;
    public Date DocumentDate;
    public ShrinkageItemDTO[] Items;

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public void setDocumentDate(Date documentDate) {
        DocumentDate = documentDate;
    }

    public void setItems(ShrinkageItemDTO[] items) {
        Items = items;
    }

    public Date getCreateDate() {

        return CreateDate;
    }

    public Date getDocumentDate() {
        return DocumentDate;
    }

    public ShrinkageItemDTO[] getItems() {
        return Items;
    }




}