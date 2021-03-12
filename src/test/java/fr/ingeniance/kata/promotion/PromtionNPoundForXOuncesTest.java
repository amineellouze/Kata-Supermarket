package fr.ingeniance.kata.promotion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.ingeniance.kata.Article;

public class PromtionNPoundForXOuncesTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	
	private PromotionNPoundForXOunces promtionNPoundForXOunces;
	private Article articleWithPromotion;

	@Before
	public void setUp() {
		this.promtionNPoundForXOunces = new PromotionNPoundForXOunces(1.99);
		this.articleWithPromotion = new Article(3, "yaourt", 2, promtionNPoundForXOunces);
	}

	@Test
	public void calculateThePromotionCorrectResultat() {
		assertEquals(new BigDecimal(0.4975), this.promtionNPoundForXOunces.calculate(this.articleWithPromotion, 4));
	}
	
	@Test
	public void calculateThePromotionErrorResultat() {
		assertNotEquals(new BigDecimal(0.5), this.promtionNPoundForXOunces.calculate(this.articleWithPromotion, 4));
	}
	
	@Test
	public void calculateThePromotionWithNegatifValue() throws Exception {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Not valid arguments!!!");
	    throw new IllegalArgumentException("Not valid arguments!!!");
	}

}
