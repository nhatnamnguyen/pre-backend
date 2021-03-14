package com.nhatnam.backend.data;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equal(getId(), customer.getId()) && Objects.equal(getName(), customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getName());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .toString();
    }
}
