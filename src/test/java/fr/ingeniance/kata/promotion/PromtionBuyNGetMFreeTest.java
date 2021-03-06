package fr.ingeniance.kata.promotion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import fr.ingeniance.kata.Article;

@RunWith(value = BlockJUnit4ClassRunner.class)
public class PromtionBuyNGetMFreeTest {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	private PromotionBuyNGetMFree pomotionBuyNGetMFree;
	private Article articleWithPromotion;
	

	@Before
	public void setUp() {
		this.pomotionBuyNGetMFree = new PromotionBuyNGetMFree(2, 1);
		this.articleWithPromotion = new Article(2, "parfum", 3.5, pomotionBuyNGetMFree);
	}

	@Test
	public void calculateThePromotionCorrectResultat() {
		assertEquals(new BigDecimal(10.5), this.pomotionBuyNGetMFree.calculate(this.articleWithPromotion, 4));
	}

	@Test
	public void calculateThePromotionErrorResultat() {
		assertNotEquals(new BigDecimal(10), this.pomotionBuyNGetMFree.calculate(this.articleWithPromotion, 4));
	}
	
	@Test
	public void calculateThePromotionWithNegatifValue() throws Exception {
		expectedEx.expect(RuntimeException.class);
	    expectedEx.expectMessage("Not valid arguments!!!");
	    throw new IllegalArgumentException("Not valid arguments!!!");
	}

}
