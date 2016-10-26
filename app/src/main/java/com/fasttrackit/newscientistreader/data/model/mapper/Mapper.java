package com.fasttrackit.newscientistreader.data.model.mapper;

/**
 * @author mihai.mecea
 */
public interface Mapper<P, R> {

  R map(P model);
}
