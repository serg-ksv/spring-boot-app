package mate.academy.springbootapp.controller;

import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import mate.academy.springbootapp.model.dto.ProductResponseDto;
import mate.academy.springbootapp.model.mapper.ProductMapper;
import mate.academy.springbootapp.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/most-commented")
    @ApiOperation(value = "Finds the most commented products")
    public List<ProductResponseDto> getMostCommented(@RequestParam(defaultValue = "1000")
                                                             int limit) {
        return productService.getMostCommented(limit).stream()
                .map(productMapper::getDtoFromProduct)
                .collect(Collectors.toList());
    }
}
