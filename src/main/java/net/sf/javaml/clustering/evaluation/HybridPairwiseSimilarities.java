/**
 * This file is part of the Java Machine Learning Library
 * <p>
 * The Java Machine Learning Library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * <p>
 * The Java Machine Learning Library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with the Java Machine Learning Library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * <p>
 * Copyright (c) 2006-2012, Thomas Abeel
 * <p>
 * Project: http://java-ml.sourceforge.net/
 */
package net.sf.javaml.clustering.evaluation;

import net.sf.javaml.core.Dataset;

/**
 * H_1 from the Zhao 2001 paper
 * <p>
 * TODO uitleg
 *
 * @author Andreas De Rijcke
 */

public class HybridPairwiseSimilarities implements ClusterEvaluation {

    /**
     * XXX DOC
     */
    public double score(Dataset[] data) {
        ClusterEvaluation ceTop = new SumOfAveragePairwiseSimilarities();// I_1
        double sum = ceTop.score(data);
        ClusterEvaluation ce = new TraceScatterMatrix();// E_1
        sum /= ce.score(data);

        return sum;
    }

    /**
     * XXX DOC
     */
    public boolean compareScore(double score1, double score2) {
        // should be maxed
        return score2 > score1;
    }
}
