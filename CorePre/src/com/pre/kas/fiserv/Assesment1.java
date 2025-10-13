package com.pre.kas.fiserv;


import java.util.List;
import java.util.stream.Collectors;

class Product{
    private String product;
    private List<String> productDomain;

    public Product(String product, List<String> productDomain) {
        this.product = product;
        this.productDomain = productDomain;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public List<String> getProductDomain() {
        return productDomain;
    }

    public void setProductDomain(List<String> productDomain) {
        this.productDomain = productDomain;
    }
}

class ProductDomain{

    private List<String> productDomain;

    public ProductDomain(List<String> productDomain) {
        this.productDomain = productDomain;
    }

    public List<String> getProductDomain() {
        return productDomain;
    }

    public void setProductDomain(List<String> productDomain) {
        this.productDomain = productDomain;
    }
}
public class Assesment1 {

    public static void main(String[] args) {

        List<String> lst1 = List.of("D1","D2","D3","D4","D5");
        List<String> lst2 = List.of("D10","D1","D5","D3","D9");


        List<String> matched = lst1
                .stream()
                .filter(
                    lst2::contains
                )
                .collect(Collectors.toList());

        System.out.println("Matched List = "+matched);

        List<Product> productList = List.of(
                new Product("P1", List.of("D1")),
                new Product("P2", List.of("D2","D3")),
                new Product("P3", List.of("D2","D4")),
                new Product("P4", List.of("D3","D1"))
        );

        //ProductDomain productDomain = new ProductDomain(Arrays.asList("D1","D2","D3"));
        ProductDomain productDomain = new ProductDomain(List.of("D1","D2","D3"));


        List<String>   filteredlist = productList
                .stream()
                .filter(product ->{
                    long count = product.getProductDomain()
                            .stream()
                            .filter(productDomain.getProductDomain()::contains).count();
                    return count >= 2;
                })
                .map(product -> {
                   String prod = product.getProduct();
                   return prod;
                })
                .collect(Collectors.toList());

        System.out.println("Filtered List = "+filteredlist);
    }
}
