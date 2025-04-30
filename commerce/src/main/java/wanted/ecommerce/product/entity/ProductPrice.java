package wanted.ecommerce.product.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_price")
@Entity
public class ProductPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",
		nullable = false)
	private Long id;

	@Column(name = "base_price",
		nullable = false,
		precision = 12,
		scale = 2)
	private BigDecimal basePrice;

	@Column(name = "sale_price",
		nullable = true,
		precision = 12,
		scale = 2)
	private BigDecimal salePrice;

	@Column(name = "cost_price",
		nullable = true,
		precision = 12,
		scale = 2)
	private BigDecimal costPrice;

	@Column(name = "currency",
		nullable = true,
		columnDefinition = "VARCHAR(3) DEFAULT 'KRW'",
		length = 3)
	private String currency = "KRW"; // default 값

	@Column(name = "tax_rate",
		nullable = true,
		precision = 5,
		scale = 2)
	private BigDecimal taxRate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id",
		nullable = false)
	private Product product;
}
