import java.util.*;

interface ProductService {
    String getDetails(final String productId);
}

class RealProductService implements ProductService {
    @Override
    public String getDetails(final String productId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        return "Product details of id: " + productId;
    }
}

class ProductServiceProxy implements ProductService {
    private final ProductService productService;
    private final Map<String, String> cache;

    public ProductServiceProxy(ProductService productService) {
        this.productService = productService;
        cache = new HashMap<>();
    }

    @Override
    public String getDetails(final String productId) {
        return cache.computeIfAbsent(productId, productService::getDetails);
    }
}

public class ProxyDemo {
    public static void main(String[] args) {
        final ProductService productService = new RealProductService();
        final ProductService service = new ProductServiceProxy(productService);
        final String productId = "123";
        long start = System.currentTimeMillis();
        System.out.println(service.getDetails(productId));
        System.out.println("Time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        System.out.println(service.getDetails(productId));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }
}
