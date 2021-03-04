package fr.ingeniance.kata.promotion;

import java.math.BigDecimal;

import fr.ingeniance.kata.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromotionNForXPrice implements Promotion {

	/** The promotion quantity. */
	private int promotionQuantity;

	/** The promotion price. */
	private double promotionPrice;

	/**
	 * Calculate the Promotion with the promotion quantity for The promotion price.
	 *
	 * @param article  the article
	 * @param quantity the quantity
	 * @return the big decimal
	 */
	public BigDecimal calculate(Article article, int quantity) {

		if (promotionPrice > 0 && promotionQuantity > 0) {

			int promotionNbr = quantity / promotionQuantity;
			int restQte = quantity % promotionQuantity;

			return new BigDecimal(promotionPrice * promotionNbr + (article.getPrice() * restQte));
		} else {
			throw new IllegalArgumentException("Not valid arguments!!!");
		}
	}
}
