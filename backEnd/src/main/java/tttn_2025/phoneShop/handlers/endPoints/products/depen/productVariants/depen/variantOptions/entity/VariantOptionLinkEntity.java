package tttn_2025.phoneShop.handlers.endPoints.products.depen.productVariants.depen.variantOptions.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tttn_2025.phoneShop.common.entities.audit.AuditableEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.depen.productVariants.entity.ProductVariantEntity;
import tttn_2025.phoneShop.handlers.endPoints.variantOptions.entity.VariantOptionEntity;

@Entity
@Table(name = "variant_option_links", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "variant_uid", "option_uid"
        })
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class VariantOptionLinkEntity extends AuditableEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "uid", updatable = false, nullable = false)
    private UUID uid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_uid", nullable = false)
    private ProductVariantEntity variant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "option_uid", nullable = false)
    private VariantOptionEntity option;

    @Column(name = "level", nullable = false, columnDefinition = "INT CHECK (level > 0)")
    private Integer level;
}
