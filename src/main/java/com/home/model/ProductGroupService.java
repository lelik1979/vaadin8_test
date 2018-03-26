package com.home.model;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
public class ProductGroupService {

    private List<ProductGroup> productGroups;

    public ProductGroupService() {
        this.productGroups = init();
    }

    private List<ProductGroup> init() {
        List<ProductGroup> productGroups = new ArrayList<>(50);
        for (int i=1; i < 50; i ++) {
            productGroups.add(buildProductGroup(i, "productGroup" + i));
        }
        return productGroups;
    }

    private ProductGroup buildProductGroup(int id, String groupName) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(id);
        productGroup.setName(groupName);
        return productGroup;
    }

    public int count() {
        return productGroups.size();
    }

    public List<ProductGroup> findAll(int offset, int limit) {
        return productGroups;
    }
}
