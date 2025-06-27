package tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.childs.variantInventories.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tttn_2025.phoneShop.common.entities.audit.AuditableEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.entity.ProductVariantEntity;

@Entity
@Table(name = "variant_inventories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class VariantInventoryEntity extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uid;

    @Column(name = "import_price", nullable = true, precision = 20, scale = 4)
    private BigDecimal importPrice;

    @Column(name = "sale_price", nullable = true, precision = 20, scale = 4)
    private BigDecimal salePrice;

    @Builder.Default
    @Column(name = "total_items", nullable = false)
    private Long totalItems = 0l;

    @Builder.Default
    @Column(name = "left_items", nullable = false)
    private Long leftItems = 0l;

    @OneToOne
    @JoinColumn(name = "variant_uid", unique = true)
    private ProductVariantEntity variant;

}
