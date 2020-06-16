package com.ecommerce.orderdetailsservice.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderProductKey oPKey;

	private Integer quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(OrderProductKey oPKey, Integer quantity) {
		super();
		this.oPKey = oPKey;
		this.quantity = quantity;
	}

	public OrderProductKey getoPKey() {
		return oPKey;
	}

	public void setoPKey(OrderProductKey oPKey) {
		this.oPKey = oPKey;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oPKey == null) ? 0 : oPKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProduct other = (OrderProduct) obj;
		if (oPKey == null) {
			if (other.oPKey != null)
				return false;
		} else if (!oPKey.equals(other.oPKey))
			return false;
		return true;
	}
}
