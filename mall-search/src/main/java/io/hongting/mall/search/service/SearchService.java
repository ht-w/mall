package io.hongting.mall.search.service;

import io.hongting.mall.search.vo.SearchParam;
import io.hongting.mall.search.vo.SearchResult;
import org.springframework.stereotype.Controller;

/**
 * @author hongting
 * @create 2021 07 15 2:40 PM
 */


public interface SearchService {

    SearchResult search(SearchParam searchParam);
}
