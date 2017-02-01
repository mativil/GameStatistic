package org.mativil.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Ivan on 29.01.2017.
 */
@Service
public interface RuntimeStatService<K, V> {
    public Map<K,V> getStatisticMap();
    //public Map
}
