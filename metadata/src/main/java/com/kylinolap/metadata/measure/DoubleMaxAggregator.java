/*
 * Copyright 2013-2014 eBay Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kylinolap.metadata.measure;

import org.apache.hadoop.io.DoubleWritable;

/**
 * @author yangli9
 * 
 */
public class DoubleMaxAggregator extends MeasureAggregator<DoubleWritable> {

    DoubleWritable max = null;

    @Override
    public void reset() {
        max = null;
    }

    @Override
    public void aggregate(DoubleWritable value) {
        if (max == null)
            max = new DoubleWritable(value.get());
        else if (max.get() < value.get())
            max.set(value.get());
    }

    @Override
    public DoubleWritable getState() {
        return max;
    }

    @Override
    public int getMemBytes() {
        return guessDoubleMemBytes();
    }

}