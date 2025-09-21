package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;

    private enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger nineHundred = BigInteger.valueOf(900);
        bigIntegerArr[1] = nineHundred;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i < bigIntegerArr2.length) {
                bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(nineHundred);
                i++;
            } else {
                return;
            }
        }
    }

    private DecodedBitStreamParser() {
    }

    static DecoderResult decode(int[] iArr, String str) throws FormatException {
        int i;
        StringBuilder sb = new StringBuilder(iArr.length << 1);
        Charset charset = DEFAULT_ENCODING;
        int i2 = iArr[1];
        PDF417ResultMetadata pDF417ResultMetadata = new PDF417ResultMetadata();
        int i3 = 2;
        while (i3 < iArr[0]) {
            switch (i2) {
                case 900:
                    i = textCompaction(iArr, i3, sb);
                    break;
                case 901:
                case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    i = byteCompaction(i2, iArr, charset, i3, sb);
                    break;
                case 902:
                    i = numericCompaction(iArr, i3, sb);
                    break;
                case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                    i = i3 + 1;
                    sb.append((char) iArr[i3]);
                    break;
                case MACRO_PDF417_TERMINATOR /*922*/:
                case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    throw FormatException.getFormatInstance();
                case ECI_USER_DEFINED /*925*/:
                    i = i3 + 1;
                    break;
                case ECI_GENERAL_PURPOSE /*926*/:
                    i = i3 + 2;
                    break;
                case ECI_CHARSET /*927*/:
                    i = i3 + 1;
                    charset = Charset.forName(CharacterSetECI.getCharacterSetECIByValue(iArr[i3]).name());
                    break;
                case 928:
                    i = decodeMacroBlock(iArr, i3, pDF417ResultMetadata);
                    break;
                default:
                    i = textCompaction(iArr, i3 - 1, sb);
                    break;
            }
            if (i < iArr.length) {
                i3 = i + 1;
                i2 = iArr[i];
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (sb.length() != 0) {
            DecoderResult decoderResult = new DecoderResult((byte[]) null, sb.toString(), (List<byte[]>) null, str);
            decoderResult.setOther(pDF417ResultMetadata);
            return decoderResult;
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] codewords, int codeIndex, PDF417ResultMetadata resultMetadata) throws FormatException {
        if (codeIndex + 2 <= codewords[0]) {
            int[] segmentIndexArray = new int[2];
            int i = 0;
            while (i < 2) {
                segmentIndexArray[i] = codewords[codeIndex];
                i++;
                codeIndex++;
            }
            resultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(segmentIndexArray, 2)));
            StringBuilder fileId = new StringBuilder();
            int codeIndex2 = textCompaction(codewords, codeIndex, fileId);
            resultMetadata.setFileId(fileId.toString());
            if (codewords[codeIndex2] == BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                int additionalOptionCodeWordsIndex = codeIndex2 + 1;
                int[] additionalOptionCodeWords = new int[(codewords[0] - additionalOptionCodeWordsIndex)];
                int additionalOptionCodeWordsIndex2 = 0;
                boolean end = false;
                while (additionalOptionCodeWordsIndex < codewords[0] && !end) {
                    int codeIndex3 = additionalOptionCodeWordsIndex + 1;
                    int codeIndex4 = codewords[additionalOptionCodeWordsIndex];
                    int code = codeIndex4;
                    if (codeIndex4 < 900) {
                        additionalOptionCodeWords[additionalOptionCodeWordsIndex2] = code;
                        additionalOptionCodeWordsIndex2++;
                        additionalOptionCodeWordsIndex = codeIndex3;
                    } else {
                        switch (code) {
                            case MACRO_PDF417_TERMINATOR /*922*/:
                                resultMetadata.setLastSegment(true);
                                additionalOptionCodeWordsIndex = codeIndex3 + 1;
                                end = true;
                                break;
                            default:
                                throw FormatException.getFormatInstance();
                        }
                    }
                }
                resultMetadata.setOptionalData(Arrays.copyOf(additionalOptionCodeWords, additionalOptionCodeWordsIndex2));
                return additionalOptionCodeWordsIndex;
            } else if (codewords[codeIndex2] != MACRO_PDF417_TERMINATOR) {
                return codeIndex2;
            } else {
                resultMetadata.setLastSegment(true);
                return codeIndex2 + 1;
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    private static int textCompaction(int[] codewords, int codeIndex, StringBuilder result) {
        int[] textCompactionData = new int[((codewords[0] - codeIndex) << 1)];
        int[] byteCompactionData = new int[((codewords[0] - codeIndex) << 1)];
        int index = 0;
        boolean end = false;
        while (codeIndex < codewords[0] && !end) {
            int codeIndex2 = codeIndex + 1;
            int codeIndex3 = codewords[codeIndex];
            int code = codeIndex3;
            if (codeIndex3 >= 900) {
                switch (code) {
                    case 900:
                        textCompactionData[index] = 900;
                        index++;
                        codeIndex = codeIndex2;
                        break;
                    case 901:
                    case 902:
                    case MACRO_PDF417_TERMINATOR /*922*/:
                    case BEGIN_MACRO_PDF417_OPTIONAL_FIELD /*923*/:
                    case BYTE_COMPACTION_MODE_LATCH_6 /*924*/:
                    case 928:
                        codeIndex = codeIndex2 - 1;
                        end = true;
                        break;
                    case MODE_SHIFT_TO_BYTE_COMPACTION_MODE /*913*/:
                        textCompactionData[index] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                        codeIndex = codeIndex2 + 1;
                        byteCompactionData[index] = codewords[codeIndex2];
                        index++;
                        break;
                    default:
                        codeIndex = codeIndex2;
                        break;
                }
            } else {
                textCompactionData[index] = code / 30;
                textCompactionData[index + 1] = code % 30;
                index += 2;
                codeIndex = codeIndex2;
            }
        }
        decodeTextCompaction(textCompactionData, byteCompactionData, index, result);
        return codeIndex;
    }

    private static void decodeTextCompaction(int[] textCompactionData, int[] byteCompactionData, int length, StringBuilder result) {
        Mode subMode = Mode.ALPHA;
        Mode priorToShiftMode = Mode.ALPHA;
        for (int i = 0; i < length; i++) {
            int subModeCh = textCompactionData[i];
            char ch = 0;
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[subMode.ordinal()]) {
                case 1:
                    if (subModeCh >= 26) {
                        if (subModeCh != 26) {
                            if (subModeCh != 27) {
                                if (subModeCh != 28) {
                                    if (subModeCh != 29) {
                                        if (subModeCh != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            if (subModeCh == 900) {
                                                subMode = Mode.ALPHA;
                                                break;
                                            }
                                        } else {
                                            result.append((char) byteCompactionData[i]);
                                            break;
                                        }
                                    } else {
                                        priorToShiftMode = subMode;
                                        subMode = Mode.PUNCT_SHIFT;
                                        break;
                                    }
                                } else {
                                    subMode = Mode.MIXED;
                                    break;
                                }
                            } else {
                                subMode = Mode.LOWER;
                                break;
                            }
                        } else {
                            ch = ' ';
                            break;
                        }
                    } else {
                        ch = (char) (subModeCh + 65);
                        break;
                    }
                    break;
                case 2:
                    if (subModeCh >= 26) {
                        if (subModeCh != 26) {
                            if (subModeCh != 27) {
                                if (subModeCh != 28) {
                                    if (subModeCh != 29) {
                                        if (subModeCh != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                            if (subModeCh == 900) {
                                                subMode = Mode.ALPHA;
                                                break;
                                            }
                                        } else {
                                            result.append((char) byteCompactionData[i]);
                                            break;
                                        }
                                    } else {
                                        priorToShiftMode = subMode;
                                        subMode = Mode.PUNCT_SHIFT;
                                        break;
                                    }
                                } else {
                                    subMode = Mode.MIXED;
                                    break;
                                }
                            } else {
                                priorToShiftMode = subMode;
                                subMode = Mode.ALPHA_SHIFT;
                                break;
                            }
                        } else {
                            ch = ' ';
                            break;
                        }
                    } else {
                        ch = (char) (subModeCh + 97);
                        break;
                    }
                    break;
                case 3:
                    if (subModeCh >= 25) {
                        if (subModeCh != 25) {
                            if (subModeCh != 26) {
                                if (subModeCh != 27) {
                                    if (subModeCh != 28) {
                                        if (subModeCh != 29) {
                                            if (subModeCh != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                                if (subModeCh == 900) {
                                                    subMode = Mode.ALPHA;
                                                    break;
                                                }
                                            } else {
                                                result.append((char) byteCompactionData[i]);
                                                break;
                                            }
                                        } else {
                                            priorToShiftMode = subMode;
                                            subMode = Mode.PUNCT_SHIFT;
                                            break;
                                        }
                                    } else {
                                        subMode = Mode.ALPHA;
                                        break;
                                    }
                                } else {
                                    subMode = Mode.LOWER;
                                    break;
                                }
                            } else {
                                ch = ' ';
                                break;
                            }
                        } else {
                            subMode = Mode.PUNCT;
                            break;
                        }
                    } else {
                        ch = MIXED_CHARS[subModeCh];
                        break;
                    }
                    break;
                case 4:
                    if (subModeCh >= 29) {
                        if (subModeCh != 29) {
                            if (subModeCh != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                if (subModeCh == 900) {
                                    subMode = Mode.ALPHA;
                                    break;
                                }
                            } else {
                                result.append((char) byteCompactionData[i]);
                                break;
                            }
                        } else {
                            subMode = Mode.ALPHA;
                            break;
                        }
                    } else {
                        ch = PUNCT_CHARS[subModeCh];
                        break;
                    }
                    break;
                case 5:
                    subMode = priorToShiftMode;
                    if (subModeCh >= 26) {
                        if (subModeCh != 26) {
                            if (subModeCh == 900) {
                                subMode = Mode.ALPHA;
                                break;
                            }
                        } else {
                            ch = ' ';
                            break;
                        }
                    } else {
                        ch = (char) (subModeCh + 65);
                        break;
                    }
                    break;
                case 6:
                    subMode = priorToShiftMode;
                    if (subModeCh >= 29) {
                        if (subModeCh != 29) {
                            if (subModeCh != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                                if (subModeCh == 900) {
                                    subMode = Mode.ALPHA;
                                    break;
                                }
                            } else {
                                result.append((char) byteCompactionData[i]);
                                break;
                            }
                        } else {
                            subMode = Mode.ALPHA;
                            break;
                        }
                    } else {
                        ch = PUNCT_CHARS[subModeCh];
                        break;
                    }
                    break;
            }
            if (ch != 0) {
                result.append(ch);
            }
        }
    }

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static int byteCompaction(int i, int[] iArr, Charset charset, int i2, StringBuilder sb) {
        int i3;
        int i4;
        int i5;
        int i6 = i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = MACRO_PDF417_TERMINATOR;
        int i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
        int i9 = 928;
        int i10 = 902;
        long j = 900;
        if (i6 == 901) {
            int[] iArr2 = new int[6];
            i3 = i2 + 1;
            int i11 = iArr[i2];
            long j2 = 0;
            boolean z = false;
            int i12 = 0;
            while (true) {
                i4 = iArr[0];
                if (i3 < i4 && !z) {
                    int i13 = i12 + 1;
                    iArr2[i12] = i11;
                    j2 = (j2 * j) + ((long) i11);
                    int i14 = i3 + 1;
                    i11 = iArr[i3];
                    if (i11 == 900 || i11 == 901 || i11 == 902 || i11 == BYTE_COMPACTION_MODE_LATCH_6 || i11 == 928 || i11 == i8 || i11 == i7) {
                        i3 = i14 - 1;
                        i12 = i13;
                        i7 = MACRO_PDF417_TERMINATOR;
                        i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                        z = true;
                    } else if (i13 % 5 != 0 || i13 <= 0) {
                        i3 = i14;
                        i12 = i13;
                        i7 = MACRO_PDF417_TERMINATOR;
                        i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                    } else {
                        for (int i15 = 0; i15 < 6; i15++) {
                            byteArrayOutputStream.write((byte) ((int) (j2 >> ((5 - i15) * 8))));
                        }
                        i3 = i14;
                        i12 = 0;
                        i7 = MACRO_PDF417_TERMINATOR;
                        i8 = BEGIN_MACRO_PDF417_OPTIONAL_FIELD;
                        j = 900;
                        j2 = 0;
                    }
                } else if (i3 == i4 || i11 >= 900) {
                    i5 = i12;
                } else {
                    i5 = i12 + 1;
                    iArr2[i12] = i11;
                }
            }
            if (i3 == i4) {
            }
            i5 = i12;
            for (int i16 = 0; i16 < i5; i16++) {
                byteArrayOutputStream.write((byte) iArr2[i16]);
            }
        } else if (i6 == BYTE_COMPACTION_MODE_LATCH_6) {
            int i17 = i2;
            boolean z2 = false;
            int i18 = 0;
            long j3 = 0;
            while (i17 < iArr[0] && !z2) {
                int i19 = i17 + 1;
                int i20 = iArr[i17];
                if (i20 < 900) {
                    i18++;
                    j3 = (j3 * 900) + ((long) i20);
                    i17 = i19;
                } else {
                    if (i20 != 900 && i20 != 901 && i20 != i10 && i20 != BYTE_COMPACTION_MODE_LATCH_6 && i20 != i9) {
                        if (i20 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                            if (i20 != MACRO_PDF417_TERMINATOR) {
                                i17 = i19;
                            }
                            i17 = i19 - 1;
                            z2 = true;
                        }
                    }
                    i17 = i19 - 1;
                    z2 = true;
                }
                if (i18 % 5 == 0 && i18 > 0) {
                    for (int i21 = 0; i21 < 6; i21++) {
                        byteArrayOutputStream.write((byte) ((int) (j3 >> ((5 - i21) * 8))));
                    }
                    i18 = 0;
                    j3 = 0;
                }
                i9 = 928;
                i10 = 902;
            }
            i3 = i17;
        } else {
            i3 = i2;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i3;
    }

    private static int numericCompaction(int[] codewords, int code, StringBuilder result) throws FormatException {
        int count = 0;
        boolean end = false;
        int[] numericCodewords = new int[15];
        while (code < codewords[0] && !end) {
            int codeIndex = code + 1;
            int code2 = codewords[code];
            if (codeIndex == codewords[0]) {
                end = true;
            }
            if (code2 < 900) {
                numericCodewords[count] = code2;
                count++;
            } else if (code2 == 900 || code2 == 901 || code2 == BYTE_COMPACTION_MODE_LATCH_6 || code2 == 928 || code2 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || code2 == MACRO_PDF417_TERMINATOR) {
                codeIndex--;
                end = true;
            }
            if ((count % 15 == 0 || code2 == 902 || end) && count > 0) {
                result.append(decodeBase900toBase10(numericCodewords, count));
                count = 0;
            }
            code = codeIndex;
        }
        return code;
    }

    private static String decodeBase900toBase10(int[] codewords, int count) throws FormatException {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < count; i++) {
            result = result.add(EXP900[(count - i) - 1].multiply(BigInteger.valueOf((long) codewords[i])));
        }
        String bigInteger = result.toString();
        String resultString = bigInteger;
        if (bigInteger.charAt(0) == '1') {
            return resultString.substring(1);
        }
        throw FormatException.getFormatInstance();
    }
}
