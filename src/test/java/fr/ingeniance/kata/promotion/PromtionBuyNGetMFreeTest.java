package fr.ingeniance.kata.promotion;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.ingeniance.kata.Article;
import fr.ingeniance.kata.promotion.PromotionBuyNGetMFree;

public class PromtionBuyNGetMFreeTest {

	private PromotionBuyNGetMFree pomotionBuyNGetMFree;
	private Article articleWithPromotion;

	@Before
	public void setUp() {
		this.pomotionBuyNGetMFree = new PromotionBuyNGetMFree(2, 1);
		this.articleWithPromotion = new Article(2, "parfum", 3.5, pomotionBuyNGetMFree);
	}

	@Test
	public void calculate() {
		assertEquals(new BigDecimal(10.5), this.pomotionBuyNGetMFree.calculate(this.articleWithPromotion, 4));
	}

}
