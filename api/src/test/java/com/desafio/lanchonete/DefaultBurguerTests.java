package com.desafio.lanchonete;

import com.desafio.lanchonete.domain.model.Burguer;
import com.desafio.lanchonete.domain.model.Ingredient;
import com.desafio.lanchonete.repository.BurguerRepository;
import com.desafio.lanchonete.repository.IngredientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultBurguerTests {

	@Autowired
	private IngredientRepository ingredientRepository;

	@Autowired
	private BurguerRepository burguerRepository;

	@Test
	public void valid_xbacon_price() {

		Ingredient bacon = ingredientRepository.getOne(2L);
		Ingredient hamburguer = ingredientRepository.getOne(3L);
		Ingredient queijo = ingredientRepository.getOne(5L);

		BigDecimal totalAmountIngredients = BigDecimal.valueOf(bacon.getValue().doubleValue() + queijo.getValue().doubleValue() + hamburguer.getValue().doubleValue());

		Burguer burguerXBacon = burguerRepository.getOne(1L);

		BigDecimal totalAmountBurguerIngredients = BigDecimal.valueOf(burguerXBacon.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

		assertThat(totalAmountBurguerIngredients).isEqualTo(totalAmountIngredients);
	}

	@Test
	public void valid_xburguer_price() {

		Ingredient hamburguer = ingredientRepository.getOne(3L);
		Ingredient queijo = ingredientRepository.getOne(5L);

		BigDecimal totalAmountIngredients = BigDecimal.valueOf(queijo.getValue().doubleValue() + hamburguer.getValue().doubleValue());

		Burguer burguerXBacon = burguerRepository.getOne(2L);

		BigDecimal totalAmountBurguerIngredients = BigDecimal.valueOf(burguerXBacon.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

		assertThat(totalAmountBurguerIngredients).isEqualTo(totalAmountIngredients);
	}

	@Test
	public void valid_xegg_price() {

		Ingredient ovo = ingredientRepository.getOne(4L);
		Ingredient hamburguer = ingredientRepository.getOne(3L);
		Ingredient queijo = ingredientRepository.getOne(5L);

		BigDecimal totalAmountIngredients = BigDecimal.valueOf(ovo.getValue().doubleValue() + queijo.getValue().doubleValue() + hamburguer.getValue().doubleValue());

		Burguer burguerXBacon = burguerRepository.getOne(3L);

		BigDecimal totalAmountBurguerIngredients = BigDecimal.valueOf(burguerXBacon.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

		assertThat(totalAmountBurguerIngredients).isEqualTo(totalAmountIngredients);
	}

	@Test
	public void valid_xeggbacon_price() {

		Ingredient bacon = ingredientRepository.getOne(2L);
		Ingredient hamburguer = ingredientRepository.getOne(3L);
		Ingredient queijo = ingredientRepository.getOne(5L);
		Ingredient ovo = ingredientRepository.getOne(4L);

		BigDecimal totalAmountIngredients = BigDecimal.valueOf(
				ovo.getValue().doubleValue() + bacon.getValue().doubleValue() + queijo.getValue().doubleValue() + hamburguer.getValue().doubleValue());

		Burguer burguerXBacon = burguerRepository.getOne(4L);

		BigDecimal totalAmountBurguerIngredients = BigDecimal.valueOf(burguerXBacon.getIngredients().stream().mapToDouble(i -> i.getValue().doubleValue()).sum());

		assertThat(totalAmountBurguerIngredients).isEqualTo(totalAmountIngredients);
	}

}
