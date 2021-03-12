package fr.ingeniance.kata;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.ingeniance.kata.Article;
import fr.ingeniance.kata.Cart;
import fr.ingeniance.kata.promotion.PromotionBuyNGetMFree;
import fr.ingeniance.kata.promotion.PromotionNForXPrice;
import fr.ingeniance.kata.promotion.PromotionNPoundForXOunces;

public class CartTest {

	private Cart cart;
	private Article article;
	private Article articleWithPromotionBuyNGetMFree;
	private Article articleWithPromotionNForXPrice;
	private Article articleWithPromotionNPoundForXOunces;
	PromotionBuyNGetMFree promotionBuyNGetMFree;
	PromotionNForXPrice promotionNForXPrice;
	PromotionNPoundForXOunces promotionNPoundForXOunces;

	@Before
	public void setUp() {
		this.cart = new Cart();
		this.promotionBuyNGetMFree = new PromotionBuyNGetMFree(2,1);
		this.promotionNForXPrice = new PromotionNForXPrice(3,1);
		this.promotionNPoundForXOunces = new PromotionNPoundForXOunces(4);
		this.article = new Article(1, "chocolate", 2.5);
		this.articleWithPromotionBuyNGetMFree = new Article(2, "parfum", 3.5, promotionBuyNGetMFree);
		this.articleWithPromotionNForXPrice = new Article(3, "lait", 3.5, promotionNForXPrice);
		this.articleWithPromotionNPoundForXOunces = new Article(4, "Nestlé", 3.5, promotionNPoundForXOunces);
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
		this.cart.add(this.articleWithPromotionBuyNGetMFree, 3);
		assertEquals(1, this.cart.getCart().size());
		assertEquals(new Integer(3), this.cart.getCart().get(this.articleWithPromotionBuyNGetMFree));
	}

	@Test
	public void calculatArticleWithPromotionBuyNGetMFreeTest() {
		this.cart.add(this.articleWithPromotionBuyNGetMFree, 2);
		assertEquals(new BigDecimal(7), this.cart.calculate());
	}
	
	@Test
	public void calculatArticleWithPromotionNForXPrice() {
		this.cart.add(this.articleWithPromotionBuyNGetMFree, 5);
		assertEquals(new BigDecimal(14), this.cart.calculate());
	}
	
	@Test
	public void calculatArticleWithPromotionNPoundForXOunces() {
		this.cart.add(this.articleWithPromotionNPoundForXOunces, 5);
		assertEquals(new BigDecimal(1.25), this.cart.calculate());
	}
}
