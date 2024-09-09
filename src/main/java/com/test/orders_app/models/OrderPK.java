package com.test.orders_app.models;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class OrderPK implements Serializable {
    private Integer id;
    private Integer productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderPK orderPK = (OrderPK) o;
        return Objects.equals(id, orderPK.id) &&
                Objects.equals(productId, orderPK.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId);
    }
}
