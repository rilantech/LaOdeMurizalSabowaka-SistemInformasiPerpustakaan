package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    UPCEANExtension5Support() {
    }

    /* access modifiers changed from: package-private */
    public Result decodeRow(int rowNumber, BitArray row, int[] extensionStartRange) throws NotFoundException {
        StringBuilder sb = this.decodeRowStringBuffer;
        StringBuilder result = sb;
        sb.setLength(0);
        int end = decodeMiddle(row, extensionStartRange, result);
        String sb2 = result.toString();
        String resultString = sb2;
        Map<ResultMetadataType, Object> extensionData = parseExtensionString(sb2);
        Result extensionResult = new Result(resultString, (byte[]) null, new ResultPoint[]{new ResultPoint(((float) (extensionStartRange[0] + extensionStartRange[1])) / 2.0f, (float) rowNumber), new ResultPoint((float) end, (float) rowNumber)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (extensionData != null) {
            extensionResult.putAllMetadata(extensionData);
        }
        return extensionResult;
    }

    private int decodeMiddle(BitArray row, int[] startRange, StringBuilder resultString) throws NotFoundException {
        int[] iArr = this.decodeMiddleCounters;
        int[] counters = iArr;
        iArr[0] = 0;
        counters[1] = 0;
        counters[2] = 0;
        counters[3] = 0;
        int end = row.getSize();
        int rowOffset = startRange[1];
        int lgPatternFound = 0;
        for (int x = 0; x < 5 && rowOffset < end; x++) {
            int bestMatch = UPCEANReader.decodeDigit(row, counters, rowOffset, UPCEANReader.L_AND_G_PATTERNS);
            resultString.append((char) ((bestMatch % 10) + 48));
            for (int counter : counters) {
                rowOffset += counter;
            }
            if (bestMatch >= 10) {
                lgPatternFound |= 1 << (4 - x);
            }
            if (x != 4) {
                rowOffset = row.getNextUnset(row.getNextSet(rowOffset));
            }
        }
        if (resultString.length() == 5) {
            if (extensionChecksum(resultString.toString()) == determineCheckDigit(lgPatternFound)) {
                return rowOffset;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence s) {
        int length = s.length();
        int sum = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            sum += s.charAt(i) - '0';
        }
        int sum2 = sum * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            sum2 += s.charAt(i2) - '0';
        }
        return (sum2 * 3) % 10;
    }

    private static int determineCheckDigit(int lgPatternFound) throws NotFoundException {
        for (int d = 0; d < 10; d++) {
            if (lgPatternFound == CHECK_DIGIT_ENCODINGS[d]) {
                return d;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String raw) {
        if (raw.length() != 5) {
            return null;
        }
        Object parseExtension5String = parseExtension5String(raw);
        Object value = parseExtension5String;
        if (parseExtension5String == null) {
            return null;
        }
        Map<ResultMetadataType, Object> enumMap = new EnumMap<>(ResultMetadataType.class);
        Map<ResultMetadataType, Object> result = enumMap;
        enumMap.put(ResultMetadataType.SUGGESTED_PRICE, value);
        return result;
    }

    private static String parseExtension5String(String raw) {
        String currency;
        switch (raw.charAt(0)) {
            case '0':
                currency = "£";
                break;
            case '5':
                currency = "$";
                break;
            case '9':
                if (!"90000".equals(raw)) {
                    if (!"99991".equals(raw)) {
                        if (!"99990".equals(raw)) {
                            currency = "";
                            break;
                        } else {
                            return "Used";
                        }
                    } else {
                        return "0.00";
                    }
                } else {
                    return null;
                }
            default:
                currency = "";
                break;
        }
        int parseInt = Integer.parseInt(raw.substring(1));
        int rawAmount = parseInt;
        int i = rawAmount % 100;
        int hundredths = i;
        return currency + String.valueOf(parseInt / 100) + '.' + (i < 10 ? "0" + hundredths : String.valueOf(hundredths));
    }
}
