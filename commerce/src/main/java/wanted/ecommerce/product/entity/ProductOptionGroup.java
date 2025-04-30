package wanted.ecommerce.product.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "product_option_groups")
@Entity
public class ProductOptionGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "name",
		nullable = false,
		length = 100)
	private String name;

	@Column(name = "display_order",
		nullable = true,
		columnDefinition = "INTEGER DEFAULT 0")
	private Integer displayOrder = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@OneToMany(mappedBy = "optionGroup",
		fetch = FetchType.LAZY)
	private List<ProductOption> options = new ArrayList<>();
}
