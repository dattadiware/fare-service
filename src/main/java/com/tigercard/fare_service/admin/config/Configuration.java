package com.tigercard.fare_service.admin.config;

public interface Configuration<K,V> {
    
    public void config(K k, V v) ;
    
    public V getConfig(K k) ; 
    
}
