package wanted.ecommerce.product.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product_options")
@Entity
public class ProductOption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name",
		nullable = false,
		length = 100)
	private String name;

	@Column(name = "additional_price",
		nullable = true,
		columnDefinition = "DECIMAL(12, 2) DEFAULT 0",
		precision = 12,
		scale = 2)
	private BigDecimal additionalPrice = BigDecimal.ZERO;

	@Column(name = "sku",
		nullable = true,
		length = 100)
	private String sku;

	@Column(name = "stock",
		nullable = true,
		columnDefinition = "INTEGER DEFAULT 0")
	private Integer stock = 0;

	@Column(name = "display_order",
		nullable = true,
		columnDefinition = "INTEGER DEFAULT 0")
	private Integer displayOrder = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "option_group_id",
		nullable = false)
	private ProductOptionGroup optionGroup;

	@OneToMany(mappedBy = "option",
		cascade = CascadeType.ALL,
		orphanRemoval = true)
	private List<ProductImage> productImages = new ArrayList<>();
}
