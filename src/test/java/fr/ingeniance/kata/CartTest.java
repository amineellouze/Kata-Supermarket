package fr.ingeniance.kata;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.ingeniance.kata.Article;
import fr.ingeniance.kata.Cart;
import fr.ingeniance.kata.promotion.PromotionBuyNGetMFree;

public class CartTest {

	private Cart cart;
	private Article article;
	private Article articleWithPromotion;
	PromotionBuyNGetMFree promotionBuyNGetMFree;

	@Before
	public void setUp() {
		this.cart = new Cart();
		this.promotionBuyNGetMFree = new PromotionBuyNGetMFree(2, 1);
		this.article = new Article(1, "chocolate", 2.5);
		this.articleWithPromotion = new Article(2, "parfum", 3.5, promotionBuyNGetMFree);
	}

	@Test
	public void addTest() {
		this.cart.add(this.article, 2);
		assertEquals(1, this.cart.getCart().size());
		assertEquals(new Integer(2), this.cart.getCart().get(this.article));
	}

	@Test
	public void calculatTest() {
		this.cart.add(this.article, 2);
		assertEquals(new BigDecimal(5), this.cart.calculate());
	}

	@Test
	public void addArticleWithPromotionTest() {
		this.cart.add(this.articleWithPromotion, 3);
		assertEquals(1, this.cart.getCart().size());
		assertEquals(new Integer(3), this.cart.getCart().get(this.articleWithPromotion));
	}

	@Test
	public void calculatArticleWithPromotionTest() {
		this.cart.add(this.articleWithPromotion, 2);
		assertEquals(new BigDecimal(7), this.cart.calculate());
	}
}
