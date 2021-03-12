package fr.ingeniance.kata;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

@Getter
public class Cart {

	/** The cart. */
	private Map<Article, Integer> cart = new HashMap<>();

	/**
	 * Adds the article in the cart.
	 *
	 * @param article  the article
	 * @param quantity the quantity
	 */
	public void add(Article article, int quantity) {
		int count = cart.containsKey(article) ? cart.get(article) : 0;
		cart.put(article, count + quantity);
	}

	/**
	 * Calculate the total amount.
	 *
	 * @return the big decimal which represents the total
	 */
	public BigDecimal calculate() {
		return this.cart.entrySet().stream().map(entry -> {
			if (entry.getKey().getPromotion() != null) {
				return entry.getKey().getPromotion().calculate(entry.getKey(), entry.getValue());
			} else {
				return new BigDecimal(entry.getKey().getPrice() * entry.getValue());
			}
		}).reduce(new BigDecimal(0), BigDecimal::add);
	}

}
