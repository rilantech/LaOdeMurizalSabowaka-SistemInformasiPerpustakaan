package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class MultiFormatUPCEANReader extends OneDReader {
    private final UPCEANReader[] readers;

    public MultiFormatUPCEANReader(Map<DecodeHintType, ?> hints) {
        Collection<BarcodeFormat> possibleFormats;
        if (hints == null) {
            possibleFormats = null;
        } else {
            possibleFormats = (Collection) hints.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        Collection<UPCEANReader> readers2 = new ArrayList<>();
        if (possibleFormats != null) {
            if (possibleFormats.contains(BarcodeFormat.EAN_13)) {
                readers2.add(new EAN13Reader());
            } else if (possibleFormats.contains(BarcodeFormat.UPC_A)) {
                readers2.add(new UPCAReader());
            }
            if (possibleFormats.contains(BarcodeFormat.EAN_8)) {
                readers2.add(new EAN8Reader());
            }
            if (possibleFormats.contains(BarcodeFormat.UPC_E)) {
                readers2.add(new UPCEReader());
            }
        }
        if (readers2.isEmpty()) {
            readers2.add(new EAN13Reader());
            readers2.add(new EAN8Reader());
            readers2.add(new UPCEReader());
        }
        this.readers = (UPCEANReader[]) readers2.toArray(new UPCEANReader[readers2.size()]);
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Collection collection;
        int[] findStartGuardPattern = UPCEANReader.findStartGuardPattern(bitArray);
        UPCEANReader[] uPCEANReaderArr = this.readers;
        boolean z = false;
        int i2 = 0;
        while (i2 < uPCEANReaderArr.length) {
            try {
                Result decodeRow = uPCEANReaderArr[i2].decodeRow(i, bitArray, findStartGuardPattern, map);
                boolean z2 = decodeRow.getBarcodeFormat() == BarcodeFormat.EAN_13 && decodeRow.getText().charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                }
                if (collection == null || collection.contains(BarcodeFormat.UPC_A)) {
                    z = true;
                }
                if (!z2 || !z) {
                    return decodeRow;
                }
                Result result = new Result(decodeRow.getText().substring(1), decodeRow.getRawBytes(), decodeRow.getResultPoints(), BarcodeFormat.UPC_A);
                result.putAllMetadata(decodeRow.getResultMetadata());
                return result;
            } catch (ReaderException e) {
                i2++;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset() {
        for (UPCEANReader reset : this.readers) {
            reset.reset();
        }
    }
}
