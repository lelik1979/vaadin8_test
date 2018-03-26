package com.home.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexey.dranchuk on 10.10.14.
 *
 */
//@Entity
//@Table(name = ProductGroup.TABLE_NAME)
public class ProductGroup implements Serializable {

    public static final String TABLE_NAME = "product_group";

    public static final String ID_PROPERTY_NAME = "id";

    public static final String NAME_PROPERTY_NAME = "name";

    public static final String PARENT_PRODUCT_GROUP = "parentProductGroup";

    public static final String PARENT_PRODUCT_NAME = "parentName";

    public static final String ORDER_ID = "orderId";

    private Integer id;

    private String name;

    private List<ProductGroup> childGroups = new ArrayList<>();

    private ProductGroup parentProductGroup;

    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParentName() {
        return parentProductGroup != null ? parentProductGroup.getName() : "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductGroup> getChildGroups() {
        return childGroups;
    }

    public void setChildGroups(List<ProductGroup> childGroups) {
        this.childGroups = childGroups;
    }

    public ProductGroup getParentProductGroup() {
        return parentProductGroup;
    }

    public void setParentProductGroup(ProductGroup parentProductGroup) {
        this.parentProductGroup = parentProductGroup;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductGroup that = (ProductGroup) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "ProductGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isChildrenAllowed() {
        return !childGroups.isEmpty();
    }

    public boolean isNewProductGroup() {
        return id == null;
    }
}
