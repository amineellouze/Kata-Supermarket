package fr.ingeniance.kata;

import java.math.BigDecimal;

import fr.ingeniance.kata.promotion.Promotion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article {
	
	private int id;
	private String name;
	private double price;
	private Promotion promotion;

	public Article(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public BigDecimal calculate(int quantity) {
		if (this.promotion != null) {
			return promotion.calculate(this, quantity);
		} else {
			return new BigDecimal(this.price * quantity);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
