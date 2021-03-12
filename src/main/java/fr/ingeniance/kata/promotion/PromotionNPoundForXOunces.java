package fr.ingeniance.kata.promotion;

import java.math.BigDecimal;

import fr.ingeniance.kata.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromotionNPoundForXOunces implements Promotion {

	/** The promotion price For one Pound. */
	private double promotionPricePound;

	/**
	 * Calculate the Promotion with the promotion quantity Ounces for The promotion
	 * price for One Pound.
	 *
	 * @param article  the article
	 * @param quantity the quantity Ounces
	 * @return the big decimal
	 */
	public BigDecimal calculate(Article article, int quantity) {
		if (promotionPricePound > 0) {
			return new BigDecimal((promotionPricePound / 16) * quantity);
		} else {
			throw new IllegalArgumentException("Not valid arguments!!!");
		}
	}
}
