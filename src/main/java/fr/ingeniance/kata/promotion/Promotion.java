package fr.ingeniance.kata.promotion;

import java.math.BigDecimal;

import fr.ingeniance.kata.Article;

public interface Promotion {
	BigDecimal calculate(Article article, int quantity);
}
