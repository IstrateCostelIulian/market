package market.dto;

import java.util.List;


public class ProductDTO {
    private String name;
    private List<RawMaterialDTO> rawMaterialsList;
    private double commercial_excess;
    private double price;
    private int stock;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RawMaterialDTO> getRawMaterialsList() {
        return rawMaterialsList;
    }

    public void setRawMaterialsList(List<RawMaterialDTO> rawMaterialsList) {
        this.rawMaterialsList = rawMaterialsList;
    }

    public double getCommercial_excess() {
        return commercial_excess;
    }

    public void setCommercial_excess(double commercial_excess) {
        this.commercial_excess = commercial_excess;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
