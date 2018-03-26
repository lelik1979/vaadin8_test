package com.home.model;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

@SpringComponent
@UIScope
public class ProductGroupService implements Serializable {

    private List<ProductGroup> productGroupList;

    private String filter = "";

    private final Predicate<ProductGroup> productGroupFilterPredicate = productGroup -> productGroup.getName().contains(filter);

    public ProductGroupService() {
        this.productGroupList = init();
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
        Long count = productGroupList.stream()
                .filter(productGroupFilterPredicate)
                .count();
        return count.intValue();
    }

    public Stream<ProductGroup> findAll(int offset, int limit) {
        return productGroupList.stream()
                .filter(productGroupFilterPredicate);
    }

    public void setFilter(String filter) {
        this.filter = Objects.requireNonNull(filter, "filter can't be null");
    }

}
