public class GaussJordan {
    public double[] BestForwardElimination(double[][] A, double[] b) {
        // Will be used a lot
        int aLength = A.length;

        // augment matrix with column vector b
        double[][] augMatrix = new double[aLength][aLength + 1];

        for (int i = 0; i < aLength; i++) {
            // appends arrays A and b
            System.arraycopy(A[i], 0, augMatrix[i], 0, aLength);

            augMatrix[i][aLength] = b[i];
        }

        // Gaussian elimination
        for (int k = 0; k < aLength; k++) {
            // find pivot row
            int pivot = k;

            for (int i = k + 1; i < aLength; i++) {
                if (Math.abs(augMatrix[i][k]) > Math.abs(augMatrix[pivot][k])) {
                    pivot = i;
                }
            }

            // swap rows if needed
            if (pivot != k) {
                double[] temp = augMatrix[k];
                augMatrix[k] = augMatrix[pivot];
                augMatrix[pivot] = temp;
            }

            // eliminate below pivot
            for (int i = k + 1; i < aLength; i++) {
                double factor = augMatrix[i][k] / augMatrix[k][k];

                for (int j = k + 1; j <= aLength; j++) {
                    augMatrix[i][j] -= factor * augMatrix[k][j];
                }
            }
        }

        // back substitution
        double[] x = new double[aLength];

        for (int i = aLength - 1; i >= 0; i--) {
            double sum = 0;

            for (int j = i + 1; j < aLength; j++) {
                sum += augMatrix[i][j] * x[j];
            }
            // Round to account for division shenanigans
            x[i] = Math.round((augMatrix[i][aLength] - sum) / augMatrix[i][i]);
        }

        return x;
    }
}
