package com.grinyov.springinaction.spittr.data;

import com.grinyov.springinaction.spittr.model.Spittle;

import java.util.List;

/**
 * Created by green on 28.12.2015.
 */

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
