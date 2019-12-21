package com.bawei.mymodel.model.entity;

import java.util.List;

public class ProductEntity {
    public String message;
    public String status;
    public List<Product> result;

    public class Product{
        public String commodityId;
        public String commodityName;
        public String masterPic;
        public String price;
        public String saleNum;
    }
}
