package fr.ingeniance.kata.promotion;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.ingeniance.kata.Article;
import fr.ingeniance.kata.promotion.PromotionNForXPrice;

public class PromtionNForXPriceTest {

	private PromotionNForXPrice promtionNForXPrice;
	private Article articleWithPromotion;

	@Before
	public void setUp() {
		this.promtionNForXPrice = new PromotionNForXPrice(3, 5);
		this.articleWithPromotion = new Article(3, "yaourt", 2, promtionNForXPrice);
	}

	@Test
	public void calculate() {
		assertEquals(new BigDecimal(7), this.promtionNForXPrice.calculate(this.articleWithPromotion, 4));
	}

}
