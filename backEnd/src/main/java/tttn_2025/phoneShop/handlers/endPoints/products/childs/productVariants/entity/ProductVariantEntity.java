package tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import tttn_2025.phoneShop.common.entities.audit.AuditableEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.childs.variantAttributes.entity.VariantAttributeEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.childs.variantInventories.entity.VariantInventoryEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.childs.productVariants.childs.variantPhotos.entity.VariantPhotoEntity;
import tttn_2025.phoneShop.handlers.endPoints.products.selft.entity.ProductEntity;

@Entity
@Table(name = "product_variants", uniqueConstraints = {
                @UniqueConstraint(columnNames = {
                                "product_uid", "sku"
                })
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class ProductVariantEntity extends AuditableEntity {

        @Id
        @GeneratedValue(generator = "UUID")
        @Column(name = "uid", updatable = false, nullable = false)
        private UUID uid;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_uid", nullable = false)
        private ProductEntity product;

        @Column(name = "sku")
        private String sku;

        @OneToMany(mappedBy = "variant", fetch = FetchType.LAZY)
        List<VariantAttributeEntity> attributes;

        @OneToMany(mappedBy = "variant", fetch = FetchType.LAZY)
        List<VariantPhotoEntity> photos;

        @OneToOne(mappedBy = "variant", fetch = FetchType.LAZY)
        private VariantInventoryEntity inventory;
}
