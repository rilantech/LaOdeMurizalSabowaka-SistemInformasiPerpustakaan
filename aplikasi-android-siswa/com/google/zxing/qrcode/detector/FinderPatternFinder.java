package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix image2) {
        this(image2, (ResultPointCallback) null);
    }

    public FinderPatternFinder(BitMatrix image2, ResultPointCallback resultPointCallback2) {
        this.image = image2;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback2;
    }

    /* access modifiers changed from: protected */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* access modifiers changed from: protected */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* access modifiers changed from: package-private */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        boolean z2 = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 228;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean z3 = false;
        while (i2 < height && !z3) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (!foundPatternCross(iArr)) {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                } else if (handlePossibleCenter(iArr, i2, i3, z2)) {
                    if (this.hasSkipped) {
                        z3 = haveMultiplyConfirmedCenters();
                    } else {
                        int findRowSkip = findRowSkip();
                        int i5 = iArr[2];
                        if (findRowSkip > i5) {
                            i2 += (findRowSkip - i5) - 2;
                            i3 = width - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i4 = 0;
                    i = 2;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i4 = 3;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width, z2)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    z3 = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    private static float centerFromEnd(int[] stateCount, int end) {
        return ((float) ((end - stateCount[4]) - stateCount[3])) - (((float) stateCount[2]) / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = ((float) i) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) >= f2 || Math.abs(f - ((float) iArr[1])) >= f2 || Math.abs((f * 3.0f) - ((float) iArr[2])) >= 3.0f * f2 || Math.abs(f - ((float) iArr[3])) >= f2 || Math.abs(f - ((float) iArr[4])) >= f2) {
            return false;
        }
        return true;
    }

    private int[] getCrossCheckStateCount() {
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean crossCheckDiagonal(int startI, int centerJ, int maxCount, int originalStateCountTotal) {
        int i = startI;
        int i2 = centerJ;
        int i3 = maxCount;
        int[] stateCount = getCrossCheckStateCount();
        int i4 = 0;
        while (i >= i4 && i2 >= i4 && this.image.get(i2 - i4, i - i4)) {
            stateCount[2] = stateCount[2] + 1;
            i4++;
        }
        if (i < i4 || i2 < i4) {
            return false;
        }
        while (i >= i4 && i2 >= i4 && !this.image.get(i2 - i4, i - i4) && stateCount[1] <= i3) {
            stateCount[1] = stateCount[1] + 1;
            i4++;
        }
        if (i < i4 || i2 < i4 || stateCount[1] > i3) {
            return false;
        }
        while (i >= i4 && i2 >= i4 && this.image.get(i2 - i4, i - i4) && stateCount[0] <= i3) {
            stateCount[0] = stateCount[0] + 1;
            i4++;
        }
        if (stateCount[0] > i3) {
            return false;
        }
        int maxI = this.image.getHeight();
        int maxJ = this.image.getWidth();
        int i5 = 1;
        while (i + i5 < maxI && i2 + i5 < maxJ && this.image.get(i2 + i5, i + i5)) {
            stateCount[2] = stateCount[2] + 1;
            i5++;
        }
        if (i + i5 >= maxI || i2 + i5 >= maxJ) {
            return false;
        }
        while (i + i5 < maxI && i2 + i5 < maxJ && !this.image.get(i2 + i5, i + i5) && stateCount[3] < i3) {
            stateCount[3] = stateCount[3] + 1;
            i5++;
        }
        if (i + i5 >= maxI || i2 + i5 >= maxJ || stateCount[3] >= i3) {
            return false;
        }
        while (i + i5 < maxI && i2 + i5 < maxJ && this.image.get(i2 + i5, i + i5) && stateCount[4] < i3) {
            stateCount[4] = stateCount[4] + 1;
            i5++;
        }
        if (stateCount[4] < i3 && Math.abs(((((stateCount[0] + stateCount[1]) + stateCount[2]) + stateCount[3]) + stateCount[4]) - originalStateCountTotal) < originalStateCountTotal * 2 && foundPatternCross(stateCount)) {
            return true;
        }
        return false;
    }

    private float crossCheckVertical(int startI, int centerJ, int maxCount, int originalStateCountTotal) {
        BitMatrix bitMatrix = this.image;
        BitMatrix image2 = bitMatrix;
        int maxI = bitMatrix.getHeight();
        int[] stateCount = getCrossCheckStateCount();
        int i = startI;
        while (i >= 0 && image2.get(centerJ, i)) {
            stateCount[2] = stateCount[2] + 1;
            i--;
        }
        if (i < 0) {
            return Float.NaN;
        }
        while (i >= 0 && !image2.get(centerJ, i) && stateCount[1] <= maxCount) {
            stateCount[1] = stateCount[1] + 1;
            i--;
        }
        if (i < 0 || stateCount[1] > maxCount) {
            return Float.NaN;
        }
        while (i >= 0 && image2.get(centerJ, i) && stateCount[0] <= maxCount) {
            stateCount[0] = stateCount[0] + 1;
            i--;
        }
        if (stateCount[0] > maxCount) {
            return Float.NaN;
        }
        int i2 = startI + 1;
        while (i2 < maxI && image2.get(centerJ, i2)) {
            stateCount[2] = stateCount[2] + 1;
            i2++;
        }
        if (i2 == maxI) {
            return Float.NaN;
        }
        while (i2 < maxI && !image2.get(centerJ, i2) && stateCount[3] < maxCount) {
            stateCount[3] = stateCount[3] + 1;
            i2++;
        }
        if (i2 == maxI || stateCount[3] >= maxCount) {
            return Float.NaN;
        }
        while (i2 < maxI && image2.get(centerJ, i2) && stateCount[4] < maxCount) {
            stateCount[4] = stateCount[4] + 1;
            i2++;
        }
        if (stateCount[4] < maxCount && Math.abs(((((stateCount[0] + stateCount[1]) + stateCount[2]) + stateCount[3]) + stateCount[4]) - originalStateCountTotal) * 5 < originalStateCountTotal * 2 && foundPatternCross(stateCount)) {
            return centerFromEnd(stateCount, i2);
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int startJ, int centerI, int maxCount, int originalStateCountTotal) {
        BitMatrix bitMatrix = this.image;
        BitMatrix image2 = bitMatrix;
        int maxJ = bitMatrix.getWidth();
        int[] stateCount = getCrossCheckStateCount();
        int j = startJ;
        while (j >= 0 && image2.get(j, centerI)) {
            stateCount[2] = stateCount[2] + 1;
            j--;
        }
        if (j < 0) {
            return Float.NaN;
        }
        while (j >= 0 && !image2.get(j, centerI) && stateCount[1] <= maxCount) {
            stateCount[1] = stateCount[1] + 1;
            j--;
        }
        if (j < 0 || stateCount[1] > maxCount) {
            return Float.NaN;
        }
        while (j >= 0 && image2.get(j, centerI) && stateCount[0] <= maxCount) {
            stateCount[0] = stateCount[0] + 1;
            j--;
        }
        if (stateCount[0] > maxCount) {
            return Float.NaN;
        }
        int j2 = startJ + 1;
        while (j2 < maxJ && image2.get(j2, centerI)) {
            stateCount[2] = stateCount[2] + 1;
            j2++;
        }
        if (j2 == maxJ) {
            return Float.NaN;
        }
        while (j2 < maxJ && !image2.get(j2, centerI) && stateCount[3] < maxCount) {
            stateCount[3] = stateCount[3] + 1;
            j2++;
        }
        if (j2 == maxJ || stateCount[3] >= maxCount) {
            return Float.NaN;
        }
        while (j2 < maxJ && image2.get(j2, centerI) && stateCount[4] < maxCount) {
            stateCount[4] = stateCount[4] + 1;
            j2++;
        }
        if (stateCount[4] < maxCount && Math.abs(((((stateCount[0] + stateCount[1]) + stateCount[2]) + stateCount[3]) + stateCount[4]) - originalStateCountTotal) * 5 < originalStateCountTotal && foundPatternCross(stateCount)) {
            return centerFromEnd(stateCount, j2);
        }
        return Float.NaN;
    }

    /* access modifiers changed from: protected */
    public final boolean handlePossibleCenter(int[] stateCount, int i, int j, boolean pureBarcode) {
        int stateCountTotal = stateCount[0] + stateCount[1] + stateCount[2] + stateCount[3] + stateCount[4];
        float centerJ = centerFromEnd(stateCount, j);
        float crossCheckVertical = crossCheckVertical(i, (int) centerJ, stateCount[2], stateCountTotal);
        float centerI = crossCheckVertical;
        if (!Float.isNaN(crossCheckVertical)) {
            float crossCheckHorizontal = crossCheckHorizontal((int) centerJ, (int) centerI, stateCount[2], stateCountTotal);
            float centerJ2 = crossCheckHorizontal;
            if (!Float.isNaN(crossCheckHorizontal) && (!pureBarcode || crossCheckDiagonal((int) centerI, (int) centerJ2, stateCount[2], stateCountTotal))) {
                float estimatedModuleSize = ((float) stateCountTotal) / 7.0f;
                boolean found = false;
                int index = 0;
                while (true) {
                    if (index >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(index);
                    FinderPattern center = finderPattern;
                    if (finderPattern.aboutEquals(estimatedModuleSize, centerI, centerJ2)) {
                        this.possibleCenters.set(index, center.combineEstimate(centerI, centerJ2, estimatedModuleSize));
                        found = true;
                        break;
                    }
                    index++;
                }
                if (!found) {
                    FinderPattern point = new FinderPattern(centerJ2, centerI, estimatedModuleSize);
                    this.possibleCenters.add(point);
                    ResultPointCallback resultPointCallback2 = this.resultPointCallback;
                    if (resultPointCallback2 != null) {
                        resultPointCallback2.foundPossibleResultPoint(point);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        ResultPoint firstConfirmedCenter = null;
        for (FinderPattern next : this.possibleCenters) {
            FinderPattern center = next;
            if (next.getCount() >= 2) {
                if (firstConfirmedCenter == null) {
                    firstConfirmedCenter = center;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(firstConfirmedCenter.getX() - center.getX()) - Math.abs(firstConfirmedCenter.getY() - center.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        for (FinderPattern next : this.possibleCenters) {
            if (next.getCount() >= 2) {
                i++;
                f2 += next.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.possibleCenters) {
            f += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f3);
        }
        if (f <= f2 * 0.05f) {
            return true;
        }
        return false;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size >= 3) {
            float f = 0.0f;
            if (size > 3) {
                float f2 = 0.0f;
                float f3 = 0.0f;
                for (FinderPattern estimatedModuleSize : this.possibleCenters) {
                    float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                    f2 += estimatedModuleSize2;
                    f3 += estimatedModuleSize2 * estimatedModuleSize2;
                }
                float f4 = (float) size;
                float f5 = f2 / f4;
                float sqrt = (float) Math.sqrt((double) ((f3 / f4) - (f5 * f5)));
                Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f5));
                float max = Math.max(0.2f * f5, sqrt);
                int i = 0;
                while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                    if (Math.abs(this.possibleCenters.get(i).getEstimatedModuleSize() - f5) > max) {
                        this.possibleCenters.remove(i);
                        i--;
                    }
                    i++;
                }
            }
            if (this.possibleCenters.size() > 3) {
                for (FinderPattern estimatedModuleSize3 : this.possibleCenters) {
                    f += estimatedModuleSize3.getEstimatedModuleSize();
                }
                Collections.sort(this.possibleCenters, new CenterComparator(f / ((float) this.possibleCenters.size())));
                List<FinderPattern> list = this.possibleCenters;
                list.subList(3, list.size()).clear();
            }
            return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern center1, FinderPattern center2) {
            float dA = Math.abs(center2.getEstimatedModuleSize() - this.average);
            float dB = Math.abs(center1.getEstimatedModuleSize() - this.average);
            if (dA < dB) {
                return -1;
            }
            return dA == dB ? 0 : 1;
        }
    }

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern center1, FinderPattern center2) {
            if (center2.getCount() != center1.getCount()) {
                return center2.getCount() - center1.getCount();
            }
            float dA = Math.abs(center2.getEstimatedModuleSize() - this.average);
            float dB = Math.abs(center1.getEstimatedModuleSize() - this.average);
            if (dA < dB) {
                return 1;
            }
            return dA == dB ? 0 : -1;
        }
    }
}
