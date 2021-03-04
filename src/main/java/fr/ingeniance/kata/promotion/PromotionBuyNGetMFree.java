package fr.ingeniance.kata.promotion;

import java.math.BigDecimal;

import fr.ingeniance.kata.Article;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PromotionBuyNGetMFree implements Promotion {

	/** The promotion quantity. */
	private int promotionQuantity;

	/** The promotion quantity free. */
	private int promotionQuantityFree;

	/**
	 * Calculate the total amount the promotion quantity, get The promotion quantity
	 * free.
	 *
	 * @param article  the article
	 * @param quantity the quantity
	 * @return the bigdecimal of the total
	 */
	public BigDecimal calculate(Article article, int quantity) {
		if (promotionQuantityFree > 0 && promotionQuantity > 0) {
			int promotionPackage = promotionQuantityFree + promotionQuantity;
			int promotionPackageNbr = quantity / promotionPackage;
			int promotionPackageRest = quantity % promotionPackage;
			return new BigDecimal(promotionPackageNbr * (promotionQuantity * article.getPrice())
					+ promotionPackageRest * article.getPrice());
		} else {
			throw new IllegalArgumentException("Not valid arguments!!!");
		}
	}

}
