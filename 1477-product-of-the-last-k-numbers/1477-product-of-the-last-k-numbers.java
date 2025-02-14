class ProductOfNumbers {
    List<Integer> prefixProduct;


    public ProductOfNumbers() {
        prefixProduct = new ArrayList<>();
    }
    
    public void add(int num) {
        if(num==0){
            prefixProduct.clear();
        }
        else{
            if(prefixProduct.size() == 0){
                prefixProduct.add(num);
            }
            else{
                prefixProduct.add(prefixProduct.get(prefixProduct.size()-1) * num);
            }
        }
        
    }
    
    public int getProduct(int k) {
        int n = prefixProduct.size();
        if(k>n){
            return 0;
        }
        else if(k==n){
            return prefixProduct.get(n-1);
        }
        else{
            return prefixProduct.get(n-1)/prefixProduct.get(n-1-k);
        }
               
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */